package base;

import entities.AlienEntity;
import entities.Entity;
import entities.ShipEntity;

public class Level3 extends Level
{

    public Level3(Game game)
    {
        moveSpeed = 200;
        firingInterval = 350;
        ship = new ShipEntity(game, "sprites/marioFace.png", 370, 550);
        entities.add(ship);
        alienCount = 0;
        this.game = game;
        StrategieAttaque stratAtk = new AttaqueMeurtriere();
        StrategieDeplacement strat = new DeplacementSinusoidale();
        for (int row = 0; row < 5; row++)
        {
            for (int x = 0; x < 10; x++)
            {
                Entity alien = new AlienEntity(game,"sprites/bowser.png",100 + (x * 50), (50) + row * 30, strat,stratAtk);
                entities.add(alien);
                alienCount++;
            }
        }
    }
    
}
