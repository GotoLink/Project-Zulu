package projectzulu.common.blocks.itemblockdeclarations;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import projectzulu.common.api.BlockList;
import projectzulu.common.blocks.BlockZuluSlab;
import projectzulu.common.blocks.ItemZuluSlab;
import projectzulu.common.core.DefaultProps;
import projectzulu.common.core.itemblockdeclaration.BlockDeclaration;

import com.google.common.base.Optional;

import cpw.mods.fml.common.registry.GameRegistry;

public class PalmTreeDoubleSlabDeclaration extends BlockDeclaration {

    public PalmTreeDoubleSlabDeclaration() {
        super("PalmTreeDoubleSlab", 2);
    }

    @Override
    protected boolean createBlock() {
        if (BlockList.palmTreePlank.isPresent()) {
            BlockList.palmTreeDoubleSlab = Optional.of((new BlockZuluSlab(BlockList.palmTreeSlab.get(),
                    BlockList.palmTreePlank.get())).setBlockName(name.toLowerCase()).setBlockTextureName(
                    DefaultProps.blockKey + ":" + name.toLowerCase()));
            return true;
        }
        return false;
    }

    @Override
    protected void registerBlock() {
        if (BlockList.palmTreeDoubleSlab.isPresent() && BlockList.palmTreeSlab.isPresent()) {
            Block block = BlockList.palmTreeDoubleSlab.get();
            GameRegistry.registerBlock(block, ItemZuluSlab.class, name.toLowerCase(), DefaultProps.BlocksModId, BlockList.palmTreeSlab.get(), block);
            OreDictionary.registerOre("slabWood", new ItemStack(block));
            OreDictionary.registerOre("slabPalm", new ItemStack(block));
            Blocks.fire.setFireInfo(block, 5, 20);
        }
    }
}
