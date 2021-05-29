package com.go.shopping.jni;

public class Test {
    static {
        System.loadLibrary("native-lib");
    }
    public native String getString();
}
