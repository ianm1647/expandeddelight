package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = ExpandedDelight.MODID)
public class MilkGoatEvent {

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        ItemStack stack = event.getItemStack();
        if (stack.is(Items.BUCKET) && event.getTarget() instanceof LivingEntity entity && !entity.isBaby()) {
            Item item = null;
            if (entity instanceof Goat) {
                item = EDItems.GOAT_MILK_BUCKET.get();
            }
            if (item != null) {
                Player player = event.getEntity();
                player.playSound(SoundEvents.GOAT_MILK, 1.0f, 1.0f);
                player.swing(event.getHand());
                ItemStack nonNullStack = ItemUtils.createFilledResult(stack, player, item.getDefaultInstance());
                player.setItemInHand(event.getHand(), nonNullStack);
                event.setCancellationResult(InteractionResult.sidedSuccess(event.getLevel().isClientSide));
            }
        }

        if (stack.is(Items.GLASS_BOTTLE) && event.getTarget() instanceof LivingEntity entity && !entity.isBaby()) {
            Item item = null;
            if (entity instanceof Goat) {
                item = EDItems.GOAT_MILK_BOTTLE.get();
            }
            if (item != null) {
                Player player = event.getEntity();
                player.playSound(SoundEvents.GOAT_MILK, 1.0f, 1.0f);
                player.swing(event.getHand());
                ItemStack nonNullStack = ItemUtils.createFilledResult(stack, player, item.getDefaultInstance());
                player.setItemInHand(event.getHand(), nonNullStack);
                event.setCancellationResult(InteractionResult.sidedSuccess(event.getLevel().isClientSide));
            }
        }
    }

}
