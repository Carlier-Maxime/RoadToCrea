package fr.metouais.roadtocrea.events;

import fr.metouais.roadtocrea.RoadToCrea;
import fr.metouais.roadtocrea.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(modid = RoadToCrea.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    private static boolean inTravelToVoid = false;

    @SubscribeEvent
    public static void onTravelToVoid(EntityTravelToDimensionEvent event) {
        if (!(event.getEntity() instanceof Player playerEntity)) return;
        String sourceDimension = playerEntity.level.dimension().toString().split(" / ")[1].split("]")[0];
        String targetDimension = event.getDimension().toString().split(" / ")[1].split("]")[0];
        MinecraftServer server = playerEntity.getServer();
        if (server == null || Objects.equals(sourceDimension, "roadtocrea:void") || !Objects.equals(targetDimension, "roadtocrea:void") || inTravelToVoid) {
            return;
        }
        inTravelToVoid = true;
        Level voidWorld = RoadToCrea.getVoidWorld(server).orElseThrow(() -> new RuntimeException("Error getting void dimension"));
        if(!voidWorld.isClientSide() && playerEntity.level instanceof ServerLevel && voidWorld instanceof ServerLevel) {
            BlockPos origin = new BlockPos(0,0,0);
            if (voidWorld.getBlockState(origin).isAir()) {
                voidWorld.setBlockAndUpdate(origin, ModBlocks.ULTIMATE_BEDROCK.get().defaultBlockState());
            }
            BlockPos tpPos = origin.above();
            while (!voidWorld.getBlockState(tpPos).isAir() || !voidWorld.getBlockState(tpPos.above()).isAir()) {
                tpPos = tpPos.above();
            }
            BlockPos finalTpPos = tpPos;
            playerEntity.changeDimension((ServerLevel) voidWorld, new ITeleporter() {
                @Override
                public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                    Entity repositionedEntity = repositionEntity.apply(false);
                    repositionedEntity.teleportTo(finalTpPos.getX()+0.5, finalTpPos.getY(), finalTpPos.getZ()+0.5);
                    return repositionedEntity;
                }
            });
        }
        inTravelToVoid = false;
        event.setCanceled(true);
    }
}
