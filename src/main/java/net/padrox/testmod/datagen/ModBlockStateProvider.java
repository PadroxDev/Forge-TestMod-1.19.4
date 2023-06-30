package net.padrox.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.testmod.TestMod;
import net.padrox.testmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.VALERITE_BLOCK);
        blockWithItem(ModBlocks.VALERITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_VALERITE_ORE);
        blockWithItem(ModBlocks.NETHERRACK_VALERITE_ORE);
        blockWithItem(ModBlocks.ENDSTONE_VALERITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
