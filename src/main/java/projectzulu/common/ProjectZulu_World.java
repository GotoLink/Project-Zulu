package projectzulu.common;

import projectzulu.common.blocks.itemblockdeclarations.StructurePlacerDeclaration;
import projectzulu.common.core.DefaultProps;
import projectzulu.common.core.ItemBlockManager;
import projectzulu.common.core.terrain.FeatureGenerator;
import projectzulu.common.world.terrain.CathedralFeature;
import projectzulu.common.world.terrain.CemetaryFeature;
import projectzulu.common.world.terrain.LabyrinthFeature;
import projectzulu.common.world.terrain.OasisFeature;
import projectzulu.common.world.terrain.PyramidFeature;

public class ProjectZulu_World extends BaseModule {

    @Override
    public String getIdentifier() {
        return DefaultProps.WorldModId;
    }

    @Override
    public void registration(ItemBlockManager manager) {
        manager.addItemBlock(new StructurePlacerDeclaration());
    }

    @Override
    public void registration(FeatureGenerator manager) {
        manager.registerStructure(new PyramidFeature(), new LabyrinthFeature(), new CemetaryFeature(),
                new OasisFeature(), new CathedralFeature());
    }
}
