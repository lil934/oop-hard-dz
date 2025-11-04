package ru.oop.dz.itf;

public interface SlotPricing {
    public long basePrice();

    public long priceWithPromo(String promoCode);
}
