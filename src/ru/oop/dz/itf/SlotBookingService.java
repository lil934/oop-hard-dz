package ru.oop.dz.itf;

import ru.oop.dz.entity.Order;
import ru.oop.dz.entity.Slot;
import ru.oop.dz.entity.User;

public interface SlotBookingService {
   public Order bookSlot(User user, Slot slot);
    public void cancelOrder(Order order, Slot slot);
}
