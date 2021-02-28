package team.mixxit.allotment.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import team.mixxit.allotment.AllotmentMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, AllotmentMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected  void registerModels() {
        block("test_block");
        //flower("forget_me_not");
        //flower("coral_small_peony");
        //flower("small_peony");

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "test_item");

        builderForBlock(itemGenerated, "forget_me_not");
        builderForBlock(itemGenerated, "coral_small_peony");
        builderForBlock(itemGenerated, "small_peony");
        builderForBlock(itemGenerated, "blue_hyacinth");
        builderForBlock(itemGenerated, "cream_hyacinth");
        builderForBlock(itemGenerated, "orange_hyacinth");
        builderForBlock(itemGenerated, "red_hyacinth");
        builderForBlock(itemGenerated, "violet_hyacinth");
        builderForBlock(itemGenerated, "white_hyacinth");
        builderForBlock(itemGenerated, "yellow_hyacinth");
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
}