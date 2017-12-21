/**  Udacity Java Course - Space Challenge Project: Mission To Mars
 **  by CIMAN01 (December 2017)
 **/


/**

The U2 Rocket heavier than the U-1 but much safer and can carry a lot more cargo; to a total of 29 tonnes.
However, it costs $120 Million to build and weighs 20 tonnes. It has a greater chance of crashing while
landing than while launching, but just like the U-1 both chances depend on the amount of cargo carried.

Rocket Specifications:
-----------------------------------------------------------------
Rocket cost = $120 Million
Rocket weight = 18 Tonnes   --> we will work with 18 not 20! (see up!)
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
-----------------------------------------------------------------

Create classes U1 and U2 that extend the Rocket class and override the land and launch methods
to calculate the corresponding chance of exploding and return either true or false
based on a random number using the probability equation for each.

**/

import java.util.*;

public class U2 extends Rocket {

    private Random random = new Random();
    private double chance = random.nextDouble();

    // Constructor
    public U2() {

        rocketCost = 120000000;     // rocket Cost = $120 Million
        rocketWeight = 18000;       // rocket Weight = 18000 kilograms
        rocketMaxWeight = 29000;    // rocket Max weight (with cargo) = 29000 kilograms
        currentRocketWeight = rocketWeight;
        cargoLimit = rocketMaxWeight - rocketWeight; // 11000 kilograms
        cargoCarried = currentRocketWeight - rocketWeight;

    }

    // override the launch method to calculate the corresponding chance of exploding
    public boolean launch() {
        percent = 0.04;
        // Chance of launch explosion = 4% * (cargo carried / cargo limit)
        chanceOfExplosion = percent *  ( (double)cargoCarried / (double)cargoLimit);

        if (chanceOfExplosion >= chance) {
            System.out.println("U2 Exploded!");
            return false;
        } else {
            System.out.println("U2 Launched Successfully");
        }

        return true;

    }

    // override the land method to calculate the corresponding chance of crash
    public boolean land() {

        percent = 0.08;

        // Chance of landing crash = 8% * (cargo carried / cargo limit)
        chanceOfCrash = percent * ((double) cargoCarried / (double) cargoLimit);

        if (chanceOfCrash >= chance) {
            System.out.println("U2 Crashed!");
            return false;

        } else {
            System.out.println("U2 Landed Successfully");
        }

        return true;
    }

}


