/**
 ** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
 **/


/**
 The U2 Rocket heavier than the U-1 but much safer and can carry a lot more cargo; to a total of 29 tonnes.
 However, it costs $120 Million to build and weighs 20 tonnes. It has a greater chance of crashing while
 landing than while launching, but just like the U-1 both chances depend on the amount of cargo carried.
 Rocket Specifications:
 -----------------------------------------------------------------
 Rocket cost = $120 Million
 Rocket weight = 20 Tonnes
 Max weight (with cargo) = 29 Tonnes
 Chance of launch explosion = 4% * (cargo carried / cargo limit)
 Chance of landing crash = 8% * (cargo carried / cargo limit)
 -----------------------------------------------------------------
 Create classes U1 and U2 that extend the Rocket class and override the land and launch methods
 to calculate the corresponding chance of exploding and return either true or false
 based on a random number using the probability equation for each.
 **/

public class U2 extends Rocket {
    // U2 instance data
    private double chanceOfExplosion; // Chance of launch explosion
    private double chanceOfCrash; // Chance of landing crash
    private float percentLift; // percentage
    private float percentCrash; // percentage

    // U2 constructor
    public U2() {
        setRocketCost(120); // rocket Cost = $100 Million
        setRocketWeight(20000); // rocket Weight = 10000 kilograms
        setMaxWeight(29000); // Max weight (with cargo) = 18000 kilograms
        setCurrentRocketWeight(20000); // same as rocket weight
        chanceOfExplosion = 0;
        chanceOfCrash = 0;
        percentLift = 0;
        percentCrash = 0;
    }
    // override the launch method to calculate the corresponding chance of exploding
    @Override
    public boolean launch() {
        // random number between 0 and 0.999...
        double chance = Math.random();
        // 4% or 0.04
        this.percentLift = 4/100f;
        // chance of launch explosion = 4% * (cargo carried / cargo limit)
        this.chanceOfExplosion = this.percentLift * ( (double) getCurrentRocketWeight() / getMaxWeight() );
        // if chance of failure is high enough the rocket will explode after launch
        if (this.chanceOfExplosion >= chance) {
            System.out.println("U2 Exploded!");
            return false;
        // otherwise the rocket will launch successfully
        } else {
            System.out.println("nU2 Launched Successfully");
            return true;
        }
    }

    // override the land method to calculate the corresponding chance of crash
    @Override
    public boolean land() {
        // random Number between 0 and 0.999...
        double chance = Math.random();
        // 8% or 0.08
        this.percentCrash = 8/100f;
        // chance of landing crash = 8% * (cargo carried / cargo limit)
        this.chanceOfCrash = this.percentCrash * ( (double) getCurrentRocketWeight() / getMaxWeight() );
        // if chance of failure is high enough the rocket will crash upon landing
        if (this.chanceOfCrash >= chance) {
            System.out.println("U2 Crashed!");
            return false;
        // otherwise the rocket will make it to mars successfully
        } else {
            System.out.println("U2 Landed Successfully");
            return true;
        }
    }
}
