package fr.metouais.roadtocrea.init;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.block.UltimateBedrockBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RoadToCrea.MODID);

    public static final RegistryObject<Block> ULTIMATE_BEDROCK = createBlock("ultimate_bedrock", () -> new UltimateBedrockBlock(BlockBehaviour.Properties.of(Material.STONE).destroyTime(-1f).speedFactor(0.001f).lightLevel((param) -> 15)));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(RoadToCrea.ROADTOCREA_TAB)));
        return block;
    }
}
