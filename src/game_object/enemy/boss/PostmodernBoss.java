package game_object.enemy.boss;

import game_object.general.GameObjectHandler;
import game_object.general.ObjectID;
import texture_stuff.ImageLoader;

import java.awt.*;

/**
 * Created by bmmuradov on 15/12/2017.
 */
public class PostmodernBoss extends Boss {

    //Properties
    private ImageLoader imageLoader;

    /**
     *  Constructs the boss for the post-modern level
     *  @param x - x coordinate of the post-modern boss
     *  @param y - y coordinate of the post-modern boss
     *  @param id - id of the post-modern boss
     */
    public PostmodernBoss(double x, double y, ObjectID id)
    {
        super(x, y, id);
        imageLoader= new ImageLoader(ObjectID.PostModernBoss);

        setWidth(150);
        setHeight(150);
    }

    @Override
    public void render(Graphics g)
    {
        super.render(g);

        // Boss
        g.drawImage(imageLoader.getBoss_still()[0], (int) x, (int) (y), width, height, null);
    }

    @Override
    public void update (){
        super.update();
    }

    @Override
    public void addAttackObject()
    {
        double lo = x - 200;
        double hi = x + 200;

        double randX = (Math.random() * (hi - lo)) + lo;

        GameObjectHandler.getInstance().addBossObject(new BossAttackObject(randX, 20, ObjectID.BossAttackObject, 3));
    }


}
