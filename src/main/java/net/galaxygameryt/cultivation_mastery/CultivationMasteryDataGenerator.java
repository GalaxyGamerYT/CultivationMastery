package net.galaxygameryt.cultivation_mastery;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.galaxygameryt.cultivation_mastery.datagen.ModBlockTagProvider;
import net.galaxygameryt.cultivation_mastery.datagen.ModLootTableProvider;
import net.galaxygameryt.cultivation_mastery.datagen.ModModelProvider;
import net.galaxygameryt.cultivation_mastery.datagen.ModRecipeProvider;

public class CultivationMasteryDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModLootTableProvider::new);
	}
}
