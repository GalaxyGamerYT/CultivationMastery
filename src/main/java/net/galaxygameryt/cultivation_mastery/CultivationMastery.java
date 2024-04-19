package net.galaxygameryt.cultivation_mastery;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.ModInitializer;

import net.galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.galaxygameryt.cultivation_mastery.config.ModConfig;
import net.galaxygameryt.cultivation_mastery.item.ModItemGroups;
import net.galaxygameryt.cultivation_mastery.item.ModItems;
import net.galaxygameryt.cultivation_mastery.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CultivationMastery implements ModInitializer {
	public static final String MOD_ID = "cultivation_mastery";
    public static final Logger LOGGER = LoggerFactory.getLogger("cultivation_mastery");
	public static ModConfig CONFIG;

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
		CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		ModItemGroups.regiserItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModMessages.registerC2SPackets();

		LOGGER.info("Cultivation Mastery Loaded!");
	}
}