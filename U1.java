
/**  Udacity Java Course - Space Challenge Project: Mission To Mars
 **  by CIMAN01 (December 2017)
 **/


/**

The U-1 Rocket is light weight, agile and pretty safe, but can only carry a total of 18 tonnes of cargo.
It costs $60 Million to build and weighs 10 tonnes.It has a slim chance of crashing while landing but a
bigger chance of exploding when launching, both chances depend on the amount of cargo carried in the rocket.

Rocket Specifications:
-----------------------------------------------------------------
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
-----------------------------------------------------------------

Create classes U1 and U2 that extend the Rocket class and override the land and launch methods
to calculate the corresponding chance of exploding and return either true or false
based on a random number using the probability equation for each.

**/

import java.lang.*;

public class U1 extends Rocket {

    // Constructor
    public U1() {

        rocketCost = 100; // rocket Cost = $100 Million
        rocketWeight = 10000; // rocket Weight = 10000 kilograms
        maxWeight = 18000; // Max weight (with cargo) = 18000 kilograms
        currentRocketWeight = rocketWeight;
        cargoLimit = maxWeight;
        cargoCarried = currentRocketWeight;

    }

    // override the launch method to calculate the corresponding chance of exploding
    public boolean launch() {

        // Random Number between 0 and 0.999...
        double chance = Math.random();

        // Chance of launch explosion = 5% * (cargo carried / cargo limit)
        percent = 5/100f;
        chanceOfExplosion = percent * ((double) cargoCarried / (double) cargoLimit);
        //System.out.println(chanceOfExplosion);
        if (chanceOfExplosion >= chance) {
            System.out.println("U1 Exploded!");
            return false;
        } else {
            System.out.println("U1 Launched Successfully");
            return true;
          }
    }

    // override the land method to calculate the corresponding chance of crash
    public boolean land() {

        // Random Number between 0 and 0.999...
        double chance = Math.random();

        // Chance of landing crash = 1% * (cargo carried / cargo limit)
        percent = 1/100f;
        chanceOfCrash = percent * ((double) cargoCarried / (double) cargoLimit);

        if (chanceOfCrash >= chance) {
            System.out.println("U1 Crashed!");
            return false;

        } else {
            System.out.println("U1 Landed Successfully");
            return true;
          }

    }

}


