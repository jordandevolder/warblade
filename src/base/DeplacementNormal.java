package base;

import entities.AlienEntity;

public class DeplacementNormal implements StrategieDeplacement
{

    @Override
    public void deplacementAlien(Game game, double dx, double x, long delta,
            AlienEntity entite)
    {
        // if we have reached the left hand side of the screen and
        // are moving left then request a logic update
        if ((dx < 0) && (x < 10))
        {
            game.updateLogic();
        }
        // and vice versa, if we have reached the right hand side of
        // the screen and are moving right, request a logic update
        if ((dx > 0) && (x > 750))
        {
            game.updateLogic();
        }

        // proceed with normal move

        entite.x += (delta * entite.dx) / 1000;
        entite.y += (delta * entite.dy) / 1000;
    }
}