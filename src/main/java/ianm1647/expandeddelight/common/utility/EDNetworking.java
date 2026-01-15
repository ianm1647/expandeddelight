package ianm1647.expandeddelight.common.utility;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.client.recipebook.EDRecipeBookTypes;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public class EDNetworking {
    public EDNetworking() {
    }

    public static void init() {
        PayloadTypeRegistry.playS2C().register(EDNetworking.SendRecipeBookValuesMessage.TYPE, EDNetworking.SendRecipeBookValuesMessage.STREAM_CODEC);
    }

    public static void initClient() {
        ClientPlayNetworking.registerGlobalReceiver(EDNetworking.SendRecipeBookValuesMessage.TYPE, (payload, context) -> {
            payload.handle();
        });
    }

    public static record SendRecipeBookValuesMessage(boolean open, boolean filtering) implements CustomPacketPayload {
        public static final ResourceLocation ID = ExpandedDelight.loc("send_recipe_book_values");
        public static final CustomPacketPayload.Type<SendRecipeBookValuesMessage> TYPE;
        public static final StreamCodec<RegistryFriendlyByteBuf, SendRecipeBookValuesMessage> STREAM_CODEC;

        public SendRecipeBookValuesMessage(FriendlyByteBuf buf) {
            this(buf.readBoolean(), buf.readBoolean());
        }

        public SendRecipeBookValuesMessage(boolean open, boolean filtering) {
            this.open = open;
            this.filtering = filtering;
        }

        public static void write(RegistryFriendlyByteBuf buf, SendRecipeBookValuesMessage message) {
            buf.writeBoolean(message.open);
            buf.writeBoolean(message.filtering);
        }

        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }

        public void handle() {
            Minecraft.getInstance().execute(() -> {
                ClientRecipeBook recipeBook = Minecraft.getInstance().player.getRecipeBook();
                recipeBook.setOpen(EDRecipeBookTypes.JUICING, this.open);
                recipeBook.setFiltering(EDRecipeBookTypes.JUICING, this.filtering);
            });
        }

        public boolean open() {
            return this.open;
        }

        public boolean filtering() {
            return this.filtering;
        }

        static {
            TYPE = new CustomPacketPayload.Type(ID);
            STREAM_CODEC = StreamCodec.of(SendRecipeBookValuesMessage::write, SendRecipeBookValuesMessage::new);
        }
    }
}