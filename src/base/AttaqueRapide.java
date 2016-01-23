package base;

import java.util.Random;

import entities.AlienEntity;

public class AttaqueRapide implements StrategieAttaque
{

    @Override
    public void attaqueAlien(Game game, double dx, double x, AlienEntity entite)
    {
        // TODO Auto-generated method stub
        Random rand = new Random();
        int tir = rand.nextInt(100);
        if(tir<20)
            game.alienShot(entite);

    }

}
