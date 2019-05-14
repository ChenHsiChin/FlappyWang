package awesome.flappy.actor.base;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.framework.ImageActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * 演员基类
 * 
 * @author Ziru Wang
 */
public abstract class BaseImageActor extends ImageActor {

    private FlappyWangGame mainGame;

    public BaseImageActor(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

    public BaseImageActor(FlappyWangGame mainGame, TextureRegion region) {
        super(region);
        this.mainGame = mainGame;
    }

    public FlappyWangGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

}















