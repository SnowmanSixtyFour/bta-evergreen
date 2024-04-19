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

public class Dichondra extends Block {
	public Dichondra(String key, int id, Material material) {
		super(key, id, material);
		this.setTicking(true);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.isSneaking() && entity.yd < 0.0) {
			entity.yd = 0.0;
		}
		else if (entity.yd < 0.0D) {
			entity.yd = -entity.yd;
			entity.fallDistance = 0;
		}
	}

	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			if (world.getBlockLightValue(x, y + 1, z) < 4 && Block.lightBlock[world.getBlockId(x, y + 1, z)] > 2) {
				if (rand.nextInt(4) != 0) {
					return;
				}

				world.setBlockWithNotify(x, y, z, EvergreenBlocks.everdirt.id);
			} else if (world.getBlockLightValue(x, y + 1, z) >= 9) {
				int l = x + rand.nextInt(3) - 1;
				int i1 = y + rand.nextInt(5) - 3;
				int j1 = z + rand.nextInt(3) - 1;
				int k1 = world.getBlockId(l, i1 + 1, j1);
				if (world.getBlockId(l, i1, j1) == EvergreenBlocks.everdirt.id && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightBlock[k1] <= 2) {
					world.setBlockWithNotify(l, i1, j1, this.id);
				}
			}
		}
	}

	public AABB getCollisionBoundingBoxFromPool (World world,int x, int y, int z){
		return AABB.getBoundingBoxFromPool(x, y, z, (x + 1), y+.9f, (z + 1));
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			default:
				return new ItemStack[]{new ItemStack(EvergreenBlocks.everdirt)};
		}
	}
}
