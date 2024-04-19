package net.galaxygameryt.cultivation_mastery.item.custom;

import net.galaxygameryt.cultivation_mastery.CultivationMastery;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EssenceItems extends Item {
    private final String COLOURCODE;
    private final String KEY;

    public EssenceItems(Settings settings, String key, String colourCode) {
        super(settings);
        this.KEY = key;
        this.COLOURCODE = colourCode;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        boolean toggle = CultivationMastery.CONFIG.debug.essenceTooltipToggle;
        if (!toggle) {
            if (KEY=="yin_yang") {
                tooltip.add(Text.translatable("tooltip.cultivation_mastery.yin_yang.tooltip.1"));
            } else if (KEY=="mandala") {
                tooltip.add(Text.translatable("tooltip.cultivation_mastery.mandala.tooltip.1"));
            }
        } else if (toggle) {
            if (KEY=="yin_yang") {
                tooltip.add(Text.translatable("tooltip.cultivation_mastery.yin_yang.tooltip.2"));
            } else if (KEY=="mandala") {
                tooltip.add(Text.translatable("tooltip.cultivation_mastery.mandala.tooltip.2"));
            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
