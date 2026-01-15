package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.utility.trades.BasicItemListing;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNullByDefault;

@NotNullByDefault
public class EDVillagerEvents {

    public EDVillagerEvents() {
    }

    public static void init() {
        onVillagerTrades();
        onWandererTrades();
    }

    public static void onVillagerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
            trades.add(emeraldForItemsTrade(EDItems.ASPARAGUS.get(), 27, 16, 2));
            trades.add(emeraldForItemsTrade(EDItems.CHILI_PEPPER.get(), 24, 16, 2));
        });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, (trades) -> {
            trades.add(emeraldForItemsTrade(EDItems.SWEET_POTATO.get(), 22, 16, 5));
            trades.add(emeraldForItemsTrade(EDItems.PEANUT.get(), 30, 16, 5));
        });
    }

    public static void onWandererTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, (trades) -> {
            trades.add(itemForEmeraldTrade(EDItems.ASPARAGUS_SEEDS.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.CHILI_PEPPER_SEEDS.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.SWEET_POTATO.get(), 1, 1, 12));
            trades.add(itemForEmeraldTrade(EDItems.PEANUT.get(), 1, 1, 12));
        });
    }

    public static BasicItemListing emeraldForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, count), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    public static BasicItemListing itemForEmeraldTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new BasicItemListing(1, new ItemStack(item, count), maxTrades, xp, 0.05F);
    }
}
