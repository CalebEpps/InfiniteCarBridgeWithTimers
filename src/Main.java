
/*
Partners in Crime:
Jeremy Hankinson
Caleb Epps

Project 1
Class: OS - CS 4345 Spring 2023
 */

public class Main {
    public static void main(String[] args) {
        // Create / Run Light_Simulation here
        Main_Thread main_th = new Main_Thread();
        Thread main_thread = new Thread(main_th);
        main_thread.start();
    }

    static class Main_Thread implements Runnable {
        @Override
        public void run() {
            Light_Simulation l_sim = new Light_Simulation();
            l_sim.run_simulation();
        }
    }
}

