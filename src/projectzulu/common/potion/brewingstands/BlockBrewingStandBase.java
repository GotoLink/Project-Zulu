package projectzulu.common.potion.brewingstands;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import projectzulu.common.ProjectZulu_Core;
import projectzulu.common.core.DefaultProps;
import projectzulu.common.core.GuiID;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockBrewingStandBase extends BlockContainer {

    public final int renderID;
    public Icon potionIcon;

    public BlockBrewingStandBase(int blockID, int renderID) {
        super(blockID, Material.iron);
        this.renderID = renderID;
        setCreativeTab(ProjectZulu_Core.projectZuluCreativeTab);
    }

    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    @Override
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB,
            List par6List, Entity par7Entity) {
        this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 0.60f, 0.75f);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    @Override
    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return renderID;
    }

    @Override
    public abstract TileEntity createNewTileEntity(World world);

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

//    /**
//     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
//     */
//    @Override
//    public boolean renderAsNormalBlock() {
//        return false;
//    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what,
            float these, float are) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) {
            return super.onBlockActivated(world, x, y, z, player, idk, what, these, are);
        }

        player.openGui(ProjectZulu_Core.modInstance, GuiID.BrewingStand.getID(), world, x, y, z);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        potionIcon = par1IconRegister.registerIcon(DefaultProps.blockKey + ":" + "potion");
        super.registerIcons(par1IconRegister);
    }
}