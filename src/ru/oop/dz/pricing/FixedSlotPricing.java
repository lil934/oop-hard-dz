package ru.oop.dz.pricing;

import ru.oop.dz.entity.Slot;
import ru.oop.dz.itf.SlotPricing;

public class FixedSlotPricing implements SlotPricing {
    private Slot slot;

    public FixedSlotPricing(Slot slot) {
        this.slot = slot;
    }

    @Override
    public long basePrice() {
        long durationSlot = slot.getEndAt() - slot.getStartAt();
        long durationInMinutes = durationSlot / 60000;
        return durationInMinutes * slot.getBasePriceCents();
    }

    @Override
    public long priceWithPromo(String promoCode) {
        return basePrice();
    }
}
