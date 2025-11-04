package ru.oop.dz.entity;

import ru.oop.dz.itf.Identifiable;
import ru.oop.dz.itf.Validatable;
import ru.oop.dz.util.IdGenerator;
import ru.oop.dz.util.ValidationUtils;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;


public class Order implements Identifiable, Validatable {

    private long id;
    private long userId;
    private long slotId;
    private long createdAt;
    private long priceCents;
    private OrderStatus status;

    public Order(long userId, long slotId, long createdAt, long priceCents, OrderStatus status) {
        this.id = IdGenerator.nextId();
        this.userId = userId;
        this.slotId = slotId;
        this.createdAt = createdAt;
        this.priceCents = priceCents;
        this.status = status;
    }
    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSlotId() {
        return slotId;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getPriceCents() {
        return priceCents;
    }

    public void setPriceCents(int priceCents) {
        this.priceCents = priceCents;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }



    @Override
    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        if (!ValidationUtils.positive(userId))
            errors.add("Некорректно заполнено поле userId");
        if (!ValidationUtils.positive(slotId))
            errors.add("Некорректно заполнено поле slotId");
        if (!ValidationUtils.requireBefore(createdAt, System.currentTimeMillis()))
            errors.add("Некорректно заполнено поле createdAt");
        if (!ValidationUtils.positive(priceCents))
            errors.add("Некорректно заполнено поле priceCents");
        return errors;

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", slotId=" + slotId +
                ", createdAt=" + createdAt +
                ", priceCents=" + priceCents ;

    }

}
