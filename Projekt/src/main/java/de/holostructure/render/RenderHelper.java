package de.holostructure.render;

import java.util.Random;

import de.holostructure.HoloStruckture;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RenderHelper {

	@SuppressWarnings("deprecation")
	public static void renderBlockAsGhost(IBlockState iblockstate, NBTTagCompound tileentitycompound, BlockPos blockpos, BlockPos structurePos, boolean castToNormal) {
		
	    if (iblockstate != null ? (iblockstate.getBlock() != Blocks.AIR && iblockstate.getBlock() != Blocks.CAVE_AIR) : false) {
	    	
		    	 World world = Minecraft.getInstance().world;
		         
		    	 IBlockState existstate = castToNormal ? Blocks.AIR.getDefaultState() : world.getBlockState(blockpos.add(structurePos));
		    	 
		    	 GlStateManager.pushMatrix();
		         GlStateManager.enableLighting();
		         
		         if (HoloStruckture.render_mode == EnumRendermode.COLOR) {
		        	 if (existstate.getBlock() == iblockstate.getBlock() && !existstate.equals(iblockstate)) {
			        	 GlStateManager.colorMask(true, false, true, true);
			         } else if (!existstate.equals(iblockstate)) {
			        	 GlStateManager.colorMask(true, true, false, true);
			         }
		         }
		         
		         if (!existstate.equals(iblockstate) || HoloStruckture.render_mode == EnumRendermode.NORMAL) {
		        	 
		        	    if (iblockstate.getBlock() instanceof BlockContainer) {
		        	    	
		        	    	TileEntity tileentity = iblockstate.getBlock().createTileEntity(iblockstate, world);
		        	    	
		        	    	if (tileentity != null) {
		        	    		
		        	    		TileEntityRendererDispatcher tileentityrenderdispatcher = TileEntityRendererDispatcher.instance;
			        	    	TileEntityRenderer<TileEntity> tileentityrenderer = tileentityrenderdispatcher.getRenderer(tileentity.getClass());
			        	    	
			        	    	if (tileentityrenderer != null) {
			        	    		
			        	    		World tileentityworld = Minecraft.getInstance().world;
				        	    	if (tileentitycompound != null) tileentity.read(tileentitycompound);
				        	    	tileentity.setWorld(tileentityworld);
				        	    	tileentity.setPos(blockpos.add(structurePos));
				        	    	IBlockState oldstate = tileentityworld.getBlockState(blockpos.add(structurePos));
				        	    	tileentityworld.setBlockState(blockpos.add(structurePos), iblockstate);
				        	    	tileentity.markDirty();
				        	    	tileentityworld.setBlockState(blockpos.add(structurePos), oldstate);
				        	    	
				        	    	try {

					        	    	tileentityrenderer.render(tileentity, blockpos.getX(), blockpos.getY(), blockpos.getZ(), 0, -1);
				        	    		
				        	    	} catch (IllegalArgumentException e) {}
				        	    	
 			        	    	}
		        	    		
		        	    	}
		        	    	
		        	    }
		        	 
		        	 	Minecraft.getInstance().getRenderManager().textureManager.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		        	 	
		        	 	Tessellator tessellator = Tessellator.getInstance();
		        	 	BufferBuilder bufferbuilder = tessellator.getBuffer();
			         	bufferbuilder.begin(7, DefaultVertexFormats.BLOCK);
			         
			         	BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
			         	blockrendererdispatcher.getBlockModelRenderer().renderModel(world, blockrendererdispatcher.getModelForState(iblockstate), iblockstate, blockpos, bufferbuilder, false, new Random(), iblockstate.getPositionRandom(blockpos));
			         	
			         	tessellator.draw();
		        	 
		         }

	        	 GlStateManager.colorMask(true, true, true, true);
		         
		         GlStateManager.popMatrix();
		         
	    }
		
	    
	}
	
	public static enum EnumRendermode {
		
		COLOR("color"),NORMAL("normal"),INVISIBILITY("invisibility");
		
		public String name;
		
		private EnumRendermode(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public EnumRendermode nextMode() {
			if (this == COLOR) {
				return NORMAL;
			} else if (this == NORMAL) {
				return INVISIBILITY;
			} else if (this == INVISIBILITY) {
				return COLOR;
			}
			return COLOR;
		}
		
	}
	
}
