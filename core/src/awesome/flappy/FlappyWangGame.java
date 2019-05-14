package awesome.flappy;

import awesome.flappy.screen.GameScreen;
import awesome.flappy.util.Resource;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


/**
 * 游戏主程序入口类
 *
 * @author Ziru Wang
 */
public class FlappyWangGame extends Game {

    public static final String TAG = "FlappyWang";

    /**
     * 世界宽度
     */
    private float worldWidth;
    /**
     * 世界高度
     */
    private float worldHeight;

    /**
     * 资源管理器
     */
    private AssetManager assetManager;

    /**
     * 纹理图集
     */
    private TextureAtlas atlasFnt;
    private TextureAtlas atlasWaterBar;
    private TextureAtlas atlasWang;

    /**
     * 主游戏场景
     */
    private GameScreen gameScreen;

    @Override
    public void create() {
        // 设置 LOG 输出级别
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        // 为了不压扁或拉长图片, 按实际屏幕比例计算世界宽高
        worldWidth = Resource.FIX_WORLD_WIDTH;
        worldHeight = Gdx.graphics.getHeight() * worldWidth / Gdx.graphics.getWidth();

        Gdx.app.log(TAG, "World Size: " + worldWidth + " * " + worldHeight);

        // 创建资源管理器
        assetManager = new AssetManager();

        // 加载资源
        assetManager.load(Resource.Atlas.ATLAS_PATH_FNT, TextureAtlas.class);
        assetManager.load(Resource.Atlas.ATLAS_PATH_WATER_BAR, TextureAtlas.class);
        assetManager.load(Resource.Atlas.ATLAS_PATH_WANG, TextureAtlas.class);

        assetManager.load(Resource.Audios.AUDIO_DIE, Sound.class);
        assetManager.load(Resource.Audios.AUDIO_HIT, Sound.class);
        assetManager.load(Resource.Audios.AUDIO_TOUCH, Sound.class);
        assetManager.load(Resource.Audios.AUDIO_RESTART, Sound.class);
        assetManager.load(Resource.Audios.AUDIO_SCORE, Sound.class);
        assetManager.load(Resource.Audios.AUDIO_START_MUSIC, Music.class);
        assetManager.load(Resource.Audios.AUDIO_FURY, Music.class);

        loadingSounds(Gdx.files.internal(Resource.Audios.AUDIO_BASE_DIR + "/random").list());
        loadingSounds(Gdx.files.internal(Resource.Audios.AUDIO_BASE_DIR + "/depth").list());
        loadingSounds(Gdx.files.internal(Resource.Audios.AUDIO_BASE_DIR + "/result").list());

        // 等待资源加载完毕
        assetManager.finishLoading();
        while (true) {
            if (assetManager.update()) {
                // 获取资源
                atlasFnt = assetManager.get(Resource.Atlas.ATLAS_PATH_FNT, TextureAtlas.class);
                atlasWaterBar = assetManager.get(Resource.Atlas.ATLAS_PATH_WATER_BAR, TextureAtlas.class);
                atlasWang = assetManager.get(Resource.Atlas.ATLAS_PATH_WANG, TextureAtlas.class);
                // 创建主游戏场景
                gameScreen = new GameScreen(this);
                // 设置当前场景
                setScreen(gameScreen);
                break;
            }
        }
    }

    private void loadingSounds(FileHandle[] files) {
        if (files != null && files.length > 0) {
            for (FileHandle file : files) {
                if (file.toString().contains("wav")) {
                    assetManager.load(file.toString(), Sound.class);
                }
            }
        }
    }

    @Override
    public void render() {
        // 黑色清屏
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // 父类渲染场景
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        // 应用退出时需要手动销毁场景
        if (gameScreen != null) {
            gameScreen.dispose();
        }
        // 应用退出时释放资源
        if (assetManager != null) {
            assetManager.dispose();
        }
    }

    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public TextureAtlas getAtlasWang() {
        return atlasWang;
    }

    public TextureAtlas getAtlasFnt() {
        return atlasFnt;
    }

    public TextureAtlas getAtlasWaterBar() {
        return atlasWaterBar;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }
}
















