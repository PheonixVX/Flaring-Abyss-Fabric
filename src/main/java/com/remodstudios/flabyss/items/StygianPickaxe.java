package com.remodstudios.flabyss.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class StygianPickaxe extends PickaxeItem {
    protected StygianPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.applyStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 5, 2));
        return super.postHit(stack, target, attacker);
    }
}
