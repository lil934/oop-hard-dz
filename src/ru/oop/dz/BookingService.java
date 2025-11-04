package ru.oop.dz;

import ru.oop.dz.entity.*;
import ru.oop.dz.itf.SlotBookingService;
import ru.oop.dz.itf.SlotPricing;
import ru.oop.dz.pricing.PromoSlotPricing;

public class BookingService implements SlotBookingService {


    @Override
    public Order bookSlot(User user, Slot slot) {
        if (slot.getStatus() != SlotStatus.AVAILABLE) {
            throw new IllegalStateException("Слот уже забронирован");
        }
        if (slot.getStartAt() <= System.currentTimeMillis()) {
            throw new IllegalStateException("Нельзя бронировать слот, который прошел");
        }
        long price;
        if (user.getPromoCode() != null) {
            SlotPricing pricing = new PromoSlotPricing(slot, user.getDiscountPercent());
            price = pricing.priceWithPromo(user.getPromoCode());
        } else {
            price = slot.getBasePriceCents();
        }
        Order order = new Order(user.getId(), slot.getId(), user.getCreatedAt(), price, OrderStatus.CREATED);
        slot.setStatus(SlotStatus.BOOKED);

        return order;
    }

    @Override
    public void cancelOrder(Order order, Slot slot) {
        order.setStatus(OrderStatus.CANCELLED);
        slot.setStatus(SlotStatus.AVAILABLE);
    }

}
