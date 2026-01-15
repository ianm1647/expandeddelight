package ianm1647.expandeddelight.common.utility.trades;

import net.minecraft.core.component.DataComponentPredicate;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BasicItemListing implements VillagerTrades.ItemListing {
    protected final ItemStack price;
    protected final ItemStack price2;
    protected final ItemStack forSale;
    protected final int maxTrades;
    protected final int xp;
    protected final float priceMult;

    public BasicItemListing(ItemStack price, ItemStack price2, ItemStack forSale, int maxTrades, int xp, float priceMult) {
        this.price = price;
        this.price2 = price2;
        this.forSale = forSale;
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMult = priceMult;
    }

    public BasicItemListing(ItemStack price, ItemStack forSale, int maxTrades, int xp, float priceMult) {
        this(price, ItemStack.EMPTY, forSale, maxTrades, xp, priceMult);
    }

    public BasicItemListing(int emeralds, ItemStack forSale, int maxTrades, int xp, float mult) {
        this(new ItemStack(Items.EMERALD, emeralds), forSale, maxTrades, xp, mult);
    }

    public BasicItemListing(int emeralds, ItemStack forSale, int maxTrades, int xp) {
        this(new ItemStack(Items.EMERALD, emeralds), forSale, maxTrades, xp, 1.0F);
    }

    public @Nullable MerchantOffer getOffer(Entity entity, RandomSource p_219694_) {
        ItemCost cost = new ItemCost(this.price.getItemHolder(), this.price.getCount(), DataComponentPredicate.EMPTY, this.price);
        Optional<ItemCost> optionalSecondCost = this.price2.isEmpty() ? Optional.empty() : Optional.of(new ItemCost(this.price2.getItemHolder(), this.price2.getCount(), DataComponentPredicate.EMPTY, this.price2));
        return new MerchantOffer(cost, optionalSecondCost, this.forSale, this.maxTrades, this.xp, this.priceMult);
    }
}