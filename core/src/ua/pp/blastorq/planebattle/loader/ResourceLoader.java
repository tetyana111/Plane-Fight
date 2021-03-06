package ua.pp.blastorq.planebattle.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import ua.pp.blastorq.planebattle.objects.MovingBackground;
import ua.pp.blastorq.planebattle.objects.MovHandler;
import ua.pp.blastorq.planebattle.sprite.Bullets;
import ua.pp.blastorq.planebattle.sprite.Plane;


public class ResourceLoader {
    private static Texture background;
    private static Texture Bullet;

    public static Music menu;
    public static OrthographicCamera camera = new OrthographicCamera();
    public static Plane player;
    public static Plane bot;
    public static SpriteBatch batch;
    public static Stage stage;
    public static Bullets bullets;
    public static Vector3 touchPos;

    public static MovingBackground getFrontMovingBackground() {
        return frontMovingBackground;
    }
    public static Texture getBackground() {
        return background;
    }
    private static MovingBackground frontMovingBackground;

    public static Texture getBullet(){ return Bullet;}
    public void load(){
        MovHandler movHandler = new MovHandler(0, -100);
        frontMovingBackground = movHandler.getFrontMovingBackground();
        background = new Texture("bg.png");
        Texture playerShip = new Texture("Plane.png");
        Texture playerShip1 = new Texture("Plane.png");
        menu = Gdx.audio.newMusic(Gdx.files.internal("MenuMusic.ogg"));
        menu.setLooping(true);
        touchPos = new Vector3();
        Bullet  = new Texture("bullet.png");
        batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));

        player = new Plane(playerShip, false);
        player.flip(false, true);
        Gdx.input.setInputProcessor(stage);
        bot = new Plane(playerShip1, true);
        bullets = new Bullets();
    }
}
