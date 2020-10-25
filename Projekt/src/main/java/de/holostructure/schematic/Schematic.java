package de.holostructure.schematic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;

public class Schematic {

	private int size;
	private short width;
	private short height;
	private short length;
	private boolean oldVersion;
	private HashMap<Integer, String> palette;
	private BlockObject[] blockObjects;
	private List<NBTTagCompound> tileentitys;
	
	public Schematic(File file) {
		try {
			
			String format = file.getName().split("\\.")[file.getName().split("\\.").length - 1];
			
			InputStream is = new FileInputStream(file);
			NBTTagCompound nbtdata = CompressedStreamTools.readCompressed(is);
			is.close();
			
			if (format.equals("nbt")) {
				
				NBTTagList sizetags = nbtdata.getList("size", 3);
				
				width = (short) sizetags.getInt(0);
				height = (short) sizetags.getInt(1);
				length = (short) sizetags.getInt(2);
				size = width * height * length;
				
				this.palette = new HashMap<>();
				NBTTagList paletteTags = nbtdata.getList("palette", 10);
				
				for (int i = 0; i < paletteTags.size(); i++) {
					
					NBTTagCompound entrynbt = paletteTags.getCompound(i);
					
					String state = entrynbt.getString("Name");
					
					if (entrynbt.hasKey("Properties")) {
						
						state += "[";
						
						NBTTagCompound propertiesNbt = entrynbt.getCompound("Properties");
						
						for (String property : propertiesNbt.keySet()) {
							state += property + "=" + propertiesNbt.getString(property) + ",";
						}
						
						state = state.substring(0, state.length() - 1) + "]";
						
					}
					
					palette.put(i, state);
					
				}
				
				NBTTagList blockTags = nbtdata.getList("blocks", 10);
				blockObjects = new BlockObject[size];
				tileentitys = new ArrayList<>();
				int counter = 0;
				
				for (int i = 0; i < blockTags.size(); i++) {
					
					NBTTagCompound blocknbt = blockTags.getCompound(i);
					
					NBTTagList ipos = blocknbt.getList("pos", 3);
					BlockPos pos = new BlockPos(ipos.getInt(0), ipos.getInt(1), ipos.getInt(2));
					
					int stateId = blocknbt.getInt("state");
					IBlockState state = getStateFromID(stateId);
					
					blockObjects[counter++] = new BlockObject(pos, state);
					
					if (blocknbt.hasKey("nbt")) {
						
						NBTTagCompound tileentitynbt = blocknbt.getCompound("nbt");
						tileentitynbt.setIntArray("Pos", new int[] {pos.getX(), pos.getY(), pos.getZ()});
						tileentitys.add(tileentitynbt);
						
					}
					
				}
				
			} else {
				
				width = nbtdata.getShort("Width");
				height = nbtdata.getShort("Height");
				length = nbtdata.getShort("Length");
				size = width * height * length;
				this.oldVersion = !nbtdata.hasKey("DataVersion");
				
				blockObjects = new BlockObject[size];
				
				if (!oldVersion) {
					byte[] blocks = nbtdata.getByteArray("BlockData");
					
					NBTTagCompound palette = nbtdata.getCompound("Palette");
					this.palette = new HashMap<Integer, String>();
					for (String k : palette.keySet()) {
						this.palette.put(palette.getInt(k), k);
					}
					
					int counter = 0;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < length; j++) {
							for (int k = 0; k < width; k++) {
								
								BlockPos pos = new BlockPos(k, i , j);

								int id = blocks[counter];
								
								if (id < 0) id *= -1;
								
								IBlockState state = getStateFromID(id);
								
								blockObjects[counter] = new BlockObject(pos, state);
								
								counter++;
								
							}
						}
		 			}
					
					NBTTagList tileentitynbtlist = nbtdata.getList("BlockEntities", 10);
					this.tileentitys = new ArrayList<NBTTagCompound>();
					
					for (int i = 0; i < tileentitynbtlist.size(); i++) {
						this.tileentitys.add(tileentitynbtlist.getCompound(i));
					}
					
				} else {
					
					byte[] blockIDs_byte = nbtdata.getByteArray("Blocks");
					int[] blockIDs = new int[size];
					for (int x = 0; x < blockIDs_byte.length; x++) {
						blockIDs[x] = Byte.toUnsignedInt(blockIDs_byte[x]);
					}
					
					byte[] metadata = nbtdata.getByteArray("Data");
					
					int counter = 0;
					for (int i = 0; i < height; i++) {
						for (int j = 0; j < length; j++) {
							for (int k = 0; k < width; k++) {
								BlockPos pos = new BlockPos(k, i , j);
								IBlockState state = getStateFromOldIds(blockIDs[counter], metadata[counter]);
								blockObjects[counter] = new BlockObject(pos, state);
								counter++;
							}
						}
		 			}
					
					NBTTagList tileentitynbtlist = nbtdata.getList("TileEntities", 10);
					this.tileentitys = new ArrayList<NBTTagCompound>();
					
					for (int i = 0; i < tileentitynbtlist.size(); i++) {
						
						NBTTagCompound compound = tileentitynbtlist.getCompound(i);
						int i1 = compound.getInt("x");
						int i2 = compound.getInt("y");
						int i3 = compound.getInt("z");
						compound.setIntArray("Pos", new int[] {i1, i2, i3});
						this.tileentitys.add(compound);
						
					}
					
				}
				
			}
			
		} catch (Exception e) {
			System.err.println("ERROR Cant load as Schematic: " + file);
			e.printStackTrace();
			this.width = 0;
			this.height = 0;
			this.length = 0;
			this.size = 0;
			this.blockObjects = null;
			this.palette = null;
			this.tileentitys = null;
		}
	}
	
	public boolean isOldVersion() {
		return oldVersion;
	}
	
	private IBlockState getStateFromOldIds(int blockID, byte meta) {
		IBlockState state = Block.getStateById(blockID);
		// TODO WARNING: This a Method that only load Blocks that found under the given ID!
		return state;
	}
	
	public IBlockState getBlockState(BlockPos pos) {
		
		for (BlockObject obj : this.blockObjects) {
			if (obj.getPosition().equals(pos)) return obj.getState();
		}
		return Blocks.AIR.getDefaultState();
		
	}
	
	public int getSize() {
		return size;
	}
	
	public BlockObject[] getBlocks() {
		return blockObjects;
	}
	
	public IBlockState getStateFromID(int id) {

		String iblockstateS = this.palette.get(id);
		
		try {
			
			BlockStateParser parser = new BlockStateParser(new StringReader(iblockstateS), true);
			parser.parse(false);

			return parser.getState();
			
		} catch (CommandSyntaxException e) {
			System.out.println("Warning! block " + iblockstateS + " nicht gefunden!");
			return Blocks.AIR.getDefaultState();
		}
		
	}
	
	public List<NBTTagCompound> getTileEntities() {
		return this.tileentitys;
	}
	
	public NBTTagCompound getTileEntity(BlockPos pos) {
		
		for (NBTTagCompound compound : this.tileentitys) {
			
			int[] pos1 = compound.getIntArray("Pos");
			
			if (pos1[0] == pos.getX() && pos1[1] == pos.getY() && pos1[2] == pos.getZ()) {
				
				return compound;
				
			}
			
		}
		
		return null;
		
	}
	
	public short getWidth() {
		return width;
	}
	
	public short getHeight() {
		return height;
	}
	
	public short getLength() {
		return length;
	}
	
}
