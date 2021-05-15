package dev.technici4n.debug.mixin;

import net.minecraft.util.Tickable;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Disables block entity ticking.
 */
@Mixin(World.class)
public class WorldMixin {
    @Redirect(
            method = "tickBlockEntities",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Tickable;tick()V"
            ),
            require = 1,
            allow = 1
    )
    public void tick(Tickable tick) {
        // Do nothing!
    }
}
