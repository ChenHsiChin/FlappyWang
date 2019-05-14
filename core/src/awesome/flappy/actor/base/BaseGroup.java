package awesome.flappy.actor.base;

import awesome.flappy.FlappyWangGame;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * 演员组基类
 * 
 * @author Ziru Wang
 */
public abstract class BaseGroup extends Group {

    private FlappyWangGame mainGame;

    public BaseGroup(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

    public FlappyWangGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(FlappyWangGame mainGame) {
        this.mainGame = mainGame;
    }

    /* 下面是便捷设置坐标的方法封装 */

    /**
     * 设置上边界的坐标
     * @param topY
     */
    public void setTopY(float topY) {
        setY(topY - getHeight());
    }

    /**
     * 获取上边界的坐标
     * @return
     */
    public float getTopY() {
        return getY() + getHeight();
    }

    /**
     * 设置右边界的坐标
     * @param rightX
     */
    public void setRightX(float rightX) {
        setX(rightX - getWidth());
    }

    /**
     * 获取右边的坐标
     * @return
     */
    public float getRightX() {
        return getX() + getWidth();
    }

    /**
     * 设置中心点坐标
     * @param centerX
     * @param centerY
     */
    public void setCenter(float centerX, float centerY) {
        setCenterX(centerX);
        setCenterY(centerY);
    }

    /**
     * 设置水平方向中心点坐标
     * @param centerX
     */
    public void setCenterX(float centerX) {
        setX(centerX - getWidth() / 2.0F);
    }

    /**
     * 设置竖直方向中心点坐标
     * @param centerY
     */
    public void setCenterY(float centerY) {
        setY(centerY - getHeight() / 2.0F);
    }

}
















