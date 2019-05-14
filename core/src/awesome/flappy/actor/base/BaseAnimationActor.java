package awesome.flappy.actor.base;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.framework.AnimationActor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


/**
 * 动画演员基类
 * 
 * @author Ziru Wang
 */
public abstract class BaseAnimationActor extends AnimationActor {

    private FlappyWangGame mainGame;

    public BaseAnimationActor(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }
    
    public BaseAnimationActor(FlappyWangGame mainGame, Animation animation) {
        super(animation);
        this.mainGame = mainGame;
    }
    
    public BaseAnimationActor(FlappyWangGame mainGame, float frameDuration, Array<? extends TextureRegion> keyFrames) {
		super(frameDuration, keyFrames);
		this.mainGame = mainGame;
    }

    public BaseAnimationActor(FlappyWangGame mainGame, float frameDuration, TextureRegion... keyFrames) {
        super(frameDuration, keyFrames);
        this.mainGame = mainGame;
    }

    public FlappyWangGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

}















