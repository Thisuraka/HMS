package com.example.hms.classes;

public class indoorFacilities {
    private static String SwimmingPool;
    private static String VideoGameRoom;
    private static String GameRoom;
    private static String Gym;

    public static String getSwimmingPool() {
        return SwimmingPool;
    }

    public static void setSwimmingPool(String swimmingPool) {
        SwimmingPool = swimmingPool;
    }

    public static String getVideoGameRoom() {
        return VideoGameRoom;
    }

    public static void setVideoGameRoom(String videoGameRoom) {
        VideoGameRoom = videoGameRoom;
    }

    public static String getGameRoom() {
        return GameRoom;
    }

    public static void setGameRoom(String gameRoom) {
        GameRoom = gameRoom;
    }

    public static String getGym() {
        return Gym;
    }

    public static void setGym(String gym) {
        Gym = gym;
    }

    public static String getSpa() {
        return Spa;
    }

    public static void setSpa(String spa) {
        Spa = spa;
    }

    public indoorFacilities() {
    }

    private static String Spa;
}
