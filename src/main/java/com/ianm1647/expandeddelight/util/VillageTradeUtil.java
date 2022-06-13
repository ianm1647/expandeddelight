package com.ianm1647.expandeddelight.util;

import com.ianm1647.expandeddelight.item.ItemList;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class VillageTradeUtil {

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> factories.add((entity, random) ->
            new TradeOffer(new ItemStack(ItemList.ASPARAGUS, 27), new ItemStack(Items.EMERALD), 16, 2, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(new ItemStack(ItemList.SWEET_POTATO, 22), new ItemStack(Items.EMERALD), 16, 2, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(new ItemStack(ItemList.CHILI_PEPPER, 24), new ItemStack(Items.EMERALD), 16, 2, 0.05F)));
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> factories.add((entity, random) ->
                new TradeOffer(new ItemStack(ItemList.PEANUT, 30), new ItemStack(Items.EMERALD), 16, 2, 0.05F)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, factories -> factories.add((entity, random) ->
                new TradeOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(ItemList.CHEESE_WHEEL, 2), 16, 12, 0.02F)));
    }
}
