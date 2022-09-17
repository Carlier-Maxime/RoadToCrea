package fr.metouais.roadtocrea.universeEssence;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerUniverseEssenceProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerUniverseEssence> PLAYER_UNIVERSE_ESSENCE = CapabilityManager.get(new CapabilityToken<>() {
    });

    private PlayerUniverseEssence universeEssence = null;
    private final LazyOptional<PlayerUniverseEssence> optional = LazyOptional.of(this::createPlayerUniverseEssence);

    private @NotNull PlayerUniverseEssence createPlayerUniverseEssence() {
        if (universeEssence == null) {
            universeEssence = new PlayerUniverseEssence();
        }
        return universeEssence;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_UNIVERSE_ESSENCE) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerUniverseEssence().saveNbtData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerUniverseEssence().loadNbtData(nbt);
    }
}
