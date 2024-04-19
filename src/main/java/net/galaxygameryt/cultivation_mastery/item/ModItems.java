package net.galaxygameryt.cultivation_mastery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.galaxygameryt.cultivation_mastery.CultivationMastery;
import net.galaxygameryt.cultivation_mastery.item.custom.EssenceItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item YIN_YANG = registerItem("yin_yang",
            new EssenceItems(new FabricItemSettings(),"yin_yang","6"));
    public static final Item MANDALA = registerItem("mandala",
            new EssenceItems(new FabricItemSettings(),"mandala","2"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CultivationMastery.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CultivationMastery.LOGGER.info("Registering Mod Items for " + CultivationMastery.MOD_ID);
    }

}
