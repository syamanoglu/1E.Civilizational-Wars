package game_object.weapon;

import game_object.general.GameObject;
import game_object.general.GameObjectHandler;
import game_object.general.ObjectID;

import java.awt.*;

public class Bullet extends GameObject
{
    // Properties
    private int bullet_type;
    private float damage;
    private GameObjectHandler gameObjectHandler;

<<<<<<< HEAD

    boolean destroyed = false;
    private Weapon weapon;

=======
>>>>>>> 59bdba8043faf655c640db0ee92334e12018a1a7
    /**
     * Constructing the game object with given parameters.
     *
     * @param x  - x coordinate of the game object.
     * @param y  - y coordinate of the game object.
     * @param id - object id defines the type of the objects.
     */
<<<<<<< HEAD
    public Bullet(float x, float y, ObjectID id, float velX, GameObjectHandler gameObjectHandler, Weapon weapon)
=======
    public Bullet(float x, float y, ObjectID id, float velX, GameObjectHandler gameObjectHandler, int bullet_type)
>>>>>>> 59bdba8043faf655c640db0ee92334e12018a1a7
    {
        super(x, y, id);
        this.weapon = weapon;
        this.gameObjectHandler = gameObjectHandler;
        this.bullet_type = bullet_type;

        this.setWidth(10);
        this.setHeight(5);

        // Damage according to the bullet type
        if(bullet_type == 0)
        {
            damage = 15f;
        }
        else if(bullet_type == 1)
        {
            damage = 30f;
        }

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
        // Rendering according to the bullet type
        if(bullet_type == 0)
            g.setColor(Color.BLACK);
        else if(bullet_type == 1)
            g.setColor(Color.RED);

        g.fillRect((int) x, (int) y, width, height);

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
            if(gameObject.getId() == ObjectID.Tile && this.getBounds().intersects(gameObject.getBounds()))
            {
                return true;
            }
        }
        return false;
    }

    public float getDamage()
    {
        return damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
