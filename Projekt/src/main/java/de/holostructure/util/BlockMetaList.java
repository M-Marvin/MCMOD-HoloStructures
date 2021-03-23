package de.holostructure.util;

import java.util.HashMap;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.state.properties.SlabType;

public class BlockMetaList {

	protected HashMap<Integer, HashMap<Integer, BlockState>> blockMetaList;
	private HashMap<Integer, BlockState> tempMetaList;
	
	public BlockMetaList() {
		
		this.blockMetaList = new HashMap<Integer,HashMap<Integer, BlockState>>();
		this.tempMetaList = new HashMap<Integer, BlockState>();
		
		this.init();
		
	}
	
	protected void init() {
		addBlockMetaEntry(0, Blocks.STONE.getDefaultState());
		addBlockMetaEntry(1, Blocks.GRANITE.getDefaultState());
		addBlockMetaEntry(2, Blocks.POLISHED_GRANITE.getDefaultState());
		addBlockMetaEntry(3, Blocks.DIORITE.getDefaultState());
		addBlockMetaEntry(4, Blocks.POLISHED_DIORITE.getDefaultState());
		addBlockMetaEntry(5, Blocks.ANDESITE.getDefaultState());
		addBlockMetaEntry(6, Blocks.POLISHED_ANDESITE.getDefaultState());
		addBlockMetaList(1);
		
		addBlockMetaEntry(0, Blocks.GRASS_BLOCK.getDefaultState());
		addBlockMetaList(2);
		
		addBlockMetaEntry(0, Blocks.DIRT.getDefaultState());
		addBlockMetaEntry(1, Blocks.COARSE_DIRT.getDefaultState());
		addBlockMetaEntry(2, Blocks.PODZOL.getDefaultState());
		addBlockMetaList(3);
		
		addBlockMetaEntry(0, Blocks.COBBLESTONE.getDefaultState());
		addBlockMetaList(4);
		
		addBlockMetaEntry(0, Blocks.OAK_PLANKS.getDefaultState());
		addBlockMetaEntry(1, Blocks.SPRUCE_PLANKS.getDefaultState());
		addBlockMetaEntry(2, Blocks.BIRCH_PLANKS.getDefaultState());
		addBlockMetaEntry(3, Blocks.JUNGLE_PLANKS.getDefaultState());
		addBlockMetaEntry(4, Blocks.ACACIA_PLANKS.getDefaultState());
		addBlockMetaEntry(5, Blocks.DARK_OAK_PLANKS.getDefaultState());
		addBlockMetaList(5);                     
		
		addBlockMetaEntry(0, Blocks.OAK_SAPLING.getDefaultState());
		addBlockMetaEntry(1, Blocks.SPRUCE_SAPLING.getDefaultState());
		addBlockMetaEntry(2, Blocks.BIRCH_SAPLING.getDefaultState());
		addBlockMetaEntry(3, Blocks.JUNGLE_SAPLING.getDefaultState());
		addBlockMetaEntry(4, Blocks.ACACIA_SAPLING.getDefaultState());
		addBlockMetaEntry(5, Blocks.DARK_OAK_SAPLING.getDefaultState());
		addBlockMetaList(6);
		
		addBlockMetaEntry(0, Blocks.BEDROCK.getDefaultState());
		addBlockMetaList(7);
		
		addBlockMetaEntry(0, Blocks.SAND.getDefaultState());
		addBlockMetaEntry(1, Blocks.RED_SAND.getDefaultState());
		addBlockMetaList(12);
		
		addBlockMetaEntry(0, Blocks.GRAVEL.getDefaultState());
		addBlockMetaList(13);
		
		addBlockMetaEntry(0, Blocks.GOLD_ORE.getDefaultState());
		addBlockMetaList(14);
		
		addBlockMetaEntry(0, Blocks.IRON_ORE.getDefaultState());
		addBlockMetaList(15);
		
		addBlockMetaEntry(0, Blocks.COAL_ORE.getDefaultState());
		addBlockMetaList(16);
		
		addBlockMetaEntry(0, Blocks.OAK_LOG.getDefaultState());
		addBlockMetaEntry(1, Blocks.SPRUCE_LOG.getDefaultState());
		addBlockMetaEntry(2, Blocks.BIRCH_LOG.getDefaultState());
		addBlockMetaEntry(3, Blocks.JUNGLE_LOG.getDefaultState());
		addBlockMetaList(17);
		
		addBlockMetaEntry(0, Blocks.ACACIA_LOG.getDefaultState());
		addBlockMetaEntry(1, Blocks.DARK_OAK_LOG.getDefaultState());
		addBlockMetaList(162);
		
		addBlockMetaEntry(0, Blocks.OAK_LEAVES.getDefaultState());
		addBlockMetaEntry(1, Blocks.SPRUCE_LEAVES.getDefaultState());
		addBlockMetaEntry(2, Blocks.BIRCH_LEAVES.getDefaultState());
		addBlockMetaEntry(3, Blocks.JUNGLE_LEAVES.getDefaultState());
		addBlockMetaList(18);
		
		addBlockMetaEntry(0, Blocks.ACACIA_LEAVES.getDefaultState());
		addBlockMetaEntry(1, Blocks.DARK_OAK_LEAVES.getDefaultState());
		addBlockMetaList(161);
		
		addBlockMetaEntry(0, Blocks.SPONGE.getDefaultState());
		addBlockMetaEntry(1, Blocks.WET_SPONGE.getDefaultState());
		addBlockMetaList(19);
		
		addBlockMetaEntry(0, Blocks.GLASS.getDefaultState());
		addBlockMetaList(20);
		
		addBlockMetaEntry(0, Blocks.LAPIS_ORE.getDefaultState());
		addBlockMetaList(21);
		
		addBlockMetaEntry(0, Blocks.LAPIS_BLOCK.getDefaultState());
		addBlockMetaList(22);
		
		addBlockMetaEntry(0, Blocks.DISPENSER.getDefaultState());
		addBlockMetaList(23);
		
		addBlockMetaEntry(0, Blocks.SANDSTONE.getDefaultState());
		addBlockMetaEntry(1, Blocks.CHISELED_SANDSTONE.getDefaultState());
		addBlockMetaEntry(2, Blocks.CUT_SANDSTONE.getDefaultState());
		addBlockMetaList(24);
		
		addBlockMetaEntry(0, Blocks.NOTE_BLOCK.getDefaultState());
		addBlockMetaList(25);
		
		addBlockMetaEntry(0, Blocks.POWERED_RAIL.getDefaultState());
		addBlockMetaList(27);
		
		addBlockMetaEntry(0, Blocks.DETECTOR_RAIL.getDefaultState());
		addBlockMetaList(28);
		
		addBlockMetaEntry(0, Blocks.STICKY_PISTON.getDefaultState());
		addBlockMetaList(29);
		
		addBlockMetaEntry(0, Blocks.COBWEB.getDefaultState());
		addBlockMetaList(30);
		
		addBlockMetaEntry(0, Blocks.DEAD_BUSH.getDefaultState());
		addBlockMetaEntry(1, Blocks.GRASS.getDefaultState());
		addBlockMetaEntry(2, Blocks.FERN.getDefaultState());
		addBlockMetaList(31);
		
		addBlockMetaEntry(0, Blocks.DEAD_BUSH.getDefaultState());
		addBlockMetaList(32);
		
		addBlockMetaEntry(0, Blocks.PISTON.getDefaultState());
		addBlockMetaList(33);
		
		addBlockMetaEntry(0, Blocks.WHITE_WOOL.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_WOOL.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_WOOL.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_WOOL.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_WOOL.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_WOOL.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_WOOL.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_WOOL.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_WOOL.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_WOOL.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_WOOL.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_WOOL.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_WOOL.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_WOOL.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_WOOL.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_WOOL.getDefaultState());
		addBlockMetaList(35);
		
		addBlockMetaEntry(0, Blocks.DANDELION.getDefaultState());
		addBlockMetaList(37);
		
		addBlockMetaEntry(0, Blocks.POPPY.getDefaultState());
		addBlockMetaEntry(1, Blocks.BLUE_ORCHID.getDefaultState());
		addBlockMetaEntry(2, Blocks.ALLIUM.getDefaultState());
		addBlockMetaEntry(3, Blocks.AZURE_BLUET.getDefaultState());
		addBlockMetaEntry(4, Blocks.RED_TULIP.getDefaultState());
		addBlockMetaEntry(5, Blocks.ORANGE_TULIP.getDefaultState());
		addBlockMetaEntry(6, Blocks.WHITE_TULIP.getDefaultState());
		addBlockMetaEntry(7, Blocks.PINK_TULIP.getDefaultState());
		addBlockMetaEntry(8, Blocks.OXEYE_DAISY.getDefaultState());
		addBlockMetaList(38);
		
		addBlockMetaEntry(0, Blocks.BROWN_MUSHROOM.getDefaultState());
		addBlockMetaList(39);
		
		addBlockMetaEntry(0, Blocks.RED_MUSHROOM.getDefaultState());
		addBlockMetaList(40);
		
		addBlockMetaEntry(0, Blocks.GOLD_BLOCK.getDefaultState());
		addBlockMetaList(41);
		
		addBlockMetaEntry(0, Blocks.IRON_BLOCK.getDefaultState());
		addBlockMetaList(42);
		
		addBlockMetaEntry(0, Blocks.OAK_SLAB.getDefaultState());
		addBlockMetaEntry(1, Blocks.SPRUCE_SLAB.getDefaultState());
		addBlockMetaEntry(2, Blocks.BIRCH_SLAB.getDefaultState());
		addBlockMetaEntry(3, Blocks.JUNGLE_SLAB.getDefaultState());
		addBlockMetaEntry(4, Blocks.ACACIA_SLAB.getDefaultState());
		addBlockMetaEntry(5, Blocks.DARK_OAK_SLAB.getDefaultState());
		addBlockMetaList(126);
		
		addBlockMetaEntry(0, Blocks.STONE_SLAB.getDefaultState());
		addBlockMetaEntry(1, Blocks.SANDSTONE_SLAB.getDefaultState());
		addBlockMetaEntry(3, Blocks.COBBLESTONE_SLAB.getDefaultState());
		addBlockMetaEntry(4, Blocks.BRICK_SLAB.getDefaultState());
		addBlockMetaEntry(5, Blocks.STONE_BRICK_SLAB.getDefaultState());
		addBlockMetaEntry(6, Blocks.NETHER_BRICK_SLAB.getDefaultState());
		addBlockMetaEntry(7, Blocks.QUARTZ_SLAB.getDefaultState());
		addBlockMetaList(44);
		
		addBlockMetaEntry(0, Blocks.RED_SANDSTONE_SLAB.getDefaultState());
		addBlockMetaList(182);
		
		addBlockMetaEntry(0, Blocks.PURPUR_SLAB.getDefaultState());
		addBlockMetaList(205);
		
		addBlockMetaEntry(0, Blocks.STONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(1, Blocks.SANDSTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(3, Blocks.COBBLESTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(4, Blocks.BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(5, Blocks.STONE_BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(6, Blocks.NETHER_BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaEntry(7, Blocks.QUARTZ_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE));
		addBlockMetaList(43);
		
		addBlockMetaEntry(0, Blocks.BRICKS.getDefaultState());
		addBlockMetaList(45);
		
		addBlockMetaEntry(0, Blocks.TNT.getDefaultState());
		addBlockMetaList(46);
		
		addBlockMetaEntry(0, Blocks.BOOKSHELF.getDefaultState());
		addBlockMetaList(47);
		
		addBlockMetaEntry(0, Blocks.MOSSY_COBBLESTONE.getDefaultState());
		addBlockMetaList(48);
		
		addBlockMetaEntry(0, Blocks.OBSIDIAN.getDefaultState());
		addBlockMetaList(49);
		
		addBlockMetaEntry(0, Blocks.TORCH.getDefaultState());
		addBlockMetaList(50);
		
		addBlockMetaEntry(0, Blocks.END_ROD.getDefaultState());
		addBlockMetaList(198);
		
		addBlockMetaEntry(0, Blocks.CHORUS_PLANT.getDefaultState());
		addBlockMetaList(199);
		
		addBlockMetaEntry(0, Blocks.CHORUS_FLOWER.getDefaultState());
		addBlockMetaList(200);
		
		addBlockMetaEntry(0, Blocks.PURPUR_BLOCK.getDefaultState());
		addBlockMetaList(201);
		
		addBlockMetaEntry(0, Blocks.PURPUR_PILLAR.getDefaultState());
		addBlockMetaList(202);
		
		addBlockMetaEntry(0, Blocks.PURPUR_STAIRS.getDefaultState());
		addBlockMetaList(203);
		
		addBlockMetaEntry(0, Blocks.SPAWNER.getDefaultState());
		addBlockMetaList(52);
		
		addBlockMetaEntry(0, Blocks.OAK_STAIRS.getDefaultState());
		addBlockMetaList(53);
		
		addBlockMetaEntry(0, Blocks.CHEST.getDefaultState());
		addBlockMetaList(54);
		
		addBlockMetaEntry(0, Blocks.DIAMOND_ORE.getDefaultState());
		addBlockMetaList(56);
		
		addBlockMetaEntry(0, Blocks.DIAMOND_BLOCK.getDefaultState());
		addBlockMetaList(57);
		
		addBlockMetaEntry(0, Blocks.CRAFTING_TABLE.getDefaultState());
		addBlockMetaList(58);
		
		addBlockMetaEntry(0, Blocks.FARMLAND.getDefaultState());
		addBlockMetaList(60);
		
		addBlockMetaEntry(0, Blocks.FURNACE.getDefaultState());
		addBlockMetaList(61);
		
		addBlockMetaEntry(0, Blocks.LADDER.getDefaultState());
		addBlockMetaList(65);
		
		addBlockMetaEntry(0, Blocks.RAIL.getDefaultState());
		addBlockMetaList(66);
		
		addBlockMetaEntry(0, Blocks.COBBLESTONE_STAIRS.getDefaultState());
		addBlockMetaList(67);
		
		addBlockMetaEntry(0, Blocks.LEVER.getDefaultState());
		addBlockMetaList(69);
		
		addBlockMetaEntry(0, Blocks.STONE_PRESSURE_PLATE.getDefaultState());
		addBlockMetaList(70);
		
		addBlockMetaEntry(0, Blocks.OAK_PRESSURE_PLATE.getDefaultState());
		addBlockMetaList(72);
		
		addBlockMetaEntry(0, Blocks.REDSTONE_ORE.getDefaultState());
		addBlockMetaList(73);
		
		addBlockMetaEntry(0, Blocks.REDSTONE_TORCH.getDefaultState());
		addBlockMetaList(76);
		
		addBlockMetaEntry(0, Blocks.STONE_BUTTON.getDefaultState());
		addBlockMetaList(77);
		
		addBlockMetaEntry(0, Blocks.SNOW.getDefaultState());
		addBlockMetaList(78);
		
		addBlockMetaEntry(0, Blocks.ICE.getDefaultState());
		addBlockMetaList(79);
		
		addBlockMetaEntry(0, Blocks.SNOW_BLOCK.getDefaultState());
		addBlockMetaList(80);
		
		addBlockMetaEntry(0, Blocks.CACTUS.getDefaultState());
		addBlockMetaList(81);
		
		addBlockMetaEntry(0, Blocks.CLAY.getDefaultState());
		addBlockMetaList(337);
		
		addBlockMetaEntry(0, Blocks.JUKEBOX.getDefaultState());
		addBlockMetaList(84);
		
		addBlockMetaEntry(0, Blocks.OAK_FENCE.getDefaultState());
		addBlockMetaList(85);
		
		addBlockMetaEntry(0, Blocks.SPRUCE_FENCE.getDefaultState());
		addBlockMetaList(188);
		
		addBlockMetaEntry(0, Blocks.BIRCH_FENCE.getDefaultState());
		addBlockMetaList(189);
		
		addBlockMetaEntry(0, Blocks.JUNGLE_FENCE.getDefaultState());
		addBlockMetaList(190);
		
		addBlockMetaEntry(0, Blocks.DARK_OAK_FENCE.getDefaultState());
		addBlockMetaList(191);
		
		addBlockMetaEntry(0, Blocks.ACACIA_FENCE.getDefaultState());
		addBlockMetaList(192);
		
		addBlockMetaEntry(0, Blocks.PUMPKIN.getDefaultState());
		addBlockMetaList(86);
		
		addBlockMetaEntry(0, Blocks.NETHERRACK.getDefaultState());
		addBlockMetaList(87);
		
		addBlockMetaEntry(0, Blocks.SOUL_SAND.getDefaultState());
		addBlockMetaList(88);
		
		addBlockMetaEntry(0, Blocks.GLOWSTONE.getDefaultState());
		addBlockMetaList(89);
		
		addBlockMetaEntry(0, Blocks.JACK_O_LANTERN.getDefaultState());
		addBlockMetaList(91);
		
		addBlockMetaEntry(0, Blocks.OAK_TRAPDOOR.getDefaultState());
		addBlockMetaList(96);
		
		addBlockMetaEntry(0, Blocks.COMPARATOR.getDefaultState());
		addBlockMetaList(149);
		
		addBlockMetaEntry(0, Blocks.COMPARATOR.getDefaultState());
		addBlockMetaList(150);
		
		addBlockMetaEntry(0, Blocks.INFESTED_STONE.getDefaultState());
		addBlockMetaEntry(1, Blocks.INFESTED_COBBLESTONE.getDefaultState());
		addBlockMetaEntry(2, Blocks.INFESTED_STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(3, Blocks.INFESTED_MOSSY_STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(4, Blocks.INFESTED_CRACKED_STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(5, Blocks.INFESTED_CHISELED_STONE_BRICKS.getDefaultState());
		addBlockMetaList(97);
		
		addBlockMetaEntry(0, Blocks.STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(1, Blocks.MOSSY_STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(2, Blocks.CRACKED_STONE_BRICKS.getDefaultState());
		addBlockMetaEntry(3, Blocks.CHISELED_STONE_BRICKS.getDefaultState());
		addBlockMetaList(98);
		
		addBlockMetaEntry(0, Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState());
		addBlockMetaList(99);
		
		addBlockMetaEntry(0, Blocks.RED_MUSHROOM_BLOCK.getDefaultState());
		addBlockMetaList(100);
		
		addBlockMetaEntry(0, Blocks.IRON_BARS.getDefaultState());
		addBlockMetaList(101);
		
		addBlockMetaEntry(0, Blocks.GLASS_PANE.getDefaultState());
		addBlockMetaList(102);
		
		addBlockMetaEntry(0, Blocks.MELON.getDefaultState());
		addBlockMetaList(103);
		
		addBlockMetaEntry(0, Blocks.VINE.getDefaultState());
		addBlockMetaList(106);
		
		addBlockMetaEntry(0, Blocks.OAK_FENCE_GATE.getDefaultState());
		addBlockMetaList(107);
		
		addBlockMetaEntry(0, Blocks.SPRUCE_FENCE_GATE.getDefaultState());
		addBlockMetaList(183);
		
		addBlockMetaEntry(0, Blocks.BIRCH_FENCE_GATE.getDefaultState());
		addBlockMetaList(184);
		
		addBlockMetaEntry(0, Blocks.JUNGLE_FENCE_GATE.getDefaultState());
		addBlockMetaList(185);
		
		addBlockMetaEntry(0, Blocks.ACACIA_FENCE_GATE.getDefaultState());
		addBlockMetaList(187);
		
		addBlockMetaEntry(0, Blocks.DARK_OAK_FENCE_GATE.getDefaultState());
		addBlockMetaList(186);
		
		addBlockMetaEntry(0, Blocks.BRICK_STAIRS.getDefaultState());
		addBlockMetaList(108);
		
		addBlockMetaEntry(0, Blocks.STONE_BRICK_STAIRS.getDefaultState());
		addBlockMetaList(109);
		
		addBlockMetaEntry(0, Blocks.MYCELIUM.getDefaultState());
		addBlockMetaList(110);
		
		addBlockMetaEntry(0, Blocks.LILY_PAD.getDefaultState());
		addBlockMetaList(111);
		
		addBlockMetaEntry(0, Blocks.NETHER_BRICKS.getDefaultState());
		addBlockMetaList(112);
		
		addBlockMetaEntry(0, Blocks.NETHER_BRICK_FENCE.getDefaultState());
		addBlockMetaList(113);
		
		addBlockMetaEntry(0, Blocks.NETHER_BRICK_STAIRS.getDefaultState());
		addBlockMetaList(114);
		
		addBlockMetaEntry(0, Blocks.ENCHANTING_TABLE.getDefaultState());
		addBlockMetaList(116);
		
		addBlockMetaEntry(0, Blocks.END_PORTAL_FRAME.getDefaultState());
		addBlockMetaList(120);
		
		addBlockMetaEntry(0, Blocks.END_STONE.getDefaultState());
		addBlockMetaList(121);
		
		addBlockMetaEntry(0, Blocks.END_STONE_BRICKS.getDefaultState());
		addBlockMetaList(206);
		
		addBlockMetaEntry(0, Blocks.DRAGON_EGG.getDefaultState());
		addBlockMetaList(122);
		
		addBlockMetaEntry(0, Blocks.REDSTONE_LAMP.getDefaultState());
		addBlockMetaList(123);
		
		addBlockMetaEntry(0, Blocks.SANDSTONE_STAIRS.getDefaultState());
		addBlockMetaList(128);
		
		addBlockMetaEntry(0, Blocks.EMERALD_ORE.getDefaultState());
		addBlockMetaList(129);
		
		addBlockMetaEntry(0, Blocks.ENDER_CHEST.getDefaultState());
		addBlockMetaList(130);
		
		addBlockMetaEntry(0, Blocks.TRIPWIRE_HOOK.getDefaultState());
		addBlockMetaList(131);
		
		addBlockMetaEntry(0, Blocks.EMERALD_BLOCK.getDefaultState());
		addBlockMetaList(133);
		
		addBlockMetaEntry(0, Blocks.SPRUCE_STAIRS.getDefaultState());
		addBlockMetaList(134);
		
		addBlockMetaEntry(0, Blocks.BIRCH_STAIRS.getDefaultState());
		addBlockMetaList(135);
		
		addBlockMetaEntry(0, Blocks.JUNGLE_STAIRS.getDefaultState());
		addBlockMetaList(136);
		
		addBlockMetaEntry(0, Blocks.COMMAND_BLOCK.getDefaultState());
		addBlockMetaList(137);
		
		addBlockMetaEntry(0, Blocks.BEACON.getDefaultState());
		addBlockMetaList(138);
		
		addBlockMetaEntry(0, Blocks.COBBLESTONE_WALL.getDefaultState());
		addBlockMetaEntry(1, Blocks.MOSSY_COBBLESTONE_WALL.getDefaultState());
		addBlockMetaList(139);
		
		addBlockMetaEntry(0, Blocks.OAK_BUTTON.getDefaultState());
		addBlockMetaList(143);
		
		addBlockMetaEntry(0, Blocks.ANVIL.getDefaultState());
		addBlockMetaEntry(1, Blocks.CHIPPED_ANVIL.getDefaultState());
		addBlockMetaEntry(2, Blocks.DAMAGED_ANVIL.getDefaultState());
		addBlockMetaList(145);
		
		addBlockMetaEntry(0, Blocks.TRAPPED_CHEST.getDefaultState());
		addBlockMetaList(146);
		
		addBlockMetaEntry(0, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE.getDefaultState());
		addBlockMetaList(147);
		
		addBlockMetaEntry(0, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultState());
		addBlockMetaList(148);
		
		addBlockMetaEntry(0, Blocks.DAYLIGHT_DETECTOR.getDefaultState());
		addBlockMetaList(151);
		
		addBlockMetaEntry(0, Blocks.REDSTONE_BLOCK.getDefaultState());
		addBlockMetaList(152);
		
		addBlockMetaEntry(0, Blocks.NETHER_QUARTZ_ORE.getDefaultState());
		addBlockMetaList(153);
		
		addBlockMetaEntry(0, Blocks.HOPPER.getDefaultState());
		addBlockMetaList(154);
		
		addBlockMetaEntry(0, Blocks.QUARTZ_BLOCK.getDefaultState());
		addBlockMetaEntry(1, Blocks.CHISELED_QUARTZ_BLOCK.getDefaultState());
		addBlockMetaEntry(2, Blocks.QUARTZ_PILLAR.getDefaultState());
		addBlockMetaList(155);
		
		addBlockMetaEntry(0, Blocks.QUARTZ_STAIRS.getDefaultState());
		addBlockMetaList(156);
		
		addBlockMetaEntry(0, Blocks.ACTIVATOR_RAIL.getDefaultState());
		addBlockMetaList(157);
		
		addBlockMetaEntry(0, Blocks.DROPPER.getDefaultState());
		addBlockMetaList(158);
		
		addBlockMetaEntry(0, Blocks.WHITE_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_TERRACOTTA.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_TERRACOTTA.getDefaultState());
		addBlockMetaList(159);
		
		addBlockMetaEntry(0, Blocks.BARRIER.getDefaultState());
		addBlockMetaList(166);
		
		addBlockMetaEntry(0, Blocks.IRON_TRAPDOOR.getDefaultState());
		addBlockMetaList(167);
		
		addBlockMetaEntry(0, Blocks.HAY_BLOCK.getDefaultState());
		addBlockMetaList(170);
		
		addBlockMetaEntry(0, Blocks.WHITE_CARPET.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_CARPET.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_CARPET.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_CARPET.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_CARPET.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_CARPET.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_CARPET.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_CARPET.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_CARPET.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_CARPET.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_CARPET.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_CARPET.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_CARPET.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_CARPET.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_CARPET.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_CARPET.getDefaultState());
		addBlockMetaList(171);
		
		addBlockMetaEntry(0, Blocks.TERRACOTTA.getDefaultState());
		addBlockMetaList(172);
		
		addBlockMetaEntry(0, Blocks.COAL_BLOCK.getDefaultState());
		addBlockMetaList(173);
		
		addBlockMetaEntry(0, Blocks.PACKED_ICE.getDefaultState());
		addBlockMetaList(174);
		
		addBlockMetaEntry(0, Blocks.ACACIA_STAIRS.getDefaultState());
		addBlockMetaList(163);
		
		addBlockMetaEntry(0, Blocks.DARK_OAK_STAIRS.getDefaultState());
		addBlockMetaList(164);
		
		addBlockMetaEntry(0, Blocks.SLIME_BLOCK.getDefaultState());
		addBlockMetaList(165);
		
		addBlockMetaEntry(0, Blocks.GRASS_PATH.getDefaultState());
		addBlockMetaList(208);
		
		addBlockMetaEntry(0, Blocks.SUNFLOWER.getDefaultState());
		addBlockMetaEntry(1, Blocks.LILAC.getDefaultState());
		addBlockMetaEntry(2, Blocks.TALL_GRASS.getDefaultState());
		addBlockMetaEntry(3, Blocks.LARGE_FERN.getDefaultState());
		addBlockMetaEntry(4, Blocks.ROSE_BUSH.getDefaultState());
		addBlockMetaEntry(5, Blocks.PEONY.getDefaultState());
		addBlockMetaList(175);
		
		addBlockMetaEntry(0, Blocks.WHITE_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_STAINED_GLASS.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_STAINED_GLASS.getDefaultState());
		addBlockMetaList(95);
		
		addBlockMetaEntry(0, Blocks.WHITE_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_STAINED_GLASS_PANE.getDefaultState());
		addBlockMetaList(160);
		
		addBlockMetaEntry(0, Blocks.PRISMARINE.getDefaultState());
		addBlockMetaEntry(1, Blocks.PRISMARINE_BRICKS.getDefaultState());
		addBlockMetaEntry(2, Blocks.DARK_PRISMARINE.getDefaultState());
		addBlockMetaList(168);
		
		addBlockMetaEntry(0, Blocks.SEA_LANTERN.getDefaultState());
		addBlockMetaList(169);
		
		addBlockMetaEntry(0, Blocks.RED_SANDSTONE.getDefaultState());
		addBlockMetaEntry(1, Blocks.CHISELED_RED_SANDSTONE.getDefaultState());
		addBlockMetaEntry(2, Blocks.CUT_RED_SANDSTONE.getDefaultState());
		addBlockMetaList(179);
		
		addBlockMetaEntry(0, Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
		addBlockMetaList(180);
		
		addBlockMetaEntry(0, Blocks.REPEATING_COMMAND_BLOCK.getDefaultState());
		addBlockMetaList(210);
		
		addBlockMetaEntry(0, Blocks.CHAIN_COMMAND_BLOCK.getDefaultState());
		addBlockMetaList(211);
		
		addBlockMetaEntry(0, Blocks.MAGMA_BLOCK.getDefaultState());
		addBlockMetaList(213);
		
		addBlockMetaEntry(0, Blocks.NETHER_WART_BLOCK.getDefaultState());
		addBlockMetaList(214);
		
		addBlockMetaEntry(0, Blocks.RED_NETHER_BRICKS.getDefaultState());
		addBlockMetaList(215);
		
		addBlockMetaEntry(0, Blocks.BONE_BLOCK.getDefaultState());
		addBlockMetaList(216);
		
		addBlockMetaEntry(0, Blocks.STRUCTURE_VOID.getDefaultState());
		addBlockMetaList(217);
		
		addBlockMetaEntry(0, Blocks.OBSERVER.getDefaultState());
		addBlockMetaList(218);
		
		addBlockMetaEntry(0, Blocks.WHITE_SHULKER_BOX.getDefaultState());
		addBlockMetaList(219);
		
		addBlockMetaEntry(0, Blocks.ORANGE_SHULKER_BOX.getDefaultState());
		addBlockMetaList(220);
		
		addBlockMetaEntry(0, Blocks.MAGENTA_SHULKER_BOX.getDefaultState());
		addBlockMetaList(221);
		
		addBlockMetaEntry(0, Blocks.LIGHT_BLUE_SHULKER_BOX.getDefaultState());
		addBlockMetaList(222);
		
		addBlockMetaEntry(0, Blocks.YELLOW_SHULKER_BOX.getDefaultState());
		addBlockMetaList(223);
		
		addBlockMetaEntry(0, Blocks.LIME_SHULKER_BOX.getDefaultState());
		addBlockMetaList(224);
		
		addBlockMetaEntry(0, Blocks.PINK_SHULKER_BOX.getDefaultState());
		addBlockMetaList(225);
		
		addBlockMetaEntry(0, Blocks.GRAY_SHULKER_BOX.getDefaultState());
		addBlockMetaList(226);
		
		addBlockMetaEntry(0, Blocks.LIGHT_GRAY_SHULKER_BOX.getDefaultState());
		addBlockMetaList(227);
		
		addBlockMetaEntry(0, Blocks.CYAN_SHULKER_BOX.getDefaultState());
		addBlockMetaList(228);
		
		addBlockMetaEntry(0, Blocks.PURPLE_SHULKER_BOX.getDefaultState());
		addBlockMetaList(229);
		
		addBlockMetaEntry(0, Blocks.BLUE_SHULKER_BOX.getDefaultState());
		addBlockMetaList(230);
		
		addBlockMetaEntry(0, Blocks.BROWN_SHULKER_BOX.getDefaultState());
		addBlockMetaList(231);
		
		addBlockMetaEntry(0, Blocks.GREEN_SHULKER_BOX.getDefaultState());
		addBlockMetaList(232);
		
		addBlockMetaEntry(0, Blocks.RED_SHULKER_BOX.getDefaultState());
		addBlockMetaList(233);
		
		addBlockMetaEntry(0, Blocks.BLACK_SHULKER_BOX.getDefaultState());
		addBlockMetaList(234);
		
		addBlockMetaEntry(0, Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(235);
		
		addBlockMetaEntry(0, Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(236);
		
		addBlockMetaEntry(0, Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(237);
		
		addBlockMetaEntry(0, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(238);
		
		addBlockMetaEntry(0, Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(239);
		
		addBlockMetaEntry(0, Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(240);
		
		addBlockMetaEntry(0, Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(241);
		
		addBlockMetaEntry(0, Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(242);
		
		addBlockMetaEntry(0, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(243);
		
		addBlockMetaEntry(0, Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(244);
		
		addBlockMetaEntry(0, Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(245);
		
		addBlockMetaEntry(0, Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(246);
		
		addBlockMetaEntry(0, Blocks.BROWN_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(247);
		
		addBlockMetaEntry(0, Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(248);
		
		addBlockMetaEntry(0, Blocks.RED_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(249);
		
		addBlockMetaEntry(0, Blocks.BLACK_GLAZED_TERRACOTTA.getDefaultState());
		addBlockMetaList(250);
		
		addBlockMetaEntry(0, Blocks.WHITE_CONCRETE.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_CONCRETE.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_CONCRETE.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_CONCRETE.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_CONCRETE.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_CONCRETE.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_CONCRETE.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_CONCRETE.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_CONCRETE.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_CONCRETE.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_CONCRETE.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_CONCRETE.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_CONCRETE.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_CONCRETE.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_CONCRETE.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_CONCRETE.getDefaultState());
		addBlockMetaList(251);
		
		addBlockMetaEntry(0, Blocks.WHITE_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(1, Blocks.ORANGE_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(2, Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(3, Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(4, Blocks.YELLOW_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(5, Blocks.LIME_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(6, Blocks.PINK_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(7, Blocks.GRAY_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(8, Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(9, Blocks.CYAN_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(10, Blocks.PURPLE_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(11, Blocks.BLUE_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(12, Blocks.BROWN_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(13, Blocks.GREEN_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(14, Blocks.RED_CONCRETE_POWDER.getDefaultState());
		addBlockMetaEntry(15, Blocks.BLACK_CONCRETE_POWDER.getDefaultState());
		addBlockMetaList(252);
		
//		addBlockMetaEntry(0, Blocks.IRON_DOOR.getDefaultState());
//		addBlockMetaList(330);
//		
//		addBlockMetaEntry(0, Blocks.OAK_DOOR.getDefaultState());
//		addBlockMetaList(324);
//		
//		addBlockMetaEntry(0, Blocks.SPRUCE_DOOR.getDefaultState());
//		addBlockMetaList(427);
//		
//		addBlockMetaEntry(0, Blocks.BIRCH_DOOR.getDefaultState());
//		addBlockMetaList(428);
//		
//		addBlockMetaEntry(0, Blocks.JUNGLE_DOOR.getDefaultState());
//		addBlockMetaList(429);
//		
//		addBlockMetaEntry(0, Blocks.ACACIA_DOOR.getDefaultState());
//		addBlockMetaList(430);
//		
//		addBlockMetaEntry(0, Blocks.DARK_OAK_DOOR.getDefaultState());
//		addBlockMetaList(431);
//		
//		addBlockMetaEntry(0, Blocks.REPEATER.getDefaultState());
//		addBlockMetaList(356);
//		
//		addBlockMetaEntry(0, Blocks.COMPARATOR.getDefaultState());
//		addBlockMetaList(404);
		
		addBlockMetaEntry(0, Blocks.STRUCTURE_BLOCK.getDefaultState());
		addBlockMetaList(255);
		
	}
	
	public void addBlockMetaEntry(int metaID, BlockState state) {
		this.tempMetaList.put(metaID, state);
	}
	
	public void addBlockMetaList(int blockID) {
		this.blockMetaList.put(blockID, this.tempMetaList);
		this.tempMetaList.clear();
	}

}
