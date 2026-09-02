package ianm1647.expandeddelight.common.entity;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDEntityTypes;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class CinnamonBoat extends Boat {
    public static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(CinnamonBoat.class, EntityDataSerializers.INT);

    public CinnamonBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public CinnamonBoat(Level level, double x, double y, double z) {
        this(EDEntityTypes.CINNAMON_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, Type.CINNAMON.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModel().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setModel(Type.byName(compound.getString("Type")));
        }
    }

    public Item getDropItem() {
        return switch (getModel()) {
            case CINNAMON -> EDItems.CINNAMON_BOAT.get();
        };
    }

    public void setModel(Type model) {
        this.entityData.set(DATA_ID_TYPE, model.ordinal());
    }

    public Type getModel() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    public enum Type implements StringRepresentable {
        CINNAMON("cinnamon", EDBlocks.CINNAMON_PLANKS.get());

        private final String name;
        private final Block planks;
        public static final StringRepresentable.EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

        Type( String name, Block planks) {
            this.name = name;
            this.planks = planks;
        }

        public String getSerializedName() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

        public Block getPlanks() {
            return this.planks;
        }

        public String toString() {
            return this.name;
        }

        public static Type byId(int id) {
            return BY_ID.apply(id);
        }

        public static Type byName(String name) {
            return CODEC.byName(name, CINNAMON);
        }

    }
}
