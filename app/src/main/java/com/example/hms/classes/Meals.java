package com.example.hms.classes;

public class Meals {
    private static String Breakfast;
    private static String Lunch;
    private static String Dinner;

    public Meals(String breakfast, String lunch, String dinner) {
        Breakfast = breakfast;
        Lunch = lunch;
        Dinner = dinner;
    }

    public Meals() {

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



}
