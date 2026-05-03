package com.zavi.pvphelp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.hit.HitResult;

public class ZaviPvPHelp implements ClientModInitializer {
    
    public static boolean isTargetInRange = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            isTargetInRange = false;
            
            if (mc.player == null || mc.world == null) return;
            
            if (mc.crosshairTarget != null && mc.crosshairTarget.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((net.minecraft.util.hit.EntityHitResult) mc.crosshairTarget).getEntity();
                if (entity instanceof LivingEntity && entity != mc.player) {
                    if (mc.player.distanceTo(entity) <= 3.0) {
                        isTargetInRange = true;
                    }
                }
            }
        });
    }
}
