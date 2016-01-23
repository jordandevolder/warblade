package base;

import java.util.Random;

import entities.AlienEntity;

public class AttaqueBasique implements StrategieAttaque
{

    public void attaqueAlien(Game game, double dx, double x,AlienEntity entite)
    {
        Random rand = new Random();
        int tir = rand.nextInt(100);
        if(tir<8)
            game.alienShot(entite);
    }

}
