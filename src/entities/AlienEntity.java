package entities;

import base.Game;
import base.StrategieAttaque;
import base.StrategieDeplacement;

/**
 * An entity which represents one of our space invader aliens.
 * 
 * @author Kevin Glass
 */
public class AlienEntity extends Entity {
	/** The speed at which the alien moves horizontally */
	private double moveSpeed = 75;
	/** The game in which the entity exists */
	private Game game;
	private StrategieDeplacement strategieDeplacement;
	private StrategieAttaque strategieAttaque;
	public boolean isAleatoire;
	/**
	 * Create a new alien entity
	 * 
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The initial x location of this alien
	 * @param y The initial y location of this alien
	 */
	public AlienEntity(Game game,String ref,int x,int y,StrategieDeplacement stratMv,StrategieAttaque stratAtk) {
		super(ref,x,y);
		this.game=game;
		dx = -moveSpeed;
		strategieDeplacement = stratMv;
		strategieAttaque=stratAtk;
	}
	public void attack()
	{
	    strategieAttaque.attaqueAlien(game, dx, x, this);
	}
	/**
	 * Request that this alien moved based on time elapsed
	 * 
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) 
	{
        strategieDeplacement.deplacementAlien(game,dx,x,delta,this);
	}
	
	/**
	 * Update the game logic related to aliens
	 */

	public void doLogic() {
		// swap over horizontal movement and move down the
		// screen a bit
		dx = -dx;
		y += 10;
		
		// if we've reached the bottom of the screen then the player
		// dies
		if (y > 570) {
			game.notifyDeath();
		}
	}
	
	/**
	 * Notification that this alien has collided with another entity
	 * 
	 * @param other The other entity
	 */
	public void collidedWith(Entity other) {
		// collisions with aliens are handled elsewhere
	}

    public void setStrategie(StrategieDeplacement strat)
    {
        // TODO Auto-generated method stub
        strategieDeplacement=strat;
    }
}