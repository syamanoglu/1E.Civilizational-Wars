package game_management;


import game_object.general.GameObjectHandler;
import game_object.general.ObjectID;

import java.awt.*;

public class GameManager
{
    //Properties
    private InputManager inputManager;

    public GameManager()
    {
        inputManager = new InputManager();

        this.generateCharacter();
        this.generateEnemies();
        this.generateTiles();
    }

    /**
     *  Generates the character according to the current level
     */
    public void generateCharacter()
    {
        GameObjectHandler.getInstance().addGameObject(ObjectID.ClassicFighter, LevelManager.getInstance().getCurrentLevel().getCharacterPositions());
    }

    /**
     *  Generates the enemies according to the current level
     */
    public void generateEnemies()
    {
        GameObjectHandler.getInstance().addGameObject(ObjectID.ModernSoldier, LevelManager.getInstance().getCurrentLevel().getEnemyPositions());
    }

    /**
     *  Generates the tiles according to the current level
     */
    public void generateTiles()
    {
        GameObjectHandler.getInstance().addTile(LevelManager.getInstance().getCurrentLevel().getLevelTileMap());
    }

    /**
     *
     */
    public void update()
    {
        GameObjectHandler.getInstance().updateAll();
    }

    /**
     *
     */
    public void render(Graphics g)
    {
        GameObjectHandler.getInstance().renderAll(g);
    }

    // Access
    public InputManager getInputManager()
    {
        return inputManager;
    }
}
