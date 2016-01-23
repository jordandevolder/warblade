package base;

import entities.AlienEntity;

public interface StrategieDeplacement
{
    public void deplacementAlien(Game game,double dx, double x, long delta, AlienEntity entite);
}
