package team.mixxit.allotment.data.client;

import net.minecraft.block.FlowerBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import team.mixxit.allotment.AllotmentMod;
import team.mixxit.allotment.setup.ModBlocks;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AllotmentMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected  void registerModels() {
        //block("test_block");
        block("lawn_block");
        block("hose_reel");

        // TODO All firewood bundles in one array; iterate with for loop
        block("spruce_firewood_bundle");

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        //builder(itemGenerated, "test_item");

        for (RegistryObject<FlowerBlock> _flower : ModBlocks._COLLECTION_FLOWERS) {
            builderForBlock(itemGenerated, _flower.getId().getPath());
        }
        builderForBlock(itemGenerated, "pampas_grass", "pampas_grass_top_yellow");
        builderForBlock(itemGenerated, "pink_pampas_grass", "pampas_grass_top_pink");
    }

    private void block(String name) {
        withExistingParent(name, modLoc("block/" + name));
    }

    private void flower(String name) {
        singleTexture(name, modLoc("block/" + name), modLoc("block/" + name));
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder builderForBlock(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "block/" + name);
    }
    private ItemModelBuilder builderForBlock(ModelFile itemGenerated, String name, String textureName) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "block/" + textureName);
    }
}
