/** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
 **/

/**
 Create a Main class with the main method and start running the simulation:
 1. Create a Simulation object
 2. Load Items for Phase-1 and Phase-2
 3. Load a fleet of U1 rockets for Phase-1 and then for Phase-2
 4. Run the simulation using the fleet of U1 rockets and display the total budget required.
 5. Repeat the same for U2 rockets and display the total budget for that.
 **/

import java.io.*;
import java.util.*;

public class Main {
    // start the simulation in the main method 
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Simulation object
        Simulation sim = new Simulation();

        // Load Items for Phase-1 and Phase-2
        ArrayList<Item> phaseOneItems = sim.loadItems("Phase-1.txt");
        ArrayList<Item> phaseTwoItems = sim.loadItems("Phase-2.txt");

        // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> fleetU1Phase1 = sim.loadU1(phaseOneItems);
        ArrayList<Rocket> fleetU1Phase2 = sim.loadU1(phaseTwoItems);
        System.out.println();

        // Run the simulation using the fleet of U1 rockets and display the total budget required.
        int u1TotalBudget = sim.runSimulation(fleetU1Phase1) + sim.runSimulation(fleetU1Phase2);
        System.out.println();
        System.out.println("the total budget required (U1 rockets) is: $" + u1TotalBudget + " Million.");
        System.out.println();

        /** Repeat the same for U2 rockets and display the total budget for that. **/

        // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> fleetU2Phase1 = sim.loadU2(phaseOneItems);
        ArrayList<Rocket> fleetU2Phase2 = sim.loadU2(phaseTwoItems);
        // Run the simulation using the fleet of U2 rockets and display the total budget required.
        int u2TotalBudget = sim.runSimulation(fleetU2Phase1) + sim.runSimulation(fleetU2Phase2);
        System.out.println();
        System.out.println("the total budget required (U2 rockets) is: $" + u2TotalBudget + " Million.");
        System.out.println();

        // recommend which rocket type to use based on the costs
        if (u1TotalBudget < u2TotalBudget)
            System.out.println("Based on the total budget, U1 Rockets are recommended.");
        else if (u2TotalBudget < u1TotalBudget)
            System.out.println("Based on the total budget, U2 Rockets are recommended.");
        else
            System.out.println("Both U1 and U2 fleets cost the same. Either one is recommended.");
        System.out.println();
    }
}



