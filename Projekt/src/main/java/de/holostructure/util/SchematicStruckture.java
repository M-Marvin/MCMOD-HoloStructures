package de.holostructure.util;

import java.io.File;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.holostructure.HoloStruckture;
import de.holostructure.render.RenderHelper;
import de.holostructure.schematic.BlockObject;
import de.holostructure.schematic.Schematic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;

public class SchematicStruckture {

	public Schematic schematic;
	public int posX = 0;
	public int posY = 0;
	public int posZ = 0;
	public Mirror mirror = Mirror.NONE;
	public Rotation rotation = Rotation.NONE;
	public File file = null;
	VisibleMode visible = VisibleMode.ALL;
	int visible_level = 1;
	int listId;
	boolean hasChanged;
	boolean activateRenderBuffer;
	
	public static boolean createStructure(int id, File file, BlockPos pos) {
		
    	try {
    		SchematicStruckture struc = new SchematicStruckture(pos.getX(), pos.getY(), pos.getZ(), file, id);
    		HoloStruckture.schematicStrucktures[id] = struc;
        	return true;
    	} catch(Exception e) {
    		return false;
    	}
    	
	}
	
	public static void updateStruckrure(int id, BlockPos pos, VisibleMode visibleMode, Mirror mirror, Rotation rotation, int visible_level, boolean enableRBO) {
		if (HoloStruckture.schematicStrucktures[id] != null) {
			HoloStruckture.schematicStrucktures[id].setVisible(visibleMode);
			HoloStruckture.schematicStrucktures[id].setPosition(pos);
			HoloStruckture.schematicStrucktures[id].setMirror(mirror);
			HoloStruckture.schematicStrucktures[id].setRotation(rotation); 
			HoloStruckture.schematicStrucktures[id].setVisibleLevel(visible_level);
			HoloStruckture.schematicStrucktures[id].activateRenderBuffer(enableRBO);
		}
	}
	
	public static void updateAllStructures() {
		for (SchematicStruckture struc : HoloStruckture.schematicStrucktures) {
			if (struc != null) struc.update();
		}
	}
 	
	public SchematicStruckture(int posX, int posY, int posZ, File file, int listId) {
		
		this.hasChanged = true;
		this.file = file;
		this.schematic = new Schematic(file);
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		
	}
	
	public void update() {
		this.hasChanged = true;
	}
	
	public VisibleMode getVisibleMode() {
		return visible;
	}
	
	public int getHeight() {
		return this.schematic.getHeight();
	}
	
	public int getLength() {
		return this.schematic.getLength();
	}
	
	public int getWidth() {
		return this.schematic.getWidth();
	}
	
	public Schematic getSchematic() {
		return this.schematic;
	}
	
	public File getFile() {
		return this.file;
	}
	
	public void setVisible(VisibleMode visibleMode) {
		if (this.visible != visibleMode) this.hasChanged = true;
		this.visible = visibleMode;
	}
	
	public boolean isVisible() {
		return visible == VisibleMode.ALL || visible == VisibleMode.LEVEL;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getPosZ() {
		return posZ;
	}
	
	public void setMirror(Mirror mirror) {
		if (this.mirror != mirror) this.hasChanged = true;
		this.mirror = mirror;
	}
	
	public void setRotation(Rotation rotation) {
		if (this.rotation != rotation) this.hasChanged = true;
		this.rotation = rotation;
	}
	
	public void setVisibleLevel(int visible_level) {
		if (this.visible_level != visible_level) this.hasChanged = true;
		this.visible_level = visible_level;
	}
	
	public boolean isDisplayAll() {
		return visible == VisibleMode.ALL;
	}
	
	public int getVisibleLevel() {
		return visible_level;
	}
	
	public Mirror getMirror() {
		return mirror != null ? mirror : Mirror.NONE;
	}
	
	public Rotation getRotation() {
		return rotation != null ? rotation : Rotation.NONE;
	}
	
	public void setPosition(BlockPos pos) {
		//hasChanged update not needed!
		this.posX = pos.getX();
		this.posY = pos.getY();
		this.posZ = pos.getZ();
	}
	
	public void setFile(File file) {
		if (this.file != file) this.hasChanged = true;
		this.file = file;
		this.schematic = new Schematic(file);
	}
	
	public void activateRenderBuffer(boolean activate) {
		if (!this.activateRenderBuffer && activate) this.hasChanged = true;
		this.activateRenderBuffer = activate;
	}
	
	public boolean isRenderBufferEnabled() {
		return this.activateRenderBuffer;
	}
	
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, float partialTicks) {
		
		if (this.isVisible() && Minecraft.getInstance().world.isRemote) {
			
			if (!this.hasChanged && this.activateRenderBuffer) {
				// TODO RBO not working
				matrixStackIn.push();
				matrixStackIn.translate(posX, posY, posZ);
				GL11.glCallList(this.listId);
				matrixStackIn.pop();
			} else {
				
				if (this.activateRenderBuffer) {
					// TODO: RBO not working
					if (this.listId != 0) GL11.glDeleteLists(this.listId, 1);
					this.listId = GL11.glGenLists(1);
					matrixStackIn.push();
					GL11.glNewList(this.listId, GL11.GL_COMPILE);
					renderBlockObjects(matrixStackIn, bufferIn, partialTicks);
					GL11.glEndList();
					matrixStackIn.pop();
					this.hasChanged = false;
				} else {
					matrixStackIn.push();
					matrixStackIn.translate(posX, posY, posZ);
					renderBlockObjects(matrixStackIn, bufferIn, partialTicks);
					matrixStackIn.pop();
				}
				
			}
			
		}
		
		
		
	}
	
