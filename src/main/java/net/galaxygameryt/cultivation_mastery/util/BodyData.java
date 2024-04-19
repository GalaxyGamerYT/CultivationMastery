package net.galaxygameryt.cultivation_mastery.util;

import net.minecraft.nbt.NbtCompound;

public class BodyData {
    public static float addBody(IEntityDataSaver player, float amount) {
        NbtCompound nbt = player.getPersistentData();
        float body = nbt.getFloat("body");

        if (body + amount >= 10) {

        }

        return body;
    }
}
