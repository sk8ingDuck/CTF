package com.sk8ingduck.ctf.utils;

public interface Callback<T> {

    /**
     * Called when the action should be done
     *
     * @param t
     */

    public void done(T t);
}
