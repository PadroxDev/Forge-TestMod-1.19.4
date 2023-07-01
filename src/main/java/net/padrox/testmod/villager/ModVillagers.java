package net.padrox.testmod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.padrox.testmod.TestMod;
import net.padrox.testmod.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TestMod.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TestMod.MOD_ID);

    public static final RegistryObject<PoiType> EBONY_LOG_POI = POI_TYPES.register("ebony_log_poi",
            () ->  new PoiType(ImmutableSet.of(ModBlocks.EBONY_LOG.get().defaultBlockState()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> EBONY_MASTER_LUMBERJACK = VILLAGER_PROFESSIONS.register("ebony_master_lumberjack",
            () -> new VillagerProfession("ebony_master_lumberjack", x -> x.get() == EBONY_LOG_POI.get(),
                    x -> x.get() == EBONY_LOG_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs() {
        //try {
        //    ObfuscationReflectionHelper.findMethod(PoiType.class,
        //            "registerDefaultState", PoiType.class).invoke(null, EBONY_MASTER_LUMBERJACK.get());
        //} catch(InvocationTargetException | IllegalAccessException exception) {
        //    exception.printStackTrace();
        //}
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
