package Excersice3;

public class CarTravel {

    // Method 1: Calculate time based on speed and distance
    public static double calculateTime(double distance, double speed) {
        return distance / speed;
    }

    // Method 2: Calculate time with an additional delay factor for traffic
    public static double calculateTime(double distance, double speed, double trafficDelay) {
        return (distance / speed) + trafficDelay;
    }

    // Method 3: Calculate time based on speed and whether the car is in traffic
    public static double calculateTime(double distance, double speed, boolean isInTraffic) {
        if (isInTraffic) {
            return (distance / speed) * 1.5; // Assume traffic increases travel time by 50%
        } else {
            return distance / speed;
        }
    }
}
