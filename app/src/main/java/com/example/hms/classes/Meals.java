package com.example.hms.classes;

public class Meals {
    private static String Breakfast;
    private static String Lunch;
    private static String Dinner;
    private static String Bar;
    private static String Snacks;

    public Meals() {

    }

    public static String getBar() {
        return Bar;
    }

    public static void setBar(String bar) {
        Bar = bar;
    }

    public static String getSnacks() {
        return Snacks;
    }

    public static void setSnacks(String snacks) {
        Snacks = snacks;
    }

    public static String getBreakfast() {
        return Breakfast;
    }

    public static void setBreakfast(String breakfast) {
        Breakfast = breakfast;
    }

    public static String getLunch() {
        return Lunch;
    }

    public static void setLunch(String lunch) {
        Lunch = lunch;
    }

    public static String getDinner() {
        return Dinner;
    }

    public static void setDinner(String dinner) {
        Dinner = dinner;
    }

    public Meals(String breakfast, String lunch, String dinner, String Bar, String Snacks) {
        Breakfast = breakfast;
        Lunch = lunch;
        Dinner = dinner;

    }


}
