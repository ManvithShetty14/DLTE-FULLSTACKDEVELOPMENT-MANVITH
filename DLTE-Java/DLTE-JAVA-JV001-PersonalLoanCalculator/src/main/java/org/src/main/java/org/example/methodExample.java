package org.example;

public class methodExample {
    public static void greet() {
        System.out.println("Hello Hi there.(public)");
    }

    private static void welcome() {
        System.out.println("Hello Hi there.(private)");
    }

    protected static void greeting() {
        System.out.println("Hello Hi there.(protected)");

    }

    public static void main(String[] args) {
        greet();
        welcome();
        greeting();

    }
}
