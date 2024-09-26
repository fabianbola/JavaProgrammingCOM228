package Excersice3;

public class Main {
    public static void main(String[] args) {
        // Call the overloaded methods and display results

        // Calculate time without traffic
        double time1 = CarTravel.calculateTime(120, 60); // 120 km at 60 km/h
        System.out.println("Travel time without traffic: " + time1 + " hours");

        // Calculate time with traffic delay
        double time2 = CarTravel.calculateTime(120, 60, 0.5); // 120 km at 60 km/h with 0.5-hour delay
        System.out.println("Travel time with traffic delay: " + time2 + " hours");

        // Calculate time based on whether the car is in traffic
        double time3 = CarTravel.calculateTime(120, 60, true); // 120 km at 60 km/h with traffic
        System.out.println("Travel time in traffic: " + time3 + " hours");

        double time4 = CarTravel.calculateTime(120, 60, false); // 120 km at 60 km/h without traffic
        System.out.println("Travel time without traffic: " + time4 + " hours");
    }
}

