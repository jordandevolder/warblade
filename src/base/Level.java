package base;

import java.util.ArrayList;

import entities.Entity;

public abstract class Level {

protected ArrayList<Entity> entities = new ArrayList<Entity>();
private ArrayList<Entity> removeList = new ArrayList<Entity>();
protected Entity ship;
protected int alienCount;
protected Game game;
protected double moveSpeed;
protected long firingInterval;


public void removeAlien()
{
    alienCount--;
}

public int getAliens()
{
    return alienCount;
}

public Entity getShip()
{
    // TODO Auto-generated method stub
    return ship;
}

public void removeEntity(Entity entity)
{
    removeList.add(entity);
}

public void removeAllEntities()
{
    entities.removeAll(removeList);
}

public void clear()
{
    removeList.clear();
}


public ArrayList<Entity> getEntities()
{
    // TODO Auto-generated method stub
    return entities;
}


public Game getGame()
{
    // TODO Auto-generated method stub
    return game;
}

public long getFiringInterval()
{
    return firingInterval;
}

public double getMoveSpeed()
{
    return moveSpeed;
}

}

