package net.galaxygameryt.cultivation_mastery.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class YinYang extends Item {
    public YinYang(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        Boolean toggle = false;
        if (!toggle) {
            tooltip.add(Text.translatable("tooltip.cultivation_mastery.yin_yang.tooltip.1"));
        } else if (toggle) {
            tooltip.add(Text.translatable("tooltip.cultivation_mastery.yin_yang.tooltip.2"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
