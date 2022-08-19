package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.effect.SorrowEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RoadToCrea.MODID);

    public static final RegistryObject<MobEffect> SORROW = MOB_EFFECTS.register("sorrow", () -> new SorrowEffect(MobEffectCategory.HARMFUL, 3434475));
}
