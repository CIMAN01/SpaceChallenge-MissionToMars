/**
 ** Udacity Java Course - Space Challenge Project: Mission To Mars
 ** by CIMAN01 (December 2017 / modified November 2019)
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

public class U1 extends Rocket {
    // U1 instance data
    private double chanceOfExplosion; // Chance of launch explosion
    private double chanceOfCrash; // Chance of landing crash
    private float percentLift; // percentage
    private float percentCrash; // percentage

    // U1 constructor
    public U1() {
        setRocketCost(100); // rocket Cost = $100 Million
        setRocketWeight(10000); // rocket Weight = 10000 kilograms
        setMaxWeight(18000); // Max weight (with cargo) = 18000 kilograms
        setCurrentRocketWeight(10000); // same as rocket weight
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
        // 5% or 0.05
        this.percentLift = 5/100f;
        // chance of launch explosion = 5% * (cargo carried / cargo limit)
        this.chanceOfExplosion = this.percentLift * ( (double) getCurrentRocketWeight() / getMaxWeight() );
        // if chance of failure is high enough the rocket will explode after launch
        if (this.chanceOfExplosion >= chance) {
            System.out.println();
            System.out.println("U1 Exploded!");
            return false;
        // otherwise the rocket will launch successfully
        } else {
            System.out.println("U1 Launched Successfully");
            return true;
        }
    }

    // override the land method to calculate the corresponding chance of crash
    @Override
    public boolean land() {
        // random Number between 0 and 0.999...
        double chance = Math.random();
        // 1% or 0.01
        this.percentCrash = 1/100f;
        // chance of landing crash = 1% * (cargo carried / cargo limit)
        this.chanceOfCrash = this.percentCrash * ( (double) getCurrentRocketWeight() / getMaxWeight() );
        // if chance of failure is high enough the rocket will crash upon landing
        if (this.chanceOfCrash >= chance) {
            System.out.println("U1 Crashed!");
            return false;
        // otherwise the rocket will make it to mars successfully
        } else {
            System.out.println("U1 Landed Successfully");
            return true;
        }
    }
}
