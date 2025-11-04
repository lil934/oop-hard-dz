package ru.oop.dz.pricing;

import ru.oop.dz.entity.Slot;
import ru.oop.dz.itf.SlotPricing;

public class PromoSlotPricing implements SlotPricing {
    private Slot slot;
    private int discountPercent;

    public PromoSlotPricing(Slot slot, int discountPercent) {
        this.slot = slot;
        this.discountPercent = discountPercent;
    }

    @Override
    public long basePrice() {
        long durationSlot = slot.getEndAt() - slot.getStartAt();
        long durationInMinutes = durationSlot / 60000;
        return durationInMinutes * slot.getBasePriceCents();
    }

    @Override
    public long priceWithPromo(String promoCode) {
        if (promoCode != null && !promoCode.isEmpty()) {
            return (long) (basePrice() * (100.0 - discountPercent) / 100);
        }
        return basePrice();
    }
}

