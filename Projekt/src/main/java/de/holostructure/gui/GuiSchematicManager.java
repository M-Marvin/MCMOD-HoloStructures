package de.holostructure.gui;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.holostructure.HoloStruckture;
import de.holostructure.util.SchematicStruckture;
import de.holostructure.util.SchematicStruckture.VisibleMode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiSchematicManager extends GuiScreen {
	
	public GuiButton[] schematic_selector;
	public GuiButton select_schmatic;
	public GuiButton visibility;
	public GuiTextField schematic_name;
	public GuiTextField schematic_x;
	public GuiTextField schematic_y;
	public GuiTextField schematic_z;
	public GuiButton xUp;
	public GuiButton xDown;
	public GuiButton yUp;
	public GuiButton yDown;
	public GuiButton zUp;
	public GuiButton zDown;
	public GuiButton mirrorMode;
	public GuiButton rotationMode;
	public GuiButton renderMod;
	public Mirror mirror;
	public Rotation rotation;
	public GuiTextField schematic_visible_level;
	public GuiButton levelUp;
	public GuiButton levelDown;
	public GuiButton enableRBO;
	
	public boolean RBOenabled;
	public int selected_schematic;
	public VisibleMode schematic_visibility;
	public int select_x;
	public int select_y;
	public int select_width;
	public int select_heigth;
	public int button_distance;
	public int maxLevel;
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		
		Color color_line = new Color(64, 64, 64);
		Color color_fill = new Color(64, 64, 64, 120);
		Color color_selcted = new Color(14, 190, 5, 120);
		Color color_unselcted = new Color(188, 1, 23, 120);
		
		drawRect(122, 0, 120, this.height, color_line.getRGB());
		drawRect(120, 0, 0, this.height, color_fill.getRGB());
		drawRect(122, 0, this.width, 40, color_fill.getRGB());
		drawRect(122, 40, this.width, 42, color_line.getRGB());
		drawRect(0, 150, 120, 152, color_line.getRGB());
		drawRect(this.width - 122, 40, this.width - 120, this.height, color_line.getRGB());
		drawRect(this.width - 120, 40, this.width, this.height, color_fill.getRGB());
		
		for (int index = 0; index < 5; index++) {
			
			int i1 =  select_y + (select_heigth + button_distance) * index;
			int i2 =  select_y + (select_heigth + button_distance) * selected_schematic;
			drawRect(select_x + select_width, i1, select_x + select_width + 10, i1 + select_heigth, i1 == i2 ? color_selcted.getRGB() : color_unselcted.getRGB());
			
		}
		
		this.schematic_name.drawTextField(mouseX, mouseY, partialTicks);
		this.schematic_x.drawTextField(mouseX, mouseY, partialTicks);
		this.schematic_y.drawTextField(mouseX, mouseY, partialTicks);
		this.schematic_z.drawTextField(mouseX, mouseY, partialTicks);
		this.schematic_visible_level.drawTextField(mouseX, mouseY, partialTicks);

		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.rendermode").getString(), 10, 158, new Color(255, 255, 255).getRGB());
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.schematicslots").getString(), 10, 7, new Color(255, 255, 255).getRGB());
		
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.mirror").getString(), this.width - 110, 47, new Color(255, 255, 255).getRGB());
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.rotation").getString(), this.width - 110, 92, new Color(255, 255, 255).getRGB());
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.position").getString(), this.width - 110, 137, new Color(255, 255, 255).getRGB());
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.displaylevel").getString(), this.width - 110, 195, new Color(255, 255, 255).getRGB());
		
		drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.madeby").getString() + "M_Marvin", 6, 240, new Color(200, 200, 200).getRGB());
		
		if (HoloStruckture.schematicStrucktures[this.selected_schematic] != null ? HoloStruckture.schematicStrucktures[this.selected_schematic].getSchematic().isOldVersion() : false) {
			
			drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.warnoldversion").getString(), 130, 32, new Color(255, 0, 0).getRGB());
			
			if (mouseX > 130 && mouseY < 40) {
				List<String> info = new ArrayList<String>();
				info.add(new TextComponentTranslation("warninginfo.line1").getString());
				info.add(new TextComponentTranslation("warninginfo.line2").getString());
				info.add(new TextComponentTranslation("warninginfo.line3").getString());
				info.add(new TextComponentTranslation("warninginfo.line4").getString());
				info.add(new TextComponentTranslation("warninginfo.line5").getString());
				info.add(new TextComponentTranslation("warninginfo.line6").getString());
				drawHoveringText(info, 120, 60);
			}
		
		} else {
			
			drawString(Minecraft.getInstance().fontRenderer, new TextComponentTranslation("gui.folderinfo").getString(), 130, 32, new Color(154, 160, 157).getRGB());
			
		}
		
		if (this.enableRBO.isMouseOver()) {
			List<String> info2 = new ArrayList<>();
			info2.add(new TextComponentTranslation("guiinfo.RBO.line1").getString());
			info2.add(new TextComponentTranslation("guiinfo.RBO.line2").getString());
			info2.add(new TextComponentTranslation("guiinfo.RBO.line3").getString());
			info2.add(new TextComponentTranslation("guiinfo.RBO.line4").getString());
			info2.add(new TextComponentTranslation("guiinfo.RBO.line5").getString());
			drawHoveringText(info2, 120, 60);
		}
		
		super.render(mouseX, mouseY, partialTicks);
		
	}
	
	@Override
	protected void initGui() {
		
		this.selected_schematic = HoloStruckture.lastEditedStructureId;
		
		HoloStruckture.displaySchematics = true;
		schematic_visibility = HoloStruckture.schematicStrucktures[this.selected_schematic] != null ? HoloStruckture.schematicStrucktures[this.selected_schematic].getVisibleMode() : VisibleMode.ALL;
		
		select_x = 10;
		select_y = 20;
		select_width = 100;
		select_heigth = 20;
		button_distance = 5;
		
		this.schematic_selector = new GuiButton[5];
		initSchematicSelector(0, select_width, select_heigth, select_x, select_y, button_distance);
		this.addButton(this.schematic_selector[0]);
		initSchematicSelector(1, select_width, select_heigth, select_x, select_y, button_distance);
		this.addButton(this.schematic_selector[1]);
		initSchematicSelector(2, select_width, select_heigth, select_x, select_y, button_distance);
		this.addButton(this.schematic_selector[2]);
		initSchematicSelector(3, select_width, select_heigth, select_x, select_y, button_distance);
		this.addButton(this.schematic_selector[3]);
		initSchematicSelector(4, select_width, select_heigth, select_x, select_y, button_distance);
		this.addButton(this.schematic_selector[4]);
		
		this.select_schmatic = new GuiButton(10, 130, 10, 120, 20, new TextComponentTranslation("gui.select_schematic.path").getString()) {
			@Override
			public void onClick(double mouseX, double mouseY) {
				
				GuiScreen gui = Minecraft.getInstance().currentScreen;
				if (gui instanceof GuiSchematicManager) {
					
					File schematic = new File(HoloStruckture.schematicsPath, GuiSchematicManager.this.schematic_name.getText());
					
					if (schematic.exists()) {
						
						BlockPos creatorPos = new BlockPos(Minecraft.getInstance().player);
						
						SchematicStruckture.createStructure(GuiSchematicManager.this.selected_schematic, schematic, creatorPos);
						
						GuiSchematicManager.this.schematic_x.setText("" + creatorPos.getX());
						GuiSchematicManager.this.schematic_y.setText("" + creatorPos.getY());
						GuiSchematicManager.this.schematic_z.setText("" + creatorPos.getZ());
						
					}
					
				}
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.select_schmatic);
		this.visibility = new GuiButton(11, 10, 170, 100, 20, new TextComponentTranslation("gui.visibility").getString()) {
			@Override
			public void onClick(double mouseX, double mouseY) {
				
				GuiSchematicManager.this.schematic_visibility = GuiSchematicManager.this.schematic_visibility.nextMode();
				
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.visibility);
		this.renderMod = new GuiButton(16, 10, 195, 100, 20, new TextComponentTranslation("gui.rendermode." + HoloStruckture.render_mode.getName()).getString()) {
			@Override
			public void onClick(double mouseX, double mouseY) {
				HoloStruckture.render_mode = HoloStruckture.render_mode.nextMode();
				SchematicStruckture.updateAllStructures();
			}
		};
		this.addButton(this.renderMod);
		this.enableRBO = new GuiButton(17, 10, 220, 100, 20, new TextComponentTranslation("gui.rbo." + (RBOenabled ? "enabled" : "disabled")).getString()) {
			@Override
			public void onClick(double mouseX, double mouseY) {
				GuiSchematicManager.this.RBOenabled = !GuiSchematicManager.this.RBOenabled;
			}
		};
		this.addButton(this.enableRBO);
		
		schematic_name = new GuiTextField(12, Minecraft.getInstance().fontRenderer, 260, 11, 160, 18);
		this.children.add(schematic_name);
		
		
		//Position Buttons
		
		int width = 33;
		int heigth = 18;
		int x = this.width - 110;
		int z = 160;
		
		schematic_x = new GuiTextField(13, Minecraft.getInstance().fontRenderer, x + (width * 0), z, width, heigth);
		this.children.add(schematic_x);
		schematic_y = new GuiTextField(14, Minecraft.getInstance().fontRenderer, x + (width * 1), z, width, heigth);
		this.children.add(schematic_y);
		schematic_z = new GuiTextField(15, Minecraft.getInstance().fontRenderer, x + (width * 2), z, width, heigth);
		this.children.add(schematic_z);
		
		this.xUp = new GuiButton(20, x - 1, z - 9, 35, 8, "^") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_x.getText());
				i++;
				GuiSchematicManager.this.schematic_x.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.xUp);
		this.xDown = new GuiButton(21, x - 1, z + 19, 35, 8, "v") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_x.getText());
				i--;
				GuiSchematicManager.this.schematic_x.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.xDown);
		this.yUp = new GuiButton(22, x + 32, z - 9, 35, 8, "^") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_y.getText());
				i++;
				GuiSchematicManager.this.schematic_y.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.yUp);
		this.yDown = new GuiButton(23, x + 32, z + 19, 35, 8, "v") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_y.getText());
				i--;
				GuiSchematicManager.this.schematic_y.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.yDown);
		this.zUp = new GuiButton(24, x + 32 + 33, z - 9, 35, 8, "^") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_z.getText());
				i++;
				GuiSchematicManager.this.schematic_z.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.zUp);
		this.zDown = new GuiButton(25, x + 32 + 33, z + 19, 35, 8, "v") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_z.getText());
				i--;
				GuiSchematicManager.this.schematic_z.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.zDown);
		
		//Visible Level
		this.levelUp = new GuiButton(26, this.width - 110, 210, 98, 8, "^") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_visible_level.getText());
				i = Math.min(GuiSchematicManager.this.maxLevel, i + 1);
				GuiSchematicManager.this.schematic_visible_level.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.levelUp);
		this.levelDown = new GuiButton(27, this.width - 110, 238, 98, 8, "v") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				int i = Integer.parseInt(GuiSchematicManager.this.schematic_visible_level.getText());
				i = Math.max(1, i - 1);
				GuiSchematicManager.this.schematic_visible_level.setText(i + "");
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.levelDown);
		
		schematic_visible_level = new GuiTextField(15, Minecraft.getInstance().fontRenderer, this.width - 110, 219, 98, heigth);
		this.children.add(schematic_visible_level);
		
		//Rotation and Mirror
		this.mirrorMode = new GuiButton(26, this.width - 110, 60, 100, 20, "") {
			@Override
			public void onClick(double mouseX, double mouseY) {
				
				if (GuiSchematicManager.this.mirror == Mirror.NONE) {
					GuiSchematicManager.this.mirror = Mirror.LEFT_RIGHT;
				} else if (GuiSchematicManager.this.mirror == Mirror.LEFT_RIGHT) {
					GuiSchematicManager.this.mirror = Mirror.FRONT_BACK;
				} else if (GuiSchematicManager.this.mirror == Mirror.FRONT_BACK) {
					GuiSchematicManager.this.mirror = Mirror.NONE;
				}
				
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.mirrorMode);
		this.rotationMode = new GuiButton(27, this.width - 110, 105, 100, 20, "") {
			@Override
			public void onClick(double mouseX, double mouseY) {

				if (GuiSchematicManager.this.rotation == Rotation.NONE) {
					GuiSchematicManager.this.rotation = Rotation.CLOCKWISE_90;
				} else if (GuiSchematicManager.this.rotation == Rotation.CLOCKWISE_90) {
					GuiSchematicManager.this.rotation = Rotation.CLOCKWISE_180;
				} else if (GuiSchematicManager.this.rotation == Rotation.CLOCKWISE_180) {
					GuiSchematicManager.this.rotation = Rotation.COUNTERCLOCKWISE_90;
				} else if (GuiSchematicManager.this.rotation == Rotation.COUNTERCLOCKWISE_90) {
					GuiSchematicManager.this.rotation = Rotation.NONE;
				}
				
				super.onClick(mouseX, mouseY);
			}
		};
		this.addButton(this.rotationMode);
		
		updateGui();
		super.initGui();
		
	}
	
	private String getNameFromRoation(Rotation r) {
		if (r == Rotation.NONE) {
			return "0°";
		} else if (r == Rotation.CLOCKWISE_90) {
			return "90°";
		} else if (r == Rotation.CLOCKWISE_180) {
			return "180°";
		} else if (r == Rotation.COUNTERCLOCKWISE_90) {
			return "270°";
		}
		return "0°";
	}
	
	public String getNameFromMirror(Mirror m) {
		if (m == Mirror.FRONT_BACK) {
			return "Front<>Back";
		} else if (m == Mirror.LEFT_RIGHT) {
			return "Left<>Right";
		} else if (m == Mirror.NONE) {
			return "None";
		}
		return "None";
	}
	
	@Override
	public IGuiEventListener getFocused() {
		if (this.schematic_name.isFocused()) {
			return this.schematic_name;
		} else if (this.schematic_x.isFocused()) {
			return this.schematic_x;
		} else if (this.schematic_y.isFocused()) {
			return this.schematic_y;
		} else if (this.schematic_z.isFocused()) {
			return this.schematic_z;
		} else if (this.schematic_visible_level.isFocused()) {
			return this.schematic_visible_level;
		}
		return null;
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public void initSchematicSelector(int id, int schemetic_selector_width ,int schematic_selector_height, int schematic_selector_x, int schematic_selector_y, int button_distance) {
		
		this.schematic_selector[id] = new GuiButton(id, schematic_selector_x, schematic_selector_y + (schematic_selector_height + button_distance) * (id), schemetic_selector_width, schematic_selector_height, new TextComponentTranslation("gui.select_schematic").getString() + (id + 1)) {
			@Override
			public void onClick(double mouseX, double mouseY) {
				
				GuiSchematicManager.this.selected_schematic = this.id;
				GuiSchematicManager.this.updateGui();
				
				super.onClick(mouseX, mouseY);
			}
		};
		
	}
	
	public void updateGui() {
		
		SchematicStruckture schem = HoloStruckture.schematicStrucktures[this.selected_schematic];
		
		this.schematic_name.setText(schem != null ? schem.getFile().getName() : "");
		this.schematic_visibility = schem != null ? schem.getVisibleMode() : VisibleMode.ALL;
		this.schematic_x.setText("" + (schem != null ? schem.getPosX(): "0"));
		this.schematic_y.setText("" + (schem != null ? schem.getPosY() : "0"));
		this.schematic_z.setText("" + (schem != null ? schem.getPosZ() : "0"));
		this.schematic_visible_level.setText("" + (schem != null ? schem.getVisibleLevel() : "1"));
		this.maxLevel = (schem != null ? schem.getHeight() : 1);
		this.rotation = schem != null ? schem.getRotation() : Rotation.NONE;
		this.mirror = schem != null ? schem.getMirror() : Mirror.NONE;
		this.RBOenabled = schem != null ? schem.isRenderBufferEnabled() : false;
		
	}
	
	@Override
	public void tick() {
		
		String visibleN = this.schematic_visibility == VisibleMode.ALL ? "gui.schematic.visible.all" : this.schematic_visibility == VisibleMode.LEVEL ? "gui.schematic.visible.level" : "gui.schematic.visible.none";
		
		this.visibility.displayString = new TextComponentTranslation(visibleN).getString();
		this.renderMod.displayString = new TextComponentTranslation("gui.rendermode." + HoloStruckture.render_mode.getName()).getString();
		this.mirrorMode.displayString = getNameFromMirror(mirror);
		this.rotationMode.displayString = getNameFromRoation(rotation);
		this.enableRBO.displayString = new TextComponentTranslation("gui.rbo." + (RBOenabled ? "enabled" : "disabled")).getString();
		
		int id = this.selected_schematic;
		
		if (HoloStruckture.schematicStrucktures[id] != null) {
			
			try {
				int x = Integer.parseInt(this.schematic_x.getText().equals("") || this.schematic_x.getText().equals("-") ? "0" : this.schematic_x.getText());
				int y = Integer.parseInt(this.schematic_y.getText().equals("") || this.schematic_y.getText().equals("-") ? "0" : this.schematic_y.getText());
				int z = Integer.parseInt(this.schematic_z.getText().equals("") || this.schematic_z.getText().equals("-") ? "0" : this.schematic_z.getText());
				int vl = Integer.parseInt(this.schematic_visible_level.getText().equals("") || this.schematic_visible_level.getText().equals("-") ? "0" : this.schematic_visible_level.getText());
				SchematicStruckture.updateStruckrure(id, new BlockPos(x, y, z), this.schematic_visibility, mirror, rotation, vl, RBOenabled);
			} catch(Exception e) {
				this.schematic_x.setText("" + HoloStruckture.schematicStrucktures[id].getPosX());
				this.schematic_y.setText("" + HoloStruckture.schematicStrucktures[id].getPosY());
				this.schematic_z.setText("" + HoloStruckture.schematicStrucktures[id].getPosZ());
				this.mirror = Mirror.NONE;
				this.rotation = Rotation.NONE;
			}
		}
		
		HoloStruckture.lastEditedStructureId = this.selected_schematic;
		
	}
	
}
