import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.fraphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class HelloWorldImage extends Game
{
    private Texture Texture;
    private SpriteBatch batch;
    public void create(){
        FileHandle worldFile = Gdx.Files.internal("world.png");
        texture = new Texture(worldFile);
        batch = new SpriteBatch();
    }
    public void render(){
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClearColor(Gl.20.GL_COLOR_BUFFER_BIT);
        batch begin();
        batch.draw( texture, 192, 112);
        batch.end();
    }
}
import com.badlogic.gdx.backends.lwgl.lwjglApplication;
public class HelloLauncher
{
    public static void main (String[]args){
        HelloWorldImage myProgram = new HelloWorldImage();
        lwjglApplication launcher = new lwjglApplication( my program );
    }
}