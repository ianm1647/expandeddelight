package com.ianm1647.expandeddelight.item.custom;

import com.ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import vazkii.patchouli.api.PatchouliAPI;

public class CookBookItem extends Item {

    public CookBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient()) {
            PatchouliAPI.get().openBookGUI((ServerPlayerEntity) user, new Identifier(ExpandedDelight.MOD_ID, "cook_book"));
            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }

    /*"text.expandeddelight.landing":
    "This cook book will guide you through Expanded Delight telling you everything you need to know about the mod!
    If you ever find yourself caught, please consult this book for all your Expanded Delight needs."
    */
}
