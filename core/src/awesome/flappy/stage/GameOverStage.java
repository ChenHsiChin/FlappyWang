package awesome.flappy.stage;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.ResultGroup;
import awesome.flappy.actor.framework.ImageActor;
import awesome.flappy.stage.base.BaseStage;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * 游戏结束时显示的舞台
 *
 * @author Ziru Wang
 */
public class GameOverStage extends BaseStage {

    /**
     * 游戏结束提示
     */
    private ImageActor gameOverActor;
    private ImageActor myAvator;
    /**
     * 分数结果显示
     */
    private ResultGroup resultGroup;

    /**
     * 重新开始按钮
     */
    private ImageButton restartButton;

    /**
     * 点击按钮恢复到初始状态时播放的音效
     */
    private Sound restartSound;

    public GameOverStage(FlappyWangGame mainGame, Viewport viewport) {
        super(mainGame, viewport);
        init();
    }

    private void init() {
        // 获取音效
        restartSound = getMainGame().getAssetManager().get(Resource.Audios.AUDIO_RESTART, Sound.class);
        myAvator = new ImageActor(getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_MY_AVATOR));
//
//        myAvator.setX((float) (getWidth() * 0.25));
//        myAvator.setY((float) (getHeight() * 0.9));
//        myAvator.setSize((float) (myAvator.getWidth() * 0.6), (float) (myAvator.getHeight() * 0.6));
//        addActor(myAvator);

        // 创建游戏结束提示
        gameOverActor = new ImageActor(getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_GAME_OVER));
        gameOverActor.setCenterX(getWidth() / 2);
        gameOverActor.setTopY(getHeight() - 150);
        addActor(gameOverActor);

        // 创建游戏结果显示组合
        resultGroup = new ResultGroup(getMainGame());
        resultGroup.setCenterX(getWidth() / 2);
        resultGroup.setTopY(gameOverActor.getY() - 30);
        addActor(resultGroup);

        // 创建重新开始按钮
        restartButton = new ImageButton(
                new TextureRegionDrawable(getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_GAME_START_01_TO_02, 1)),
                new TextureRegionDrawable(getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_GAME_START_01_TO_02, 2))
        );
        restartButton.setX(getWidth() / 2 - restartButton.getWidth() / 2);
        restartButton.setY(resultGroup.getY() - 30 - restartButton.getHeight());
        addActor(restartButton);

        // 按钮添加事件监听器
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                com.badlogic.gdx.utils.Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        restartSound.play();
                    }
                }, 1f);
                // 按钮点击, 播放音效
                // 重新开始游戏
                getMainGame().getGameScreen().restartReadyGame();
            }
        });
    }

    /**
     * 设置当前分数
     */
    public void setCurrentScore(int currScore) {
        resultGroup.updateCurrScore(currScore);
    }

}
















