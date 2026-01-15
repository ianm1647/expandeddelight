package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.common.registry.EDItems;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;

public class MilkGoatEvent {

    public static void init() {
        UseEntityCallback.EVENT.register(((player, level, hand, entity, entityHitResult) -> {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(Items.BUCKET) && entity instanceof LivingEntity living && !living.isBaby()) {
                Item item = null;
                if (entity instanceof Goat) {
                    item = EDItems.GOAT_MILK_BUCKET.get();
                }
                if (item != null) {
                    player.playSound(SoundEvents.GOAT_MILK, 1.0f, 1.0f);
                    ItemStack nonNullStack = ItemUtils.createFilledResult(stack, player, item.getDefaultInstance());
                    player.setItemInHand(hand, nonNullStack);
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            return InteractionResult.PASS;
        }));


    }

}
