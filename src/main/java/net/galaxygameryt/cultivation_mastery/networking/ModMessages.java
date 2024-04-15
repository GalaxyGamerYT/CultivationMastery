package net.galaxygameryt.cultivation_mastery.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.galaxygameryt.cultivation_mastery.CultivationMastery;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier BODY_LEVEL_ID = new Identifier(CultivationMastery.MOD_ID, "body_level");
    public static final Identifier BODY_LEVEL_SYNC_ID = new Identifier(CultivationMastery.MOD_ID, "body_level_sync");
    public static final Identifier CULTIVATION_LEVEL_ID = new Identifier(CultivationMastery.MOD_ID, "cultivation_level");
    public static final Identifier CULTIVATION_LEVEL_SYNC_ID = new Identifier(CultivationMastery.MOD_ID, "cultivation_level_sync");
    public static final Identifier QI_LEVEL_ID = new Identifier(CultivationMastery.MOD_ID, "qi_level");
    public static final Identifier QI_LEVEL_SYNC_ID = new Identifier(CultivationMastery.MOD_ID, "qi_level_sync");
    public static final Identifier CULTIVATING_BOOL_ID = new Identifier(CultivationMastery.MOD_ID, "cultivating_bool");
    public static final Identifier CULTIVATING_BOOL_SYNC_ID = new Identifier(CultivationMastery.MOD_ID, "cultivating_bool_sync");

    public static void registerC2SPackets() {
//        ServerPlayNetworking.registerGlobalReceiver(BODY_LEVEL_ID);
    }

    public static void registerS2CPackets() {
//        ClientPlayNetworking.registerGlobalReceiver()
    }
}
