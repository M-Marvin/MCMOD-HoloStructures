package de.holostructure.schematic;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class BlockObject {

	private BlockPos position;
	private IBlockState state;
	
	public BlockObject(BlockPos position, IBlockState state) {
		this.position = position;
		this.state = state;
	}
	
	public BlockPos getPosition() {
		return position;
	}
	
	public IBlockState getState() {
		return state;
	}
	
	public BlockPos getPositionWithOfsset(int x, int y, int z) {
		return new BlockPos(x + position.getX(), y + position.getY(), z + position.getZ());
	}
}
