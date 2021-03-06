package team.mixxit.allotment.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import javax.annotation.Nullable;

public class TintedDoublePlantBlock extends DoublePlantBlock implements IBlockColor, IItemColor {
    private static final DoublePlantBlock grass = (DoublePlantBlock) Blocks.TALL_GRASS;

    public TintedDoublePlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int getColor(BlockState p_getColor_1_, @Nullable IBlockDisplayReader p_getColor_2_, @Nullable BlockPos p_getColor_3_, int p_getColor_4_) {
        final BlockColors colors = Minecraft.getInstance().getBlockColors();
        final BlockState grassState = grass.getDefaultState();
        return colors.getColor(grassState, p_getColor_2_, p_getColor_3_, p_getColor_4_);
    }

    @Override
    public int getColor(ItemStack p_getColor_1_, int p_getColor_2_) {
        final ItemColors colors = Minecraft.getInstance().getItemColors();
        final ItemStack grassStack = new ItemStack(grass);
        return colors.getColor(grassStack, p_getColor_2_);
    }
}
