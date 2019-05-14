package awesome.flappy.util;

/**
 * 资源常量
 *
 * @author Ziru Wang
 */
public interface Resource {

    /**
     * 固定世界宽度为 480, 高度根据实际屏幕比例换算
     */
    public static final float FIX_WORLD_WIDTH = 480;

    /**
     * 相关物理参数（调节物理参数可改变游戏难度）
     */
    public static class Physics {

        /**
         * 水管和地板的移动速度, 单位: px/s
         */
        //public static final float MOVE_VELOCITY = -270.0F; 快
        public static float MOVE_VELOCITY = -230.0F;

        /**
         * 点击屏幕时给小鸟的竖直方向上的速度, 单位: px/s
         */
        public static final float JUMP_VELOCITY = 260.0F;

        /**
         * 小鸟竖直方向上的重力加速度, 单位: px/(s*s)
         */
        public static final float GRAVITY = -420.0F;

        /**
         * 撞入深度, 小鸟撞入水管或地板该深度后才算碰撞
         */
        public static final float DEPTH = 0.05F;

        /**
         * 生成水管时间间隔, 单位: s
         */
        public static float GENERATE_BAR_TIME_INTERVAL = 2.1F;

        /**
         * 上下水管之间的间隔
         */
        public static final float BAR_INTERVAL = 180.0F;
    }

    /**
     * 纹理图集
     */
    public static interface Atlas {

        /**
         * 纹理图集 文件路径
         */
        public static final String ATLAS_PATH_WATER_BAR = "atlas/waterbar.atlas";
        public static final String ATLAS_PATH_WANG = "atlas/wang.atlas";

        /**
         * 纹理图集中的小图名称
         */
        public static final String IMAGE_GAME_BG = "bg";
        public static final String IMAGE_GAME_FLOOR = "floor";
        public static final String IMAGE_GAME_RESULT_BG = "result";
        public static final String IMAGE_BAR_DOWN = "bar_down";
        public static final String IMAGE_BAR_UP = "bar_up";
        public static final String IMAGE_GAME_TAP_TIP = "game_tap_tip";
        public static final String IMAGE_GAME_TITLE = "game_title";
        public static final String IMAGE_GAME_OVER = "game_over";

        public static final String IMAGE_GAME_START_01_TO_02 = "btn";
        public static final String IMAGE_GAME_MEDAL_01_TO_08 = "shit";

        public static final String IMAGE_WANG_01_TO_04 = "wang";

        public static final String ATLAS_PATH_FNT = "atlas/flappyNumber.atlas";

        public static final String IMAGE_NUM_BIG_00_TO_09 = "num_big";
        public static final String IMAGE_NUM_SCORE_00_TO_09 = "num_score";

        public static final String IMAGE_MY_AVATOR = "my_avator";

    }

    /**
     * 音效
     */
    public static interface Audios {

        /**
         * 音效资源文件夹路径
         */
        public static final String AUDIO_BASE_DIR = "audio/";

        public static final String AUDIO_DIE = AUDIO_BASE_DIR + "die.ogg";
        public static final String AUDIO_HIT = AUDIO_BASE_DIR + "pa!.wav";
        public static final String AUDIO_TOUCH = AUDIO_BASE_DIR + "touch.ogg";
        public static final String AUDIO_RESTART = AUDIO_BASE_DIR + "restart.wav";

        public static final String AUDIO_SCORE = AUDIO_BASE_DIR + "吐痰.wav";

        public static final String AUDIO_READY = AUDIO_BASE_DIR + "吐痰.wav";
        public static final String AUDIO_START_MUSIC = AUDIO_BASE_DIR + "start_music.ogg";
        public static final String AUDIO_FURY = AUDIO_BASE_DIR + "fury.mp3";

    }

    /**
     * Preferences 本地存储相关
     */
    public static interface Prefs {

        public static final String PREFS_FILE_NAME = "prefs_flappy_bird";

        public static final String KEY_BEST_SCORE = "best_score";
    }

}




















