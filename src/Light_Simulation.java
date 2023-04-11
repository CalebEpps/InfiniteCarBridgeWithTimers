import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*
Partners in Crime:
Jeremy Hankinson
Caleb Epps

Project 1
Class: OS - CS 4345 Spring 2023
 */

public class Light_Simulation {
    // Create / Control Threading, Car Lists, Direction, etc.
    Light_Controller l_control = new Light_Controller();
    boolean car_flag = true;
    boolean bridge_flag = true;



    Random random = new Random();
    int west_counter = 0;
    int east_counter = 1;

    int westbound_cars = 0;
    int eastbound_cars = 0;

    public void run_simulation() {
        l_control.current_direction = 0;
        // Initialize timer variables
            // Produces infinitely generating cars using flags and timers to simulate crossing times
            while(true) {
                // Car Flag = car is currently crossing the bridge
                if(car_flag) {
                    car_flag = false;
                    // Bridge flag = Bridge has recently switched direction
                    if(bridge_flag) {
                        bridge_flag = false;
                        // Recreates bridge timer when necessary
                        Timer bridge_timer = new Timer();
                        // Task for light control
                        TimerTask bridge_task = new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("\nLIGHT CHANGED");
                                l_control.change_direction();
                                bridge_timer.cancel();
                                bridge_timer.purge();
                                bridge_flag = true;
                                if(l_control.current_direction == 0) {
                                    System.out.println("Cars heading WESTWARD\n");
                                } else {
                                    System.out.println("Cars heading EASTWARD\n");
                                }
                            }
                        };
                        bridge_timer.schedule(bridge_task, l_control.get_time_for_light());
                    }
                    // If block controls the flow of traffic in single direction. Flips when light changes.
                    if (l_control.current_direction == 0 && eastbound_cars == 0) {
                        l_control.generate_car(west_counter);
                        Timer west_timer = new Timer();
                        westbound_cars++;
                        west_counter += 2;
                        TimerTask west_task = new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println(Thread.activeCount());
                                westbound_cars--;
                                west_timer.purge();
                                west_timer.cancel();
                                car_flag = true;
                            }
                        };
                        west_timer.schedule(west_task, random.nextInt(1500, 2500));
                    } else if(l_control.current_direction == 1 && westbound_cars == 0){
                        l_control.generate_car(east_counter);
                        Timer east_timer = new Timer();
                        eastbound_cars++;
                        east_counter += 2;
                        TimerTask east_task = new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println(Thread.activeCount());
                                eastbound_cars--;
                                east_timer.purge();
                                east_timer.cancel();
                                car_flag = true;

                            }
                        };
                        east_timer.schedule(east_task, random.nextInt(1500, 2500));
                    }
                }
        }




        // end sim
        }



    }


