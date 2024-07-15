package com.shibamilk.fasterminecart.mixin.entity;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends Entity {

    public AbstractMinecartMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Overwrite
    protected double getMaxSpeed() {
        return (this.isInWater() ? 40.0D : 80) / 20.0D;
    }
}