package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.base.BaseImageActor;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 地板
 *
 * @author Ziru Wang
 */
public class FloorActor extends BaseImageActor {

    /** 水平移动速度, px/s */
    private float moveVelocity;

    /** 地板纹理区域 */
    private TextureRegion region;

    /** 水平偏移量 */
    private float offerX;

    /** 地板是否在移动 */
    private boolean isMove;

    public FloorActor(FlappyWangGame mainGame) {
        super(mainGame);
        region = getMainGame().getAtlasWang().findRegion(Resource.Atlas.IMAGE_GAME_FLOOR);
        setBounds(0, 0, region.getRegionWidth(), region.getRegionHeight());
    }

    public float getMoveVelocity() {
        return moveVelocity;
    }

    public void setMoveVelocity(float moveVelocity) {
        this.moveVelocity = moveVelocity;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public void act(float delta) {
        // super.act(delta);
        if (isMove) {
            offerX += (delta * moveVelocity);
            offerX %= getWidth();
            if (offerX > 0) {
                offerX -= getWidth();
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // 绘制两次以达到视觉上的循环移动效果
        batch.draw(region, getX() + offerX, getY());
        if (Math.abs(offerX) > 0.001F) {
            batch.draw(region, getX() + (getWidth() + offerX), getY());
        }
    }

}
