package de.holostructure.util;

import de.holostructure.HoloStruckture;
import de.holostructure.gui.GuiSchematicManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class Events {

	@SubscribeEvent
	public void onRenderEvent(net.minecraftforge.client.event.RenderWorldLastEvent event) {
		
		if (HoloStruckture.displaySchematics) {
			
			for (SchematicStruckture struc : HoloStruckture.schematicStrucktures) {
				
				if (struc != null) {
					struc.render();
				}
				
			}
			
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
