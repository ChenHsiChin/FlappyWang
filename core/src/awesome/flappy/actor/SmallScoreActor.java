package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * 小数字分数显示
 * 
 * @author Ziru Wang
 */
public class SmallScoreActor extends NumGroup {

    public SmallScoreActor(FlappyWangGame mainGame) {
        super(mainGame);
        Array<TextureAtlas.AtlasRegion> regions = mainGame.getAtlasFnt().findRegions(Resource.Atlas.IMAGE_NUM_SCORE_00_TO_09);
        TextureRegion[] digitRegions = new TextureRegion[regions.size];
        for (int i = 0; i < regions.size; i++) {
            digitRegions[i] = regions.get(i);
        }
        setDigitRegions(digitRegions);
    }

}



















