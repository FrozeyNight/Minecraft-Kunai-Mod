package net.bartek.kunaimod.enchantment;

import net.bartek.kunaimod.item.custom.KunaiItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class KunaiExplosionEnchantment extends Enchantment {
    public KunaiExplosionEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof KunaiItem || super.canEnchant(pStack);
    }


}
