package snowmansixtyfour.evergreen;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import snowmansixtyfour.evergreen.block.EvergreenBlocks;
import snowmansixtyfour.evergreen.biome.EvergreenBiomes;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class EvergreenMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "evergreen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Evergreen initialized.");
	}

	@Override
	public void beforeGameStart() {
		new EvergreenBlocks().initializeBlocks();
		new EvergreenBiomes().initializeBiomes();
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}
