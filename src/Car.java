
/*
Partners in Crime:
Jeremy Hankinson
Caleb Epps

Project 1
Class: OS - CS 4345 Spring 2023
 */

public class Car {
    int car_num;
    // Car speed = amount of time to cross bridge. Higher = Slower Car
    int car_speed;

    public Car(int car_num, int car_speed) {
        this.car_num = car_num;
        this.car_speed = car_speed;
    }
    // Used for pretty printing the car's number (See Bridge Crossing Notices)
    // Generated at creation by Light_Simulation class
    public int get_num(){
        return car_num;
    }

    public int get_speed() {
        return car_speed;
    }

    // Used to signify car is crossing bridge during simulation
    public void bridge_crossing_notice() {
        // Despite what my IDE says, that double cast is NOT redundant. :D
        System.out.println("Car #" + get_num() + " is crossing the bridge in " + (double) (get_speed() / 1000.0) + " seconds.");
    }
    // Notice that car has finished crossing the bridge.
    // Could probably combine this and crossing notice using a boolean flag to return / print relevant statement
    public void bridge_crossed_notice() {
        System.out.println("Car #" + get_num() + " has crossed the bridge in " + (double) (get_speed() / 1000.0) + " seconds.");
    }

}
