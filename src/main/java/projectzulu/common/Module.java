package projectzulu.common;

import java.io.File;

import projectzulu.common.core.CustomEntityManager;
import projectzulu.common.core.ItemBlockManager;
import projectzulu.common.core.terrain.FeatureGenerator;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public interface Module {
    public String getIdentifier();

    public void registration(ItemBlockManager manager);

    public void registration(CustomEntityManager manager);

    public void registration(FeatureGenerator manager);

    public void preInit(FMLPreInitializationEvent event, File configDirectory);

    public void init(FMLInitializationEvent event, File configDirectory);

    public void postInit(FMLPostInitializationEvent event, File configDirectory);
    
    public void serverStarting(FMLServerStartingEvent event, File configDirectory);

    public void serverStart(FMLServerStartedEvent event, File configDirectory);
}
