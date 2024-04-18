package net.galaxygameryt.cultivation_mastery.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class TrainingPostBlock extends TallPlantBlock {
    public static final MapCodec<TallFlowerBlock> CODEC = TallFlowerBlock.createCodec(TallFlowerBlock::new);

    public MapCodec<TallFlowerBlock> getCodec() {
        return CODEC;
    }

    public TrainingPostBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        VoxelShape shape = VoxelShapes.empty();
        switch (state.get(Properties.DOUBLE_BLOCK_HALF)) {
            case UPPER -> {
                shape = Stream.of(
                        Block.createCuboidShape(4, 0, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 16, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 0, 4, 12, 0, 12)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
            case LOWER -> {
                shape = Stream.of(
                        Block.createCuboidShape(0, 0, 0, 16, 2, 16),
                        Block.createCuboidShape(2, 2, 2, 14, 4, 14),
                        Block.createCuboidShape(4, 4, 4, 12, 16, 12),
                        Block.createCuboidShape(4, 16, 4, 12, 16, 12)
                ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
            }
        }
        return shape;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.training_post.tooltip.1"));
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.training_post.tooltip.2"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
