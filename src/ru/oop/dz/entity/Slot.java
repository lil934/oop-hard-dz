package ru.oop.dz.entity;

import ru.oop.dz.itf.Identifiable;
import ru.oop.dz.itf.Validatable;
import ru.oop.dz.util.IdGenerator;
import ru.oop.dz.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;


public class Slot implements Identifiable, Validatable {

    private long id;
    private long startAt;
    private long endAt;
    private int basePriceCents;
    private SlotStatus status;


    public Slot(long id, long startAt, long endAt, int basePriceCents) {
        this.id = IdGenerator.nextId();
        this.startAt = startAt;
        this.endAt = endAt;
        this.basePriceCents = basePriceCents;
        this.status= SlotStatus.AVAILABLE;
    }
    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartAt() {
        return startAt;
    }

    public void setStartAt(long startAt) {
        this.startAt = startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public void setEndAt(long endAt) {
        this.endAt = endAt;
    }

    public int getBasePriceCents() {
        return basePriceCents;
    }

    public void setBasePriceCents(int basePriceCents) {
        this.basePriceCents = basePriceCents;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", basePriceCents=" + basePriceCents +
                '}';
    }

    @Override
    public List<String> validate() {
        List<String> errors = new ArrayList<>();
        if (!ValidationUtils.requireBefore(startAt, endAt)) {
            errors.add("Некорректно заполнены поля startAt,endAt");
        }
        if (!ValidationUtils.positive(basePriceCents)) {
            errors.add("Некорректно заполнено поле basePriceCents");
        }
        return errors;


    }
}