	@SuppressWarnings({ "resource", "deprecation" })
	protected void renderBlockObjects(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, float partialTicks) {
		
		BlockObject[] blocks = schematic.getBlocks();
		
		BlockPos newPos = BlockPos.ZERO;
		BlockState newState = Blocks.AIR.getDefaultState();
		try {
			matrixStackIn.push();
			for (BlockObject obj : blocks) {
				
				boolean flag = obj.getPosition().getY() == this.visible_level - 1 || this.isDisplayAll();

				double dx = Math.max(this.posX, Minecraft.getInstance().player.getPosX()) - Math.min(this.posX, Minecraft.getInstance().player.getPosX());
				double dz = Math.max(this.posZ, Minecraft.getInstance().player.getPosZ()) - Math.min(this.posZ, Minecraft.getInstance().player.getPosZ());
				int distance = (int) Math.max(dx, dz);
				
				if (flag && distance < Minecraft.getInstance().gameSettings.renderDistanceChunks * 16) {
					
					newPos = calculatePositionOffset(transformBlockPos(obj.getPosition(), mirror, rotation, BlockPos.ZERO));
					newState = obj.getState().mirror(mirror != null ? mirror : Mirror.NONE).rotate(rotation != null ? rotation : Rotation.NONE);
					
					CompoundNBT tileentityCompound = schematic.getTileEntity(obj.getPosition());
					
					RenderHelper.renderHoloBlock(newState, tileentityCompound, newPos, new BlockPos(posX, posY, posZ), this.activateRenderBuffer, matrixStackIn, bufferIn, partialTicks);
					
				}
				
			}
			matrixStackIn.pop();
		} catch (Exception e) {
	         CrashReport crashreport = CrashReport.makeCrashReport(e, "Tesselating Holoblock model");
	         CrashReportCategory crashreportcategory = crashreport.makeCategory("Holoblock model being tesselated");
	         CrashReportCategory.addBlockInfo(crashreportcategory, newPos, newState);
	         throw new ReportedException(crashreport);
		}
		
		// Without this BoundingBox call, the last 2 tesselated blocks have not the correct position
		WorldRenderer.drawBoundingBox(matrixStackIn, bufferIn.getBuffer(RenderType.getLines()), 0, 0, 0, 0, 0, 0, 1F, 1F, 1F, 1F);
		
	}
	
	public BlockPos calculatePositionOffset(BlockPos pos) {
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		if (mirror == Mirror.NONE) {
			if (rotation == Rotation.NONE) {
				
			} else if (rotation == Rotation.CLOCKWISE_90) {
				x += schematic.getLength() - 1;
			} else if (rotation == Rotation.CLOCKWISE_180) {
				x += schematic.getWidth() - 1;
				z += schematic.getLength() - 1;
			} else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
				z += schematic.getWidth() - 1;
			}
		} else if (mirror == Mirror.LEFT_RIGHT) {
			if (rotation == Rotation.NONE) {
				z += schematic.getLength() - 1;
			} else if (rotation == Rotation.CLOCKWISE_90) {
				
			} else if (rotation == Rotation.CLOCKWISE_180) {
				x += schematic.getWidth() - 1;
			} else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
				x += schematic.getLength() - 1;
				z += schematic.getWidth() - 1;
			}
		} else if (mirror == Mirror.FRONT_BACK) {
			if (rotation == Rotation.NONE) {
				x += schematic.getWidth() - 1;
			} else if (rotation == Rotation.CLOCKWISE_90) {
				x += schematic.getLength() - 1;
				z += schematic.getWidth() - 1;
			} else if (rotation == Rotation.CLOCKWISE_180) {
				z += schematic.getLength() - 1;
			} else if (rotation == Rotation.COUNTERCLOCKWISE_90) {
				
			}
		}
		
		return new BlockPos(x, y, z);
		
	}
	
	public static BlockPos transformBlockPos(BlockPos targetPos, Mirror mirrorIn, Rotation rotationIn, BlockPos offset) {
		
		  int i = targetPos.getX();
	      int j = targetPos.getY();
	      int k = targetPos.getZ();
	      boolean flag = true;
	      switch(mirrorIn != null ? mirrorIn : Mirror.NONE) {
	      case LEFT_RIGHT:
	         k = -k;
	         break;
	      case FRONT_BACK:
	         i = -i;
	         break;
	      default:
	         flag = false;
	      }
	      
	      int l = offset.getX();
	      int i1 = offset.getZ();
	      switch(rotationIn != null ? rotationIn : Rotation.NONE) {
	      case COUNTERCLOCKWISE_90:
	         return new BlockPos(l - i1 + k, j, l + i1 - i);
	      case CLOCKWISE_90:
	         return new BlockPos(l + i1 - k, j, i1 - l + i);
	      case CLOCKWISE_180:
	         return new BlockPos(l + l - i, j, i1 + i1 - k);
	      default:
	         return flag ? new BlockPos(i, j, k) : targetPos;
	      }
	      
	}
	
	public static enum VisibleMode {
		
		ALL(),NONE(),LEVEL();
		
		public VisibleMode nextMode() {
			
			if (this == ALL) return LEVEL;
			if (this == LEVEL) return NONE;
			return ALL;
			
		}
		
	}
	
}
