package de.holostructure;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import de.holostructure.render.RenderHelper.EnumRendermode;
import de.holostructure.util.Events;
import de.holostructure.util.SchematicStruckture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("holostructure")
public class HoloStruckture {
	
	private static final Logger LOGGER = LogManager.getLogger();
    public static SchematicStruckture[] schematicStrucktures;
    public static KeyBinding openSchematicManager = new KeyBinding("key.openschematicmenu", GLFW.GLFW_KEY_P, "kategory.schematica");
    public static KeyBinding toggleSchematics = new KeyBinding("key.toggleschematics", GLFW.GLFW_KEY_O, "kategory.schematica");
    public static boolean displaySchematics;
    public static File schematicsPath;
    public static final String MODID = "holostructures";
	public static EnumRendermode render_mode;
	public static int lastEditedStructureId;
	
    public HoloStruckture() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(new Events());
    }

    @SuppressWarnings("resource")
	private void setup(final FMLCommonSetupEvent event)
    {
        
    	lastEditedStructureId = 0;
    	render_mode = EnumRendermode.NORMAL;
    	schematicStrucktures = new SchematicStruckture[5];
    	File gameDir = new File(Minecraft.getInstance().gameDir.getAbsolutePath());
    	schematicsPath = new File(gameDir, "config/Schematics/");
    	if (!schematicsPath.exists()) {
    		schematicsPath.mkdirs();
    		LOGGER.info("Schematics Directory createt: " + schematicsPath.getAbsolutePath());
    	}
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    	ClientRegistry.registerKeyBinding(openSchematicManager);
    	ClientRegistry.registerKeyBinding(toggleSchematics);
    	
    }
    
}