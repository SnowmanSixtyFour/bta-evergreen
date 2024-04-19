package snowmansixtyfour.evergreen.block;

import java.util.Random;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class AncientSlate extends Block {
	public AncientSlate(String key, int id, Material material) {
		super(key, id, material);
		this.setTicking(true);
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return new ItemStack[]{new ItemStack(Block.slate)};
		}
	}
}
