package projectzulu.common;

import java.io.File;

import net.minecraft.world.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import projectzulu.common.blocks.CreeperBlossomPrimedDefault;
import projectzulu.common.blocks.FurPeltDeclaration;
import projectzulu.common.blocks.ItemBlockRecipeManager;
import projectzulu.common.blocks.itemblockdeclarations.AloeVeraDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.AloeVeraSeedsDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.AnkhDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.BlueClothArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.BrewingStandSingleDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.BrewingStandTripleDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CactusArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CampfireDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CoconutDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CoconutItem;
import projectzulu.common.blocks.itemblockdeclarations.CoconutMilkFragmentDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CoconutSeedDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CoconutShellDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.CreeperBlossomDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.DiamondScaleArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.FurArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.GenericCraftingItemsDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.GoldScaleArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.GreenClothArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.IronScaleArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.JasperDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.MobSkullsDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.NightBloomDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeDoubleSlabDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeLeavesDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeLogDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreePlankDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeSapling;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeSlabDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.PalmTreeStairsDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.QuickSandDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.RedClothArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.ScaleArmorDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.ScaleItemDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.ScrapMeatDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.SpikesDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.TombstoneDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.TumbleweedDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.UniversalFlowerPotDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.WaterDropletDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.WateredDirtDeclaration;
import projectzulu.common.blocks.itemblockdeclarations.WhiteClothArmorDeclaration;
import projectzulu.common.blocks.terrain.AloeVeraFeature;
import projectzulu.common.blocks.terrain.CreeperBlossomFeature;
import projectzulu.common.blocks.terrain.NightBloomFeature;
import projectzulu.common.blocks.terrain.PalmTreeFeature;
import projectzulu.common.core.CustomEntityManager;
import projectzulu.common.core.DefaultProps;
import projectzulu.common.core.ItemBlockManager;
import projectzulu.common.core.ProjectZuluLog;
import projectzulu.common.core.terrain.FeatureGenerator;
import projectzulu.common.dungeon.PotionEvents;
import projectzulu.common.potion.EventHandleNullPotions;
import projectzulu.common.potion.PZExtraPotionDeclaration;
import projectzulu.common.potion.PZVanillaPotionDeclaration;
import projectzulu.common.potion.PotionManager;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ProjectZulu_Blocks extends BaseModule {

    @Override
    public String getIdentifier() {
        return DefaultProps.BlocksModId;
    }

    @Override
    public void registration(ItemBlockManager manager) {
        manager.addItemBlock(new PZExtraPotionDeclaration(), new PZVanillaPotionDeclaration());

        manager.addItemBlock(new AloeVeraDeclaration(), new WateredDirtDeclaration(), new TumbleweedDeclaration(),
                new JasperDeclaration(), new PalmTreeLogDeclaration(), new PalmTreePlankDeclaration(),
                new PalmTreeSlabDeclaration(), new PalmTreeDoubleSlabDeclaration(), new PalmTreeStairsDeclaration(),
                new PalmTreeLeavesDeclaration(), new PalmTreeSapling(), new CoconutDeclaration(),
                new QuickSandDeclaration(), new NightBloomDeclaration(), new CreeperBlossomDeclaration(),
                new SpikesDeclaration(), new CampfireDeclaration(), new MobSkullsDeclaration(),
                new TombstoneDeclaration(), new UniversalFlowerPotDeclaration(), new BrewingStandSingleDeclaration(),
                new BrewingStandTripleDeclaration());

        manager.addItemBlock(new AnkhDeclaration(), new AloeVeraSeedsDeclaration(), new WaterDropletDeclaration(),
                new CoconutMilkFragmentDeclaration(), new CoconutSeedDeclaration(), new CoconutShellDeclaration(),
                new ScaleItemDeclaration(), new FurPeltDeclaration(), new GenericCraftingItemsDeclaration(),
                new CoconutItem(), new ScrapMeatDeclaration());

        manager.addItemBlock(new ScaleArmorDeclaration("scaleArmor"),
                new GoldScaleArmorDeclaration("goldscale"),
                new IronScaleArmorDeclaration("ironscale"),
                new DiamondScaleArmorDeclaration("diamondscale"), new WhiteClothArmorDeclaration(
                        "whitedesertcloth"), new RedClothArmorDeclaration(
                        "reddesertcloth"), new GreenClothArmorDeclaration(
                        "greendesertcloth"), new BlueClothArmorDeclaration(
                        "bluedesertcloth"), new CactusArmorDeclaration(
                        "cactusarmor"),
                new FurArmorDeclaration("mammothfur"));
    }

    @Override
    public void registration(CustomEntityManager manager) {
        manager.addEntity(new CreeperBlossomPrimedDefault());
    }

    @Override
    public void registration(FeatureGenerator manager) {
        manager.registerStructure(new AloeVeraFeature(), new CreeperBlossomFeature(), new NightBloomFeature(),
                new PalmTreeFeature());
    }

    @Override
    public void preInit(FMLPreInitializationEvent event, File configDirectory) {
        Configuration zuluConfig = new Configuration(new File(event.getModConfigurationDirectory(),
                DefaultProps.configDirectory + DefaultProps.defaultConfigFile));
        zuluConfig.load();
        ProjectZuluLog.info("Starting Potion Init ");
        PotionManager.loadSettings(zuluConfig);
        ProjectZuluLog.info("Finished Potion Init ");
        zuluConfig.save();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event, File configDirectory) {
        ItemBlockRecipeManager.setupBlockModuleRecipies();

        if (!PotionManager.potionModuleEnabled) {
            ProjectZuluLog.info("Skipping Potion Setup, Potion Module Disabled");
        } else {
            ProjectZuluLog.info("Starting Potion Setup ");
            PotionManager.setupAndRegisterPotions();
            MinecraftForge.EVENT_BUS.register(new PotionEvents());
            ProjectZuluLog.info("Finished Potion Setup ");
        }

        /* Turn on NullPotionHandler */
        if (PotionManager.enableNullPotionHandler) {
            MinecraftForge.EVENT_BUS.register(new EventHandleNullPotions());
        }
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event, File configDirectory) {
        /* Add Custom GameRules */
        GameRules gameRule = event.getServer().worldServerForDimension(0).getGameRules();
        /* Add Does Campfire Burn GameRule: Only if not Present */
        String ruleName = "doesCampfireBurn";
        if (!gameRule.hasRule(ruleName)) {
            gameRule.addGameRule(ruleName, "false");
        }
    }
}
