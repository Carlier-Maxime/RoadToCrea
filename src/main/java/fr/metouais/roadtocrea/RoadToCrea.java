package fr.metouais.roadtocrea;

import fr.metouais.roadtocrea.init.ModBlocks;
import fr.metouais.roadtocrea.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RoadToCrea.MODID)
public class RoadToCrea {
    public static final String MODID = "roadtocrea";

    public RoadToCrea() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    private void setup(FMLCommonSetupEvent e) {

    }

    private void clientSetup(FMLClientSetupEvent e) {

    }
}
