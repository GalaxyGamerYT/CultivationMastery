package net.galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.state.property.Properties;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.OAK_TRAINING_POST, doorLikeDrops(ModBlocks.OAK_TRAINING_POST));
        addDrop(ModBlocks.SPRUCE_TRAINING_POST, doorLikeDrops(ModBlocks.SPRUCE_TRAINING_POST));
        addDrop(ModBlocks.BIRCH_TRAINING_POST, doorLikeDrops(ModBlocks.BIRCH_TRAINING_POST));
        addDrop(ModBlocks.JUNGLE_TRAINING_POST, doorLikeDrops(ModBlocks.JUNGLE_TRAINING_POST));
        addDrop(ModBlocks.ACACIA_TRAINING_POST, doorLikeDrops(ModBlocks.ACACIA_TRAINING_POST));
        addDrop(ModBlocks.DARK_OAK_TRAINING_POST, doorLikeDrops(ModBlocks.DARK_OAK_TRAINING_POST));
        addDrop(ModBlocks.MANGROVE_TRAINING_POST, doorLikeDrops(ModBlocks.MANGROVE_TRAINING_POST));
        addDrop(ModBlocks.CHERRY_TRAINING_POST, doorLikeDrops(ModBlocks.CHERRY_TRAINING_POST));

        addDrop(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, Items.RAW_COPPER));
        addDrop(ModBlocks.DEEPSLATE_LOW_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_LOW_LEVEL_SPIRIT_STONE_ORE, Items.RAW_COPPER));
        addDrop(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, Items.RAW_GOLD));
        addDrop(ModBlocks.DEEPSLATE_MEDIUM_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_MEDIUM_LEVEL_SPIRIT_STONE_ORE, Items.RAW_GOLD));
        addDrop(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_LEVEL_SPIRIT_STONE_ORE, Items.DIAMOND));
        addDrop(ModBlocks.DEEPSLATE_HIGH_LEVEL_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_HIGH_LEVEL_SPIRIT_STONE_ORE, Items.DIAMOND));
    }

    public LootTable.Builder doorLikeDrops(Block block) {
        return this.dropsWithProperty(block, Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER);
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(
                drop, (LootPoolEntry.Builder)this.applyExplosionDecay(
                        drop, ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
