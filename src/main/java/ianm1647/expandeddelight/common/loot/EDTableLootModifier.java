package ianm1647.expandeddelight.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Supplier;

public class EDTableLootModifier extends AddTableLootModifier {
    public static final Supplier<MapCodec<EDTableLootModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.mapCodec((inst) -> codecStart(inst).and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable").forGetter(
                    (m) -> m.lootTable)).apply(inst, EDTableLootModifier::new)));
    private final ResourceKey<LootTable> lootTable;

    protected EDTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable) {
        super(conditionsIn, lootTable);
        this.lootTable = lootTable;
    }

    @Nonnull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        context.getResolver().get(Registries.LOOT_TABLE, this.lootTable).ifPresent((extraTable) -> {
            LootTable var10000 = extraTable.value();
            ServerLevel var10002 = context.getLevel();
            Objects.requireNonNull(generatedLoot);
            var10000.getRandomItemsRaw(context, LootTable.createStackSplitter(var10002, generatedLoot::add));
        });
        return generatedLoot;
    }
}
