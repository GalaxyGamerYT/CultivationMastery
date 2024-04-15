package net.galaxygameryt.cultivation_mastery.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.galaxygameryt.cultivation_mastery.CultivationMastery;
import net.galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CULTIVATION_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CultivationMastery.MOD_ID, "cultivation"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cultivation"))
                    .icon(() -> new ItemStack(ModItems.YIN_YANG)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TRAINER);
                    }).build());

    public static void regiserItemGroups() {
        CultivationMastery.LOGGER.info("Registering Item Groups for "+CultivationMastery.MOD_ID);
    }

}
