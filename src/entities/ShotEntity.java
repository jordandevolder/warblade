package entities;

import base.Level;

/**
 * An entity representing a shot fired by the player's ship
 * 
 * @author Kevin Glass
 */
public class ShotEntity extends Entity
{
    /** The vertical speed at which the players shot moves */
    protected double moveSpeed = -300;
    /** The game in which this entity exists */
    protected Level level;
    /** True if this shot has been "used", i.e. its hit something */
    protected boolean used = false;

    /**
     * Create a new shot from the player
     * 
     * @param game
     *            The game in which the shot has been created
     * @param sprite
     *            The sprite representing this shot
     * @param x
     *            The initial x location of the shot
     * @param y
     *            The initial y location of the shot
     */
    public ShotEntity(Level level, String sprite, int x, int y)
    {
        super(sprite, x, y);

        this.level = level;

        dy = moveSpeed;
    }

    /**
     * Request that this shot moved based on time elapsed
     * 
     * @param delta
     *            The time that has elapsed since last move
     */
    public void move(long delta)
    {
        // proceed with normal move
        super.move(delta);

        // if we shot off the screen, remove ourselfs
        if (y < -100)
        {
           level.removeEntity(this);
        }
    }

    /**
     * Notification that this shot has collided with another entity
     * 
     * @parma other The other entity with which we've collided
     */
    public void collidedWith(Entity other)
    {
        // prevents double kills, if we've already hit something,
        // don't collide
        if (used)
        {
            return;
        }

        // if we've hit an alien, kill it!
        if (other instanceof AlienEntity)
        {
            // remove the affected entities
            level.removeEntity(this);
            level.removeEntity(other);

            // notify the game that the alien has been killed
            level.getGame().notifyAlienKilled();
            used = true;
        }
    }

    @Override
    public void doLogic()
    {
        // FIXME Auto-generated method stub

    }
}