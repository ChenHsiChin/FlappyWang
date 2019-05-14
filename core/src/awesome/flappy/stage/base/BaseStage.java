package awesome.flappy.stage.base;

import awesome.flappy.FlappyWangGame;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * 舞台基类
 *
 * @author Ziru Wang
 */
public abstract class BaseStage extends Stage {

    private FlappyWangGame mainGame;

    /** 舞台是否可见（是否更新和绘制） */
    private boolean visible = true;

    public BaseStage(FlappyWangGame mainGame, Viewport viewport) {
        super(viewport);
        this.mainGame = mainGame;
    }

    public FlappyWangGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
















