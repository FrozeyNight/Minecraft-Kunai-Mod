package net.bartek.kunaimod.entities.projectile;

import net.bartek.kunaimod.entities.ModEntities;
import net.bartek.kunaimod.item.ModItems;
import net.bartek.kunaimod.util.KunaiTracking;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.List;


public class IronThrownKunai extends AbstractArrow {
    public ItemStack kunaiItem = new ItemStack(ModItems.IRON_KUNAI.get());
    public IronThrownKunai(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.pickup = Pickup.ALLOWED;
    }

    public IronThrownKunai(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntities.IRON_THROWN_KUNAI.get(), pShooter, pLevel);
        this.kunaiItem = pStack.copy();
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        Entity target = hitResult.getEntity();
        float damage = 7;

        // Deal damage to the entity (if applicable)
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).hurt(target.damageSources().thrown(Minecraft.getInstance().player, target), damage);
            target.playSound(SoundEvents.TRIDENT_HIT, 1f , 1f);
        }

        // You can add more logic here if needed

        // Prevent the kunai from being removed
        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.1D, -0.1D, -0.1D));
        //this.setNoGravity(true);

        // Call the parent method to handle other effects
        super.onHitEntity(hitResult);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        this.playSound(SoundEvents.TRIDENT_HIT, 1f , 1f);
        super.onHitBlock(pResult);
    }

    protected boolean tryPickup(Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.kunaiItem.copy();
    }

}
