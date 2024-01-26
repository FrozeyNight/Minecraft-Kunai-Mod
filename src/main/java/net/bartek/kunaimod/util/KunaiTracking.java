package net.bartek.kunaimod.util;

import net.bartek.kunaimod.entities.projectile.ThrownKunai;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KunaiTracking {
    public static final Map<Player, List<ThrownKunai>> thrownKunaiMap = new HashMap<>();

    // Called when a player throws a kunai
    public static void addToKunaiList(Player player, ThrownKunai kunai) {
        List<ThrownKunai> playerKunais = thrownKunaiMap.getOrDefault(player, new LinkedList<>());
        playerKunais.add(kunai);
        thrownKunaiMap.put(player, playerKunais);
    }

}
