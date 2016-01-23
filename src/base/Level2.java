package base;

import entities.AlienEntity;
import entities.Entity;
import entities.ShipEntity;

public class Level2 extends Level
{

    public Level2(Game game)
    {
        moveSpeed = 300;
        firingInterval = 250;
        ship = new ShipEntity(game, "sprites/marioFace.png", 370, 550);
        entities.add(ship);
        alienCount = 0;
        StrategieAttaque stratAtk = new AttaqueRapide();
        this.game = game;
        StrategieDeplacement strat = new DeplacementNormal();
        for (int row = 0; row < 4; row++)
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
