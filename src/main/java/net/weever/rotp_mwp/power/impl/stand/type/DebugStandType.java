package net.weever.rotp_mwp.power.impl.stand.type;

import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;

import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.weever.rotp_mwp.util.RainbowTextUtil;
import net.weever.rotp_mwp.util.TextureUtil;

import javax.annotation.Nullable;

public class DebugStandType<T extends StandStats> extends StandType<T> {
    protected DebugStandType(Builder<T> builder) {
        super(builder);
    }

    @Override
    public boolean summon(LivingEntity user, IStandPower standPower, boolean withoutNameVoiceLine) {
        return false;
    }

    @Override
    public void unsummon(LivingEntity user, IStandPower standPower) {}

    @Override
    public void forceUnsummon(LivingEntity user, IStandPower standPower) {}

    @Override
    public ResourceLocation getIconTexture(@Nullable IStandPower power) {
        ResourceLocation randomizedTexture = TextureUtil.getRandomStandTexture();
        if (randomizedTexture != null) {
            return randomizedTexture;
        }

        return super.getIconTexture(power);
    }

    @Override
    public IFormattableTextComponent getName() {
        return RainbowTextUtil.getRainbowText("Debug Stand", true);
    }

    @Override
    public ITextComponent getPartName() {
        return RainbowTextUtil.getRainbowText("Debug", false);
    }

//    @Override
//    public int getColor() {
//        long millis = System.currentTimeMillis();
//
//        int red = (int) ((Math.sin(millis * 0.001) + 1) * 127.5);
//        int green = (int) ((Math.cos(millis * 0.001) + 1) * 127.5);
//        int blue = (int) ((Math.sin(millis * 0.002) + 1) * 127.5);
//
//        return (red << 16) | (green << 8) | blue;
//    }

    public static class Builder<T extends StandStats> extends StandType.AbstractBuilder<Builder<T>, T>{

        @Override
        protected Builder<T> getThis() {
            return this;
        }

        @Override
        public DebugStandType<T> build() {
            return new DebugStandType<>(this);
        }
    }
}
