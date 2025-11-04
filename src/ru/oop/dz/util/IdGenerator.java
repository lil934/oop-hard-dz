package ru.oop.dz.util;

import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {

    private static final AtomicLong counter = new AtomicLong(1);
    public IdGenerator() {
    }

    public static long nextId (){
        return counter.getAndIncrement();
    }

}
