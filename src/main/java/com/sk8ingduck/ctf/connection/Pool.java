package com.sk8ingduck.ctf.connection;

public interface Pool<PooledType> {

    PooledType checkOut();

    void checkIn(PooledType instance);

    int getPoolSize();
}