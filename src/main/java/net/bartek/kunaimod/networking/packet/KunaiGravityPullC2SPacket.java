package net.bartek.kunaimod.networking.packet;

import net.bartek.kunaimod.item.custom.KunaiItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class KunaiGravityPullC2SPacket {
    public KunaiGravityPullC2SPacket(){

    }

    public KunaiGravityPullC2SPacket(FriendlyByteBuf buf){

    }

    public void toBytes(FriendlyByteBuf buf){

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->{
            // HERE WE ARE ON THE SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = context.getSender().serverLevel();

            KunaiItem.gravityPullToKunai(player, level);
        });

        return true;
    }
}
