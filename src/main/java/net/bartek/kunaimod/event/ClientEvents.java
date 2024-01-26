package net.bartek.kunaimod.event;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.item.custom.KunaiItem;
import net.bartek.kunaimod.networking.ModMessages;
import net.bartek.kunaimod.networking.packet.KunaiTeleportC2SPacket;
import net.bartek.kunaimod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = KunaiMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBinding.TELEPORTING_KEY.consumeClick()){
                ModMessages.sendToServer(new KunaiTeleportC2SPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = KunaiMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.TELEPORTING_KEY);
        }
    }
}
