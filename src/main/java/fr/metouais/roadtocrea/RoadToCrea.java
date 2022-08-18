package fr.metouais.roadtocrea;

import fr.metouais.roadtocrea.init.ModBlocks;
import fr.metouais.roadtocrea.init.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@Mod(RoadToCrea.MODID)
public class RoadToCrea {
    public static final String MODID = "roadtocrea";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab ROADTOCREA_TAB = new CreativeModeTab(MODID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ModBlocks.ULTIMATE_BEDROCK.get().asItem().getDefaultInstance();
        }
    };
    public static final ResourceLocation DIM_ID = new ResourceLocation(MODID, "void");

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

    public static Optional<Level> getVoidWorld(MinecraftServer server) {
        return Optional.ofNullable(server.getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, DIM_ID)));
    }
}
