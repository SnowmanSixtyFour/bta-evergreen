package snowmansixtyfour.evergreen.biome;

import snowmansixtyfour.evergreen.EvergreenMod;
import snowmansixtyfour.evergreen.block.EvergreenBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.BiomeForest;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;

import java.util.Random;

public class BiomeEverforest extends BiomeForest {
	public BiomeEverforest(String key) {
		super(key);
		this.topBlock = (short) EvergreenBlocks.dichondra.id;
		this.fillerBlock = (short)EvergreenBlocks.everdirt.id;
	}
}
