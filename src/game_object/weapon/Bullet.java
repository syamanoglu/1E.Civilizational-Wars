package game_object.weapon;

import game_object.general.GameObject;
import game_object.general.GameObjectHandler;
import game_object.general.ObjectID;

import java.awt.*;

public class Bullet extends GameObject
{
    private GameObjectHandler gameObjectHandler;


    /**
     * Constructing the game object with given parameters.
     *
     * @param x  - x coordinate of the game object.
     * @param y  - y coordinate of the game object.
     * @param id - object id defines the type of the objects.
     */
    public Bullet(float x, float y, ObjectID id, float velX, GameObjectHandler gameObjectHandler)
    {
        super(x, y, id);

        this.gameObjectHandler = gameObjectHandler;

        this.setWidth(5);
        this.setHeight(2);

        this.velX = velX;
    }

    @Override
    public void update(GameObjectHandler gameObjectHandler)
    {
        super.update(gameObjectHandler);

        x += velX;

        this.checkCollision(gameObjectHandler);
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.fillRect((int) x, (int)y, width, height);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, width, height);
    }

    @Override
    public boolean checkCollision(GameObjectHandler gameObjectHandler)
    {
        for(GameObject gameObject : gameObjectHandler.getGame_objects())
        {
            if(gameObject.getId() != ObjectID.Character && this.getBounds().intersects(gameObject.getBounds()))
            {
                return true;
            }
        }
        return false;
    }
}