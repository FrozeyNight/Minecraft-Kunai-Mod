package net.bartek.kunaimod.item.custom;

import net.bartek.kunaimod.entities.projectile.ThrownKunai;
import net.bartek.kunaimod.util.KunaiTracking;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.LinkedList;
import java.util.List;

public class KunaiItem extends SwordItem {

    public KunaiItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        itemstack.hurtAndBreak(2, pPlayer, p -> p.broadcastBreakEvent(pPlayer.getUsedItemHand()));
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            ThrownKunai thrownKunai = new ThrownKunai(pLevel, pPlayer, itemstack);
            thrownKunai.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(thrownKunai);
            KunaiTracking.addToKunaiList(pPlayer,thrownKunai);
        }


        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }


    // Method to handle teleportation
    public static void teleportToNearestKunai(Player player, Level world) {

            ThrownKunai lastThrownKunai = findLastThrownKunai(player);

            Vec3 daggerPos = lastThrownKunai.position();

            // Teleport the player to the dagger's position
            if (player instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer) player;
                serverPlayer.teleportToWithTicket(daggerPos.x, daggerPos.y, daggerPos.z);

                lastThrownKunai.kunaiItem.hurtAndBreak(16, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));

                // Remove the last thrown kunai from the list
                List<ThrownKunai> playerKunais = KunaiTracking.thrownKunaiMap.get(player);
                playerKunais.remove(playerKunais.size() - 1);

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1f , 1f);
            }

    }

    public static void explodeKunai(Player player, Level world)
    {
        ThrownKunai lastThrownKunai = findLastThrownKunai(player);

        Vec3 daggerPos = lastThrownKunai.position();

        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            world.explode(lastThrownKunai, daggerPos.x, daggerPos.y, daggerPos.z, 5f, Level.ExplosionInteraction.MOB);

            lastThrownKunai.kunaiItem.hurtAndBreak(16, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));

            // Remove the last thrown kunai from the list
            List<ThrownKunai> playerKunais = KunaiTracking.thrownKunaiMap.get(player);
            playerKunais.remove(playerKunais.size() - 1);

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1f , 1f);
        }
    }

    public static void gravityPullToKunai(Player player, Level world){
        ThrownKunai lastThrownKunai = findLastThrownKunai(player);

        Vec3 daggerPos = lastThrownKunai.position();

        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;

            // Check for nearby entities and make them leap into the air
            List<LivingEntity> nearbyEntities = world.getEntitiesOfClass(LivingEntity.class,
                    new AABB(daggerPos.x() - 10.0, daggerPos.y() - 10.0, daggerPos.z() - 10.0,
                            daggerPos.x() + 10.0, daggerPos.y() + 10.0, daggerPos.z() + 10.0));

            for (LivingEntity entity : nearbyEntities) {
                // Calculate direction vector from entity to daggerPos
                Vec3 direction = daggerPos.subtract(entity.position()).normalize();

                // Apply a force towards daggerPos using the direction vector
                double strength = 2;  // Adjust this value to control the strength of the gravity pull
                entity.setDeltaMovement(entity.getDeltaMovement().add(direction.x * strength, direction.y * strength, direction.z * strength));
            }

            lastThrownKunai.kunaiItem.hurtAndBreak(16, player, p -> p.broadcastBreakEvent(player.getUsedItemHand()));

            // Remove the last thrown kunai from the list
            List<ThrownKunai> playerKunais = KunaiTracking.thrownKunaiMap.get(player);
            playerKunais.remove(playerKunais.size() - 1);

            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1f , 1f);
        }
    }

    // Helper method to find the last thrown kunai by the player
    private static ThrownKunai findLastThrownKunai(Player player) {
        List<ThrownKunai> thrownKunais = KunaiTracking.thrownKunaiMap.getOrDefault(player, new LinkedList<>());

        if (!thrownKunais.isEmpty()) {
            // Get the last thrown kunai
            return thrownKunais.get(thrownKunais.size() - 1);
        }

        return null;
    }
}




