package net.padrox.testmod.datagen;

import net.padrox.testmod.block.ModBlocks;
import net.padrox.testmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.VALERITE_BLOCK.get());

        add(ModBlocks.VALERITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.VALERITE_ORE.get(), ModItems.RAW_VALERITE.get()));
        add(ModBlocks.DEEPSLATE_VALERITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_VALERITE_ORE.get(), ModItems.RAW_VALERITE.get()));
        add(ModBlocks.NETHERRACK_VALERITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_VALERITE_ORE.get(), ModItems.RAW_VALERITE.get()));
        add(ModBlocks.ENDSTONE_VALERITE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_VALERITE_ORE.get(), ModItems.RAW_VALERITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}