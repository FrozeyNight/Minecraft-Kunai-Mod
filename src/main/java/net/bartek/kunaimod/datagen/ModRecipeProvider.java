package net.bartek.kunaimod.datagen;

import net.bartek.kunaimod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KUNAI.get())
                .pattern(" N ")
                .pattern(" S ")
                .pattern(" T ")
                .define('S', Items.NETHER_STAR)
                .define('T', Items.STICK)
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);
    }
}
