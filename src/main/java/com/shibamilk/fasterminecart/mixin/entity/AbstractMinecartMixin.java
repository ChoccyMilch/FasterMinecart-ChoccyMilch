package com.shibamilk.fasterminecart.mixin.entity;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.lang.annotation.Target;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends Entity
{

    public AbstractMinecartMixin(EntityType<?> type, Level level) {
        super(type, level);
    }
    /**
     * @author ChoccyMilch
     * @reason Trying to see if I can make mine carts faster.
     */
    @Overwrite
    protected double getMaxSpeed() {
        return (this.isInWater() ? 40.0D : 4.0D) / 8.0D;

    }

}