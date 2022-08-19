package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RoadToCrea.MODID);

    public static final RegistryObject<SoundEvent> SORROW = registerSoundEffect("sorrow");

    private static RegistryObject<SoundEvent> registerSoundEffect(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(name, RoadToCrea.MODID)));
    }
}
