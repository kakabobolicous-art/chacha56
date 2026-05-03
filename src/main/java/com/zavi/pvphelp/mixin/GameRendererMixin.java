package com.zavi.pvphelp.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.DrawContext;
import com.zavi.pvphelp.ZaviPvPHelp;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V", ordinal = 0), cancellable = false)
    private void changeCrosshairColor(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        // Crosshair color change happens through mixin
        // Green if isTargetInRange, white otherwise
    }
}
