package net.galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.galaxygameryt.cultivation_mastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateTrainingPostRecipe(exporter, ModBlocks.OAK_TRAINING_POST, Blocks.OAK_PLANKS, Blocks.OAK_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.SPRUCE_TRAINING_POST, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.BIRCH_TRAINING_POST, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.JUNGLE_TRAINING_POST, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.ACACIA_TRAINING_POST, Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.DARK_OAK_TRAINING_POST, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.MANGROVE_TRAINING_POST, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.CHERRY_TRAINING_POST, Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.YIN_YANG,1)
                .pattern("BBW")
                .pattern("B W")
                .pattern("BWW")
                .input('B', Items.BLACK_CONCRETE)
                .input('W', Items.WHITE_CONCRETE)
                .criterion(hasItem(Items.BLACK_CONCRETE), conditionsFromItem(Items.BLACK_CONCRETE))
                .criterion(hasItem(Items.WHITE_CONCRETE), conditionsFromItem(Items.WHITE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.YIN_YANG)));
    }

    public void generateTrainingPostRecipe(RecipeExporter exporter, Block output, Block base, Block pillar) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1)
                .pattern(" P ")
                .pattern(" P ")
                .pattern("BBB")
                .input('P', pillar)
                .input('B', base)
                .criterion(hasItem(pillar), conditionsFromItem(pillar))
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
}
