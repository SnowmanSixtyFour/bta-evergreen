package snowmansixtyfour.evergreen.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.sound.BlockSound;
import snowmansixtyfour.evergreen.EvergreenConfig;
import turniplabs.halplibe.helper.BlockBuilder;

import static snowmansixtyfour.evergreen.EvergreenMod.MOD_ID;

public class EvergreenBlocks {

	public static Block dichondra;
	public static Block everdirt;

	private int blockID(String blockName) {
		return EvergreenConfig.cfg.getInt("Block IDs." + blockName);
	}

	private void initializeBlockDetails() {
		ItemToolPickaxe.miningLevels.put(dichondra, 0);
	}

	public void initializeBlocks() {
		BlockBuilder grass = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
			.setHardness(0.6f)
			.setResistance(1.0f)
			.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS, BlockTags.GROWS_SUGAR_CANE, BlockTags.GROWS_TREES, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH);

		BlockBuilder dirt = new BlockBuilder(MOD_ID)
			.setBlockSound(new BlockSound("step.gravel", "step.gravel", 1.0f, 1.0f))
			.setHardness(0.6f)
			.setResistance(1.0f)
			.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_SUGAR_CANE, BlockTags.PASSIVE_MOBS_SPAWN, BlockTags.FIREFLIES_CAN_SPAWN, BlockTags.CAVE_GEN_REPLACES_SURFACE, BlockTags.CAVES_CUT_THROUGH);

		dichondra = grass
			.setSideTextures("dichondra_side.png")
			.setTopTexture("dichondra_top.png")
			.setBottomTexture("everdirt.png")
			.build(new Block("dichondra", blockID("dichondra"), Material.grass));

		everdirt = dirt
			.setTextures("everdirt.png")
			.build(new Block("everdirt", blockID("everdirt"), Material.dirt));

		initializeBlockDetails();
	}

}
