package ianm1647.expandeddelight.data.advancement;

import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class EDAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
    public EDAdvancementGenerator() {
    }

    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
        AdvancementHolder expandedDelight = Advancement.Builder.advancement().display(EDItems.JUICER.get(), Component.translatable("expandeddelight.advancement.root", new Object[0]), Component.translatable("expandeddelight.advancement.root.desc"), ResourceLocation.parse("minecraft:textures/block/mud_bricks.png"), AdvancementType.TASK, false, false, false).addCriterion("seeds", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[0])).save(consumer, this.getNameId("main/root"));
    }

    protected static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike display, String name, AdvancementType frame, boolean showToast, boolean announceToChat, boolean hidden) {
        return Advancement.Builder.advancement().parent(parent).display(display, Component.translatable("expandeddelight.advancement." + name), Component.translatable("expandeddelight.advancement." + name + ".desc", new Object[0]), null, frame, showToast, announceToChat, hidden);
    }

    private String getNameId(String id) {
        return "expandeddelight:" + id;
    }
}
