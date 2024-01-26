package net.bartek.kunaimod.networking;

import net.bartek.kunaimod.KunaiMod;
import net.bartek.kunaimod.networking.packet.KunaiTeleportC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int pocketId = 0;
    private static int id(){
        return pocketId++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(KunaiMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(KunaiTeleportC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(KunaiTeleportC2SPacket::new)
                .encoder(KunaiTeleportC2SPacket::toBytes)
                .consumerMainThread(KunaiTeleportC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer serverPlayer){
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), message);
    }
}
