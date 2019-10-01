package com.github.peacetrue.asm;

/**
 * @author xiayx
 */
public class Target {

    public static void print1(String name) {
        System.out.println("logger:" + name);
    }

    public static String print2(String name) {
        name = "logger:" + name;
        System.out.println(name);
        return name;
    }
}
