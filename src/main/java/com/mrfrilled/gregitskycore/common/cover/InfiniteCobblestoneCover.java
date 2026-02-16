package com.mrfrilled.gregitskycore.common.cover;

import com.gregtechceu.gtceu.api.capability.ICoverable;
import com.gregtechceu.gtceu.api.cover.CoverBehavior;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class InfiniteCobblestoneCover extends CoverBehavior {

    private TickableSubscription subscription;

    public InfiniteCobblestoneCover(CoverDefinition definition, ICoverable coverHolder, Direction attachedSide) {
        super(definition, coverHolder, attachedSide);
    }

    @Override
    public boolean canAttach() {
        BlockEntity be = coverHolder.getLevel().getBlockEntity(coverHolder.getPos());

        return super.canAttach() && be != null &&
                be.getCapability(ForgeCapabilities.ITEM_HANDLER, attachedSide).isPresent();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        subscription = coverHolder.subscribeServerTick(subscription, this::update);
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void update() {
        if (coverHolder.getOffsetTimer() % 20 == 0) { // Cada 1 segundo

            BlockEntity be = coverHolder.getLevel().getBlockEntity(coverHolder.getPos());

            if (be != null) {
                be.getCapability(ForgeCapabilities.ITEM_HANDLER, attachedSide)
                        .ifPresent(handler -> {
                            // Creamos 64 de Cobblestone
                            ItemStack cobbleStack = new ItemStack(Items.COBBLESTONE, 20);
                            // Insertamos en el inventario encontrado
                            ItemHandlerHelper.insertItemStacked(handler, cobbleStack, false);
                        });
            }
        }
    }
}
