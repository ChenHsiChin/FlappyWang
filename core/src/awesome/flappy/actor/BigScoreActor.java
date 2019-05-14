package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * 大数字分数显示
 * 
 * @author Ziru Wang
 */
public class BigScoreActor extends NumGroup {

    public BigScoreActor(FlappyWangGame mainGame) {
        super(mainGame);
        Array<TextureAtlas.AtlasRegion> atlasRegions = mainGame.getAtlasFnt().findRegions(Resource.Atlas.IMAGE_NUM_BIG_00_TO_09);
        TextureRegion[] digitRegions = new TextureRegion[atlasRegions.size];
        for (int i = 0; i < atlasRegions.size; i++) {
            digitRegions[i] = atlasRegions.get(i);
        }
        setDigitRegions(digitRegions);
    }

}



















