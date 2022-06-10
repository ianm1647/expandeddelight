package com.ianm1647.expandeddelight.integration.rei.juicing;

import com.ianm1647.expandeddelight.ExpandedDelight;
import com.ianm1647.expandeddelight.integration.rei.ExpandedDelightREI;
import com.ianm1647.expandeddelight.item.ItemList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Arrow;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Environment(EnvType.CLIENT)
public class JuicingRecipeCategory implements DisplayCategory<JuicingRecipeDisplay> {
    private static final Identifier GUI_TEXTURE = new Identifier(ExpandedDelight.MOD_ID, "textures/gui/juicer_gui.png");

    public JuicingRecipeCategory() {
    }

    public Renderer getIcon() {
        return EntryStacks.of(ItemList.JUICER_ITEM);
    }

    public Text getTitle() {
        return Text.translatable(ExpandedDelight.MOD_ID + ".rei.juicing");
    }

    public CategoryIdentifier<? extends JuicingRecipeDisplay> getCategoryIdentifier() {
        return ExpandedDelightREI.JUICING;
    }

    public List<Widget> setupDisplay(JuicingRecipeDisplay display, Rectangle bounds) {
        Point origin = bounds.getLocation();
        List<Widget> widgets = new ArrayList();
        widgets.add(Widgets.createRecipeBase(new Rectangle(origin.x - 10, origin.y, 160, 85)));
        Rectangle bgBounds = new Rectangle(origin.x - 5, origin.y + 5, 150, 75);
        widgets.add(Widgets.createTexturedWidget(GUI_TEXTURE, bgBounds, 10f, 4f));
        List<EntryIngredient> ingredientEntries = display.getIngredientEntries();

        if (ingredientEntries != null) {
            for(int i = 0; i < ingredientEntries.size(); ++i) {
                Point slotLoc = new Point(bgBounds.x + 38 + i / 3 * 18, bgBounds.y + 21 + i % 3 * 18);
                widgets.add(Widgets.createSlot(slotLoc).entries((Collection)ingredientEntries.get(i)).markInput().disableBackground());
            }
        }

        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 70, bgBounds.y + 56))
                .entries(display.getContainerOutput()).markInput().disableBackground());

        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 106, bgBounds.y + 31))
                .entries((Collection)display.getOutputEntries().get(0)).markOutput().disableBackground());

        widgets.add(Widgets.createSlot(new Point(bgBounds.x + 106, bgBounds.y + 56))
                .entries((Collection)display.getOutputEntries().get(0)).markOutput().disableBackground());

        Arrow cookArrow = Widgets.createArrow(new Point(bgBounds.x + 68, bgBounds.y + 31))
                .animationDurationTicks((double)display.getCookTime());

        widgets.add(cookArrow);

        widgets.add(Widgets.createLabel(new Point(cookArrow.getBounds().x + cookArrow.getBounds().width / 2,
                cookArrow.getBounds().y - 8), Text.literal(display.getCookTime() + " t")).noShadow().centered()
                .tooltip(Text.of("Ticks")).color(Formatting.DARK_GRAY.getColorValue(), Formatting.GRAY.getColorValue()));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}