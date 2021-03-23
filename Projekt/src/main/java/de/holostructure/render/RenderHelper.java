package de.holostructure.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import de.holostructure.HoloStruckture;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RenderHelper {
	
	@SuppressWarnings({ "deprecation", "resource" })
	public static void renderHoloBlock(BlockState iblockstate, CompoundNBT tileentitycompound, BlockPos blockpos, BlockPos structurePos, boolean castToNormal, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, float partialTicks) {
		
		if (iblockstate != null ? (iblockstate.getBlock() != Blocks.AIR && iblockstate.getBlock() != Blocks.CAVE_AIR) : false) {
						
			World world = Minecraft.getInstance().world;
			BlockState existstate = castToNormal ? Blocks.AIR.getDefaultState() : world.getBlockState(blockpos.add(structurePos));
					
			Minecraft.getInstance().getRenderManager().textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
		 	
			if (HoloStruckture.render_mode == EnumRendermode.COLOR) {
				if (existstate.getBlock() == iblockstate.getBlock() && !existstate.equals(iblockstate)) {
					GlStateManager.colorMask(true, false, true, true);
				} else if (!existstate.equals(iblockstate)) {
					GlStateManager.colorMask(true, true, false, true);
				}
			}
			
			if (!existstate.equals(iblockstate) || HoloStruckture.render_mode == EnumRendermode.NORMAL) {

				//int combinedLightIn = WorldRenderer.getCombinedLight(Minecraft.getInstance().world, blockpos);
				int combinedOverlayIn = OverlayTexture.NO_OVERLAY;
				BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
				
				for (net.minecraft.client.renderer.RenderType type : net.minecraft.client.renderer.RenderType.getBlockRenderTypes()) {
					if (RenderTypeLookup.canRenderInLayer(iblockstate, type)) {
						
						net.minecraftforge.client.ForgeHooksClient.setRenderLayer(type);
						
						matrixStackIn.push();
						matrixStackIn.translate(blockpos.getX(), blockpos.getY(), blockpos.getZ());

						if (iblockstate.getBlock().hasTileEntity(iblockstate)) {
							
							TileEntity tileentity = iblockstate.getBlock().createTileEntity(iblockstate, world);
							
							if (tileentity != null) {
								
								TileEntityRendererDispatcher tileentityrenderdispatcher = TileEntityRendererDispatcher.instance;
								
								World tileentityworld = Minecraft.getInstance().world;
								if (tileentitycompound != null) tileentity.deserializeNBT(tileentitycompound);;
								tileentity.setWorldAndPos(tileentityworld, blockpos.add(structurePos));
								BlockState oldstate = tileentityworld.getBlockState(blockpos.add(structurePos));
								tileentityworld.setBlockState(blockpos.add(structurePos), iblockstate);
								
								try {
									tileentityrenderdispatcher.renderTileEntity(tileentity, partialTicks, matrixStackIn, bufferIn);
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								}
								
								tileentityworld.setBlockState(blockpos.add(structurePos), oldstate);
																
							}
							
						}
						
						blockrendererdispatcher.getBlockModelRenderer().renderModel(world, blockrendererdispatcher.getModelForState(iblockstate), iblockstate, blockpos.add(structurePos), matrixStackIn, bufferIn.getBuffer(type), false, world.rand, iblockstate.getPositionRandom(blockpos), combinedOverlayIn);
						
						matrixStackIn.pop();
						
					}
					
				}
				
			}
			net.minecraftforge.client.ForgeHooksClient.setRenderLayer(null);
			
			GlStateManager.colorMask(true, true, true, true);
			
		}
		
	}
	
	@SuppressWarnings({ "resource", "deprecation" })
	public static void renderHoloTileEntity(BlockState iblockstate, CompoundNBT tileentitycompound, BlockPos blockpos, BlockPos structurePos, boolean castToNormal, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, float partialTicks) {
		
		if (iblockstate != null ? (iblockstate.getBlock() != Blocks.AIR && iblockstate.getBlock() != Blocks.CAVE_AIR) : false) {
						
			World world = Minecraft.getInstance().world;
			BlockState existstate = castToNormal ? Blocks.AIR.getDefaultState() : world.getBlockState(blockpos.add(structurePos));
					
			Minecraft.getInstance().getRenderManager().textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
		 	
			if (HoloStruckture.render_mode == EnumRendermode.COLOR) {
				if (existstate.getBlock() == iblockstate.getBlock() && !existstate.equals(iblockstate)) {
					GlStateManager.colorMask(true, false, true, true);
				} else if (!existstate.equals(iblockstate)) {
					GlStateManager.colorMask(true, true, false, true);
				}
			}
			
			if (!existstate.equals(iblockstate) || HoloStruckture.render_mode == EnumRendermode.NORMAL) {
				
			}
			
			GlStateManager.colorMask(true, true, true, true);
			
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
