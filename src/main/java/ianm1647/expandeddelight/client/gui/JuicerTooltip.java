package ianm1647.expandeddelight.client.gui;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

import java.util.Objects;

public class JuicerTooltip implements ClientTooltipComponent {
    private static final int ITEM_SIZE = 16;
    private static final int MARGIN = 4;
    private final int textSpacing;
    private final ItemStack drinkStack;

    public JuicerTooltip(JuicerTooltip.JuicerTooltipComponent tooltip) {
        Objects.requireNonNull(Minecraft.getInstance().font);
        this.textSpacing = 9 + 1;
        this.drinkStack = tooltip.drinkStack;
    }

    public int getHeight() {
        return this.drinkStack.isEmpty() ? this.textSpacing : this.textSpacing + 16;
    }

    public int getWidth(Font font) {
        if (!this.drinkStack.isEmpty()) {
            MutableComponent textServingsOf = this.drinkStack.getCount() == 1 ? Component.translatable("farmersdelight.tooltip.cooking_pot.single_serving", new Object[0]) : Component.translatable("farmersdelight.tooltip.cooking_pot.many_servings", this.drinkStack.getCount());
            return Math.max(font.width(textServingsOf), font.width(this.drinkStack.getHoverName()) + 20);
        } else {
            return font.width(Component.translatable("farmersdelight.tooltip.cooking_pot.empty", new Object[0]));
        }
    }

    public void renderImage(Font font, int mouseX, int mouseY, GuiGraphics gui) {
        if (!this.drinkStack.isEmpty()) {
            gui.renderItem(this.drinkStack, mouseX, mouseY + this.textSpacing, 0);
        }
    }

    public void renderText(Font font, int x, int y, Matrix4f matrix4f, MultiBufferSource.BufferSource bufferSource) {
        Integer color = ChatFormatting.GRAY.getColor();
        int gray = color == null ? -1 : color;
        MutableComponent textServingsOf;
        if (!this.drinkStack.isEmpty()) {
            textServingsOf = this.drinkStack.getCount() == 1 ? Component.translatable("farmersdelight.tooltip.cooking_pot.single_serving", new Object[0]) : Component.translatable("farmersdelight.tooltip.cooking_pot.many_servings", this.drinkStack.getCount());
            font.drawInBatch(textServingsOf, (float)x, (float)y, gray, true, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
            font.drawInBatch(this.drinkStack.getHoverName(), (float)(x + 16 + 4), (float)(y + this.textSpacing + 4), -1, true, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        } else {
            textServingsOf = Component.translatable("farmersdelight.tooltip.cooking_pot.empty");
            font.drawInBatch(textServingsOf, (float)x, (float)y, gray, true, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, 15728880);
        }
    }

    public record JuicerTooltipComponent(ItemStack drinkStack) implements TooltipComponent {
        public JuicerTooltipComponent(ItemStack drinkStack) {
            this.drinkStack = drinkStack;
        }

        public ItemStack drinkStack() {
            return this.drinkStack;
        }
    }
}
