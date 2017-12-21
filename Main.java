/** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017)
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


    public static void main(String[] args) throws FileNotFoundException {

        // Create a Simulation object
        Simulation simulation = new Simulation();

        // Load Items for Phase-1 and Phase-2
        ArrayList<Item> phaseOneItems = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> phaseTwoItems = simulation.loadItems("Phase-2.txt");

        // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> u1PhaseOne = simulation.loadU1(phaseOneItems);
        ArrayList<Rocket> u1PhaseTwo = simulation.loadU1(phaseTwoItems);

        // Run the simulation using the fleet of U1 rockets and display the total budget required.
        int u1TotalBudget = simulation.runSimulation(u1PhaseOne) + simulation.runSimulation(u1PhaseTwo);
        System.out.println("the total budget required (U1 rockets) is: $" + u1TotalBudget + " Million.");

        /** Repeat the same for U2 rockets and display the total budget for that. **/

        // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> u2PhaseOne = simulation.loadU2(phaseOneItems);
        ArrayList<Rocket> u2PhaseTwo = simulation.loadU2(phaseTwoItems);

        // Run the simulation using the fleet of U2 rockets and display the total budget required.
        int u2TotalBudget = simulation.runSimulation(u2PhaseOne) + simulation.runSimulation(u2PhaseTwo);
        System.out.println("the total budget required (U2 rockets) is: $" + u1TotalBudget + " Million.");

    }

}
