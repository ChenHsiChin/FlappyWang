package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.base.BaseImageActor;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * 水管, 水管可以看做是从屏幕右边进来匀速移动到左边
 * 
 * @author Ziru Wang
 */
public class BarActor extends BaseImageActor implements Poolable {
	
	/** 水平移动速度, px/s */
    private float moveVelocity;
	
    /** 是否是上方水管 */
	private boolean isUpBar;
	
	/** 是否已被小鸟通过 */
	private boolean isPassByBird;
	
	/** 水管是否在移动 */
	private boolean isMove;
	
	public BarActor() {
		super(null);
	}
	
	public BarActor(FlappyWangGame mainGame) {
		super(mainGame);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		// 如果水管正在移动状态, 递增水管的水平位移（水平移动）
		if (isMove) {
			setX(getX() + moveVelocity * delta);
		}
	}
	
	public float getMoveVelocity() {
		return moveVelocity;
	}

	public void setMoveVelocity(float moveVelocity) {
		this.moveVelocity = moveVelocity;
	}

	public boolean isUpBar() {
		return isUpBar;
	}

	public void setUpBar(boolean isUpBar) {
        this.isUpBar = isUpBar;
        if (this.isUpBar) {
            setRegion(getMainGame().getAtlasWaterBar().findRegion(Resource.Atlas.IMAGE_BAR_DOWN));
        } else {
            setRegion(getMainGame().getAtlasWaterBar().findRegion(Resource.Atlas.IMAGE_BAR_UP));
        }
	}

	public boolean isPassByBird() {
		return isPassByBird;
	}

	public void setPassByBird(boolean isPassByBird) {
		this.isPassByBird = isPassByBird;
	}

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	@Override
	public void reset() {
		setMove(false);
		setPassByBird(false);
	}

}





















