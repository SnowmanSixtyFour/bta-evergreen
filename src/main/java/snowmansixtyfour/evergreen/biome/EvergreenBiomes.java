package snowmansixtyfour.evergreen.biome;

import snowmansixtyfour.evergreen.EvergreenMod;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class EvergreenBiomes {
	public static final Biome EVERGREEN_EVERFOREST = new BiomeEverforest("evergreen.everforest");

	public static void initializeBiomes() {
		Biomes.register(EvergreenMod.MOD_ID+"evergreen.everforest", EVERGREEN_EVERFOREST);
	}
}
