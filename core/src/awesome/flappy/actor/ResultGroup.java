package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.base.BaseGroup;
import awesome.flappy.actor.framework.AnimationActor;
import awesome.flappy.actor.framework.ImageActor;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


/**
 * 分数结果显示组合, 显示 奖牌、分数、最好的分数
 *
 * @author Ziru Wang
 */
public class ResultGroup extends BaseGroup {

    /**
     * 背景
     */
    private ImageActor gameResultBgActor;

    /**
     * 奖牌
     */
    private AnimationActor medalActor;

    /**
     * 当前分数
     */
    private SmallScoreActor currScoreActor;

    /**
     * 最高分数
     */
    private SmallScoreActor bestScoreActor;

    public ResultGroup(FlappyWangGame mainGame) {
        super(mainGame);
        init();
    }


    private void init() {
        // 创建背景
        gameResultBgActor = new ImageActor(getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_GAME_RESULT_BG));
        addActor(gameResultBgActor);
        // 设置 ResultGroup 的高度为背景高度
        setSize(gameResultBgActor.getWidth(), gameResultBgActor.getHeight());

        // 创建奖牌
        medalActor = new AnimationActor(0, getMainGame().getAtlasWang().findRegions(Resource.Atlas.IMAGE_GAME_MEDAL_01_TO_08));
        medalActor.setPosition(70, 65);
        medalActor.setVisible(false);
        medalActor.setPlayAnimation(false);
        addActor(medalActor);

        // 创建当前分数的显示
        currScoreActor = new SmallScoreActor(getMainGame());
        //currScoreActor.setRightX(400);
        currScoreActor.setY(128);
        addActor(currScoreActor);

        // 创建最佳分数的显示
        bestScoreActor = new SmallScoreActor(getMainGame());
        //bestScoreActor.setRightX(320);
        bestScoreActor.setY(55);
        addActor(bestScoreActor);

        // 更新最佳分数
        updateBestScore();
    }

    /**
     * 更新当前分数
     */
    public void updateCurrScore(int currScore) {

        if (currScore < 0) {
            currScore = 0;
        }

        Preferences prefs = Gdx.app.getPreferences(Resource.Prefs.PREFS_FILE_NAME);

        // 如果当前分数大于历史保存的最佳分数, 则更新最佳分数
        if (currScore > prefs.getInteger(Resource.Prefs.KEY_BEST_SCORE, 0)) {
            // 持久化保存最佳分数到本地
            prefs.putInteger(Resource.Prefs.KEY_BEST_SCORE, currScore).flush();

            // 更新最佳分数显示
            updateBestScore();
        }

        currScoreActor.setNum(currScore);
        currScoreActor.setRightX(340);

        // 根据分数设置不同等级的奖牌
        medalActor.setVisible(true);
        if (currScore >= 28) {
            medalActor.setFixedShowKeyFrameIndex(7);
        } else if (currScore >= 24) {
            medalActor.setFixedShowKeyFrameIndex(6);
        } else if (currScore >= 20) {
            medalActor.setFixedShowKeyFrameIndex(5);
        } else if (currScore >= 16) {
            medalActor.setFixedShowKeyFrameIndex(4);
        } else if (currScore >= 12) {
            medalActor.setFixedShowKeyFrameIndex(3);
        } else if (currScore >= 8) {
            medalActor.setFixedShowKeyFrameIndex(2);
        } else if (currScore >= 4) {
            medalActor.setFixedShowKeyFrameIndex(1);
        } else {
            medalActor.setFixedShowKeyFrameIndex(0);
        }
    }

    /**
     * 更新最好的分数到界面
     */
    private void updateBestScore() {
        // 取出最佳分数
        Preferences prefs = Gdx.app.getPreferences(Resource.Prefs.PREFS_FILE_NAME);
        int bestScore = prefs.getInteger(Resource.Prefs.KEY_BEST_SCORE, 0);
        bestScoreActor.setNum(bestScore);
        bestScoreActor.setRightX(340);
    }

}



















