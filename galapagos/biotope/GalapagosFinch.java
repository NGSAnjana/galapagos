package galapagos.biotope;

/**
 * A finch.
 */
public class GalapagosFinch implements Finch {
  
    private int hitpoints;
    private final int maxHitpoints;
    private int age;
    private final int maxAge;
  
    private final Behavior behavior;
  
    /**
     * Make er new finch with specified hitpoints, maximal age and behavior.
     */
    public GalapagosFinch (int hitpoints, int maxHitpoints, int maxAge, Behavior behavior) {
        this.hitpoints = hitpoints;
        this.maxHitpoints = maxHitpoints;
        this.age = 0;
        this.maxAge = maxAge;
        this.behavior = behavior;
    }
  
    /**
     * What this finch chooses to do to the finch it has met.
     */
    public Action decide (Finch finch) {
        return behavior.decide(finch);
    }
  
    /**
     * Is this finch dead or alive?
     */
    public FinchStatus status () {
        if (hitpoints <= 0) return FinchStatus.DEAD_TICKS;
        if (age >= maxAge) return FinchStatus.DEAD_AGE;
        else return FinchStatus.ALIVE;
    }
  
    /**
     * Change this finch's hitpoints by the specified amount.
     */
    public void changeHitpoints (int change) {
        hitpoints += change;
        if (hitpoints > maxHitpoints)
            hitpoints = maxHitpoints;
    }
  
    /**
     * Make this finch older.
     */
    public void makeOlder () {
        age++;
    }
  
    /**
     * The age of the GalapagosFinch. 
     */
    public int age () {
        return age;
    }
    
    /**
     * Return the amount of hit points this finch currently has.
     */
    public int hitpoints () {
        return hitpoints;
    }
  
    /**
     * Get the response of a finch this finch has met.
     */
    public void response (Finch finch, Action action) {
        behavior.response(finch, action);
    }
  
    /**
     * The Behavior of this GalapagosFinch.
     */
    public Behavior behavior () {
        return behavior;
    }
} 