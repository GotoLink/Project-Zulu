package projectzulu.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemZuluSlab extends ItemSlab {

    public ItemZuluSlab(Block block, BlockZuluSlab halfSlab, BlockZuluSlab doubleSlab) {
        super(block, halfSlab, doubleSlab, block == doubleSlab);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return ((BlockSlab)field_150939_a).func_150002_b(par1ItemStack.getItemDamage());
    }
}
