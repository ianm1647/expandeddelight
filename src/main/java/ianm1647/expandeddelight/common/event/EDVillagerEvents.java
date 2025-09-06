package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.registry.EDItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@EventBusSubscriber(
        modid = ExpandedDelight.MODID
)
@ParametersAreNonnullByDefault
public class EDVillagerEvents {

    public EDVillagerEvents() {
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            VillagerProfession profession = event.getType();
            ResourceLocation professionKey = BuiltInRegistries.VILLAGER_PROFESSION.getKey(profession);
            if (professionKey.getPath().equals("farmer")) {
                trades.get(1).add(emeraldForItemsTrade(EDItems.ASPARAGUS.get(), 27, 16, 2));
                trades.get(1).add(emeraldForItemsTrade(EDItems.CHILI_PEPPER.get(), 24, 16, 2));
                trades.get(2).add(emeraldForItemsTrade(EDItems.SWEET_POTATO.get(), 22, 16, 5));
                trades.get(2).add(emeraldForItemsTrade(EDItems.PEANUT.get(), 30, 16, 5));

                trades.get(4).add(itemForEmeraldTrade(EDItems.CINNAMON_STICK.get(), 4, 16, 12));
            }
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
            trades.add(itemForEmeraldTrade(EDItems.ASPARAGUS_SEEDS.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.CHILI_PEPPER_SEEDS.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.SWEET_POTATO.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.PEANUT.get(), 1, 1, 12));
    }

    public static BasicItemListing emeraldForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, count), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    public static BasicItemListing itemForEmeraldTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new BasicItemListing(1, new ItemStack(item, count), maxTrades, xp, 0.05F);
    }
}
