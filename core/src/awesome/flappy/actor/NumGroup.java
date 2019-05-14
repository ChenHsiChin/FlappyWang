package awesome.flappy.actor;

import awesome.flappy.FlappyWangGame;
import awesome.flappy.actor.base.BaseGroup;
import awesome.flappy.actor.framework.ImageActor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;


/**
 * 数字组显示, 将一个整数的每一位分别用一个演员来表示, 然后水平排列成一组达到显示整数的效果
 *
 * @author Ziru Wang
 */
public class NumGroup extends BaseGroup {

	private TextureRegion[] digitRegions;
	
	private final List<ImageActor> digitActorList = new ArrayList<ImageActor>();

	private int num;

    public NumGroup(FlappyWangGame mainGame) {
        super(mainGame);
    }
	
	public NumGroup(FlappyWangGame mainGame, TextureRegion[] digitRegions) {
        super(mainGame);
        setDigitRegions(digitRegions);
	}

    public TextureRegion[] getDigitRegions() {
        return digitRegions;
    }

    public void setDigitRegions(TextureRegion[] digitRegions) {
        this.digitRegions = digitRegions;
        justNumDigit(num);
    }

    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if (this.num != num && num >= 0) {
			this.num = num;
			justNumDigit(this.num);
		}
	}
	
	public void addNum(int numStep) {
		setNum(num + numStep);
	}
	
	/**
	 * 校准数字位数
	 * @param num
	 */
	private void justNumDigit(int num) {
        if (digitRegions == null) {
            return;
        }

		char[] numChars = ("" + num).toCharArray();

		if (digitActorList.size() > numChars.length) {
			int removeCount = digitActorList.size() - numChars.length;
			for (int i = 0; i < removeCount; i++) {
				removeActor(digitActorList.remove(0));
			}
		} else if (digitActorList.size() < numChars.length) {
			int addCount = numChars.length - digitActorList.size();
			for (int i = 0; i < addCount; i++) {
                ImageActor digitActor = new ImageActor();
				digitActorList.add(digitActor);
				addActor(digitActor);
			}
		}

		for (int i = 0; i < digitActorList.size(); i++) {
			TextureRegion region = digitRegions[Integer.parseInt("" + numChars[i])];
			digitActorList.get(i).setRegion(region);
		}
		
		justDigitLayout();
	}

    /**
     * 校准布局
     */
	private void justDigitLayout() {
		float digitWidth = digitActorList.get(0).getWidth();
		float digitHeight = digitActorList.get(0).getHeight();
		for (int i = 0; i < digitActorList.size(); i++) {
			digitActorList.get(i).setX(digitWidth * i);
		}
		setSize(digitWidth * digitActorList.size(), digitHeight);
	}



}















