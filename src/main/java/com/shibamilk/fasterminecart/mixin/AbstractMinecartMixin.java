package com.shibamilk.fasterminecart.mixin;


//import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends Entity {

    public AbstractMinecartMixin(EntityType<?> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    //@Inject(method = "getMaxSpeed", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/entity/vehicle/AbstractMinecart;isInWater()Z"), cancellable = true)
    @ModifyReturnValue(method = "getMaxSpeed",
            at = @At(value = "RETURN", target = "Lnet/minecraft/world/entity/vehicle/AbstractMinecart;isInWater()Z"))
    protected double getMaxSpeed(double original) { //
        return (this.isInWater() ? 8.0 : 16.0) / 80.0;
    }

}