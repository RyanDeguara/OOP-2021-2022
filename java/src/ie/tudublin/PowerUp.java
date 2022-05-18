package ie.tudublin;

// powerup is applied to the player, everything that implements this interface is going to have an applyTo method
// everything that has a powerup has a n applyto method, applied to ammo and health
public interface PowerUp {
    void applyTo(Player p);
}