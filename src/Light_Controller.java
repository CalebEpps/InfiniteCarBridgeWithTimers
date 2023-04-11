
/*
Partners in Crime:
Jeremy Hankinson
Caleb Epps

Project 1
Class: OS - CS 4345 Spring 2023
 */

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Light_Controller {
    // Signifies the current direction of the light
    int current_direction;
    int current_min_speed = 0;
    // Default constructor, will autoset direction to West.
    public Light_Controller() {
        current_direction = 0;
    }
    // Allows specification for direction upon instantiation. Not used for our purposes (See Light Simulation)
    public Light_Controller(int current_direction) {
        this.current_direction = current_direction;
    }

    // 0 = Westbound
    // 1 = Eastbound
    public void change_direction() {
        // Flips current direction. Could switch to shorthand conditional and return
        if (current_direction == 0) {
            // reset speed
            current_min_speed = 0;
            current_direction = 1;
        } else {
            current_direction = 0;
        }

    }
    // Returns a random time for light to keep allowing traffic to flow in one direction
    public int get_time_for_light() {
        Random random = new Random();
        return  random.nextInt(3000, 5000);
    }

    public int generate_speed() {
        return new Random().nextInt(500, 1499);

    }

    public void generate_car(int car_num) {
        Car car = new Car(car_num, generate_speed());
        System.out.println("");
        car.bridge_crossing_notice();
        Timer car_timer = new Timer();
        TimerTask car_task = new TimerTask() {
            @Override
            public void run() {
                //car.bridge_crossed_notice();
                car.bridge_crossed_notice();
                car_timer.purge();
                car_timer.cancel();
            }
        };
        car_timer.schedule(car_task, car.car_speed);
    }






}
