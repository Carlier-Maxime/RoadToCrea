package fr.metouais.roadtocrea.events;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.universeEssence.PlayerUniverseEssence;
import fr.metouais.roadtocrea.universeEssence.PlayerUniverseEssenceProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RoadToCrea.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player) {
            if (!player.getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).isPresent()) {
                event.addCapability(new ResourceLocation(RoadToCrea.MODID, "properties"), new PlayerUniverseEssenceProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerUniverseEssenceProvider.PLAYER_UNIVERSE_ESSENCE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerUniverseEssence.class);
    }
}
