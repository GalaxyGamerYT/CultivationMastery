package net.galaxygameryt.cultivation_mastery.util;

import net.galaxygameryt.cultivation_mastery.CultivationMastery;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WOOD_TRAINING_POST = createTag("wood_training_posts");
        public static final TagKey<Block> LOW_LEVEL_SPIRIT_STONE_ORES = createTag("low_level_spirit_stone_ores");
        public static final TagKey<Block> MEDIUM_LEVEL_SPIRIT_STONE_ORES = createTag("medium_level_spirit_stone_ores");
        public static final TagKey<Block> HIGH_LEVEL_SPIRIT_STONE_ORES = createTag("high_level_spirit_stone_ores");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CultivationMastery.MOD_ID, name));

        }
    }

    public static class Items {

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CultivationMastery.MOD_ID, name));
        }
    }
}
