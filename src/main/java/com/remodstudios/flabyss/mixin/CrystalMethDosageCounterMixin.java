package com.remodstudios.flabyss.mixin;

import com.remodstudios.flabyss.items.ItemRegistry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class CrystalMethDosageCounterMixin {
    int dosageCounter = 0;

    @Inject(at = @At("HEAD"), method = "eatFood")
    public void eatFoodInject (World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        if (stack.getItem().equals(ItemRegistry.CRYSTAL_METH) && stack.getMaxUseTime() == 1.6) {
            dosageCounter++;
            int deathChance = world.random.nextInt(10) + dosageCounter;
            if (10 < deathChance) {
                ((PlayerEntity) (Object) this).damage(DamageSource.IN_WALL, 300);
            }
        } else {
            // Decrement high status while eating normal food.
            dosageCounter--;
        }
    }

    /* Pichu, lay of the crystal meth while coding.
    public ItemStack eatFood(World world, ItemStack stack, PlayerEntity player) {
        int dosageCounter = 0;
        if(stack.getName() == ItemRegistry.CRYSTAL_METH && stack.getMaxUseTime()==1.6){
            dosageCounter++;
            int deathRandom = world.random.nextInt(10);
            int deathChance = deathRandom + dosageCounter;
            if (10 < deathChance) {
                player.damage(DamageSource.IN_WALL, 300);
            }
        }
        return stack;
    }*/
}