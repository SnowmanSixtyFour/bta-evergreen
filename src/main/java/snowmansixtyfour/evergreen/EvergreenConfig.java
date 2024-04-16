package snowmansixtyfour.evergreen;

import net.minecraft.core.block.Block;
import snowmansixtyfour.evergreen.block.EvergreenBlocks;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvergreenConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	private static final Toml properties = new Toml("Evergreen TOML Config");
	public static TomlConfigHandler cfg;

	private static int blockIDs = 4600;


	static {
		properties.addCategory("Evergreen")
			.addEntry("cfgVersion", 5);

		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", 4600);


		List<Field> blockFields = Arrays.stream(EvergreenBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}

		cfg = new TomlConfigHandler(updater, EvergreenMod.MOD_ID, properties);

	}
}
