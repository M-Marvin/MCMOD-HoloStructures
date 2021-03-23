package de.holostructure.util;

import com.mojang.blaze3d.matrix.MatrixStack;

import de.holostructure.HoloStruckture;
import de.holostructure.gui.GuiSchematicManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Events {

	@SuppressWarnings("resource")
	@SubscribeEvent
	public void onRenderEvent(net.minecraftforge.client.event.RenderWorldLastEvent event) {
		
		if (HoloStruckture.displaySchematics) {
			
			MatrixStack matrixStackIn = event.getMatrixStack();
			
			PlayerEntity player = Minecraft.getInstance().player;
			matrixStackIn.push();
    	 	matrixStackIn.translate(-player.lastTickPosX, -player.lastTickPosY - player.getEyeHeight(), -player.lastTickPosZ);
			
			for (SchematicStruckture struc : HoloStruckture.schematicStrucktures) {
				
				if (struc != null) {
					struc.render(matrixStackIn, Minecraft.getInstance().getRenderTypeBuffers().getBufferSource(), event.getPartialTicks());
				}
				
			}
			
			matrixStackIn.pop();
			
		}
		
	}
	
	@SubscribeEvent
	public void onKeyTyped(net.minecraftforge.client.event.InputEvent event) {
		
		if (HoloStruckture.openSchematicManager.isKeyDown()) {
			Minecraft.getInstance().displayGuiScreen(new GuiSchematicManager());
		} else if (HoloStruckture.toggleSchematics.isKeyDown()) {
			HoloStruckture.displaySchematics = !HoloStruckture.displaySchematics;
		}
		
	}
	
}
