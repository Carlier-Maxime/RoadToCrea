package fr.metouais.roadtocrea.universeEssence;

import net.minecraft.nbt.CompoundTag;

public class PlayerUniverseEssence {
    private int universeEssence;
    private final int MIN_UNIVERSE_ESSENCE = 0;
    private final int MAX_UNIVERSE_ESSENCE = 1000;

    public int getUniverseEssence() {
        return universeEssence;
    }

    public void addUniverseEssence(int add) {
        this.universeEssence = Math.min(this.universeEssence + add, MAX_UNIVERSE_ESSENCE);
    }

    public void subUniverseEssence(int sub) {
        this.universeEssence = Math.max(this.universeEssence - sub, MIN_UNIVERSE_ESSENCE);
    }

    public void copyFrom(PlayerUniverseEssence source) {
        this.universeEssence = source.universeEssence;
    }

    public void saveNbtData(CompoundTag nbt) {
        nbt.putInt("universeEssence", this.universeEssence);
    }

    public void loadNbtData(CompoundTag nbt) {
        this.universeEssence = nbt.getInt("universeEssence");
    }
}
