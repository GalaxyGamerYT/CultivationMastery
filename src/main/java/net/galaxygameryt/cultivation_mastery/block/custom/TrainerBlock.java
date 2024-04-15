package net.galaxygameryt.cultivation_mastery.block.custom;

import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class TrainerBlock extends Block {
    // maxX - 14px, maxY - 32px, maxZ - 16px
//    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0f,0f,0f,0.875f,2f,1f);
    private static final VoxelShape SHAPE = Stream.of(
            Stream.of(
                    Block.createCuboidShape(5, 16, 8, 11, 32, 14),
                    Block.createCuboidShape(5, 32, 8, 11, 32, 14),
                    Block.createCuboidShape(5, 4, 8, 11, 16, 14)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();,
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(7, 10, 9.25, 9, 12, 16.25), Block.createCuboidShape(7, 10, 9.25, 9, 12, 9.25), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(4, 16, 0.25, 6, 18, 5.25), Block.createCuboidShape(4, 16, 0.25, 6, 18, 0.25), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(7.25, 24, 6, 9.25, 26, 12), Block.createCuboidShape(7.25, 24, 6, 9.25, 26, 6), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(5.75, 24, -0.75, 7.75, 26, 6.25), Block.createCuboidShape(5.75, 24, -0.75, 7.75, 26, -0.75), BooleanBiFunction.OR),
            VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 6, 16, 2, 16), Block.createCuboidShape(2, 1, 8, 14, 4, 14), BooleanBiFunction.OR)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public TrainerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.trainer.tooltip.1"));
        tooltip.add(Text.translatable("tooltip.cultivation_mastery.trainer.tooltip.2"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
