package fr.metouais.roadtocrea.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_HUMAN_MEAT = (new FoodProperties.Builder()).nutrition(25).saturationMod(12.5f).effect(new MobEffectInstance(MobEffects.HUNGER, 250), 0.9f).effect(new MobEffectInstance(MobEffects.CONFUSION, 1200, 9), 1f).effect(new MobEffectInstance(MobEffects.POISON, 60), 0.1f).meat().build();
    public static final FoodProperties COOKED_HUMAN_MEAT = (new FoodProperties.Builder()).nutrition(30).saturationMod(13.8f).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 5), 0.8f).effect(new MobEffectInstance(MobEffects.POISON, 60), 0.02f).meat().build();
    public static final FoodProperties RAW_HUMAN_MEAT_PIECE = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.38f).effect(new MobEffectInstance(MobEffects.HUNGER, 60), 0.9f).effect(new MobEffectInstance(MobEffects.CONFUSION, 133, 9), 1f).meat().build();
    public static final FoodProperties COOKED_HUMAN_MEAT_PIECE = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.53f).effect(new MobEffectInstance(MobEffects.CONFUSION, 100, 5), 0.8f).meat().build();
}
