
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class Mario extends ApplicationAdapter{
    private Music marioMusic;
    private SpriteBatch batch;
    private Personagem warrior;
    private Texture plataforma;
    private Texture turtleTex;
    private BitmapFont font;
    private OrthographicCamera camera;
    private Array<Obstaculos> obstaculos;
    private Array<Turtle> turtles;
    private int contadorObstaculos = 0;
    private Texture person;
    private Texture person_left;
	private float stateTime;
    private Texture person_stop;
	private long lastDropTime;
	private int contGlobal;
    private Texture BolaFogo;
    private Array<Bola>SpawnBola;
    private int pontos = 0;
    private int Time_Spawn_Turtle = 400;
    private int conta_bola = 0;
    private Sound impacto;
   
    
    @Override 
    public void create(){
        
        //pega o sprite animado
        person = new Texture(Gdx.files.internal("Mario.png"));
        // quebro o sprite animado em varios sprites
        person_left = new Texture(Gdx.files.internal("Mario_left.png"));
        person_stop = new Texture(Gdx.files.internal("Mario_stop.png"));
        plataforma = new Texture(Gdx.files.internal("assets/plataforma_aux.png"));
        turtleTex = new Texture(Gdx.files.internal("assets/turtle.png"));
        BolaFogo = new Texture(Gdx.files.internal("assets/BoladeFogo.png"));
        impacto = Gdx.audio.newSound(Gdx.files.internal("assets/Tome.mp3"));
        marioMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/MarioMusic.mp3"));
        ;

        
        marioMusic.setLooping(true);
        marioMusic.play();
        
        camera = new OrthographicCamera();

		camera.setToOrtho(false, 600, 480);

        batch = new SpriteBatch();
        font = new BitmapFont();
		font.setColor(Color.YELLOW);

        turtles = new Array<Turtle>();
        spawnPersonagem();
        spawnTurtle();

        obstaculos = new Array<Obstaculos>();
        spawnObstaculos();
        stateTime = 0f;

        SpawnBola = new Array<Bola>();
        SpawnBolaFogo(400);

    }
    private void spawnTurtle(){
        Turtle tur;
        Rectangle rectangle = new Rectangle();
        rectangle.x = 0;
        rectangle.y = 395;
        rectangle.width = 35;
        rectangle.height = 35;
        tur = new Turtle(rectangle, turtleTex, turtleTex);
        turtles.add(tur);
		lastDropTime = TimeUtils.nanoTime();
    }

    private void spawnPersonagem(){
        Rectangle rectangle = new Rectangle();
        rectangle.x = 300;
        rectangle.y = 10;
        rectangle.width = 50;
        rectangle.height = 50;
        warrior = new Personagem(rectangle, person, person_left);
    }
    private void SpawnBolaFogo(float y){
        Rectangle rectangle = new Rectangle();
        rectangle.x = 500;
        rectangle.y = y;
        rectangle.width = 40;
        rectangle.height = 40;
        Bola movelbola = new Bola(rectangle, BolaFogo);
        SpawnBola.add(movelbola);
    }

    private  void spawnObstaculos(){
        Obstaculos ob;
        Rectangle rectangle = new Rectangle();
        
        switch(contadorObstaculos){
            case 0:
                rectangle.x = 0;
                rectangle.y = 0;
                rectangle.width = 600;
                rectangle.height = 10;
            break;
            case 1:
                rectangle.x = 0;
                rectangle.y = 125;
                rectangle.width = 200;
                rectangle.height = 10;
            break;
            case 2:
                rectangle.x = 600-200;
                rectangle.y = 125;
                rectangle.width = 200;
                rectangle.height = 10;
            break;
            case 3:
                rectangle.x = 0;
                rectangle.y = 250;
                rectangle.width = 75;
                rectangle.height = 10;
            break;
            case 4:
                rectangle.x = 600-75;
                rectangle.y = 250;
                rectangle.width = 75;
                rectangle.height = 10;
            break;
            case 5:
                rectangle.x = 237-50;
                rectangle.y = 250;
                rectangle.width = 250;
                rectangle.height = 10;
            break;
            case 6:
                rectangle.x = 0;
                rectangle.y = 375;
                rectangle.width = 250;
                rectangle.height = 10;
            break;
            case 7:
                rectangle.x = 600-250;
                rectangle.y = 375;
                rectangle.width = 250;
                rectangle.height = 10;
            break;
        }
        
        ob = new Obstaculos(plataforma, rectangle);
        obstaculos.add(ob);
        contadorObstaculos++;
        
    }
    @Override
    public void render(){
        
        
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        
	    
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(warrior.getTecla() == 0 ){
            batch.draw(person_stop, warrior.getmRectangle().x, warrior.getmRectangle().y, warrior.getmRectangle().width,warrior.getmRectangle().height);
        }else if(warrior.getTecla() == 1){
            TextureRegion person = warrior.getAnimationRight().getKeyFrame(stateTime, true);
            batch.draw(person, warrior.getmRectangle().x, warrior.getmRectangle().y, warrior.getmRectangle().width,warrior.getmRectangle().height);
        }else{
            TextureRegion person = warrior.getAnimationLeft().getKeyFrame(stateTime, true);
            batch.draw(person, warrior.getmRectangle().x, warrior.getmRectangle().y, warrior.getmRectangle().width,warrior.getmRectangle().height);
        }
       

        if (TimeUtils.nanoTime() - lastDropTime > 1000000000){
            contGlobal++;
            
            if(contGlobal%Time_Spawn_Turtle == 0){
                if(pontos > 100){
                    Time_Spawn_Turtle = 200;
                }else{
                    Time_Spawn_Turtle = 400;
                }
                spawnTurtle();
                contGlobal = 0;
            }
        
            
        }

        for(Turtle turtle : turtles){
            batch.draw(turtle.getmImage(), turtle.getmRectangle().x, turtle.getmRectangle().y, turtle.getmRectangle().width, turtle.getmRectangle().height);
        }
        for(Bola bo : SpawnBola){
            batch.draw(bo.getmImage(), bo.getmRectangle().x, bo.getmRectangle().y, bo.getmRectangle().width, bo.getmRectangle().height);
        }
        
        if(contadorObstaculos < 8){
            spawnObstaculos();
        }
        for(Obstaculos ob : obstaculos){
            batch.draw(ob.getObImage(),ob.getObRectangle().x, ob.getObRectangle().y,ob.getObRectangle().width,ob.getObRectangle().height);
        }
        font.draw(batch, "pontos: "+pontos, 280, 450);
        batch.end();

        warrior.handleEvent(camera);
        warrior.getmRectangle().y += warrior.getGravidade();

        for(Obstaculos ob : obstaculos){
            if(warrior.getmRectangle().overlaps(ob.getObRectangle())){
                if(warrior.getmRectangle().y > (ob.getObRectangle().y + (ob.getObRectangle().height / 2))){
                    warrior.getmRectangle().y += (ob.getObRectangle().y + ob.getObRectangle().height ) - warrior.
                    getmRectangle().y;
                    warrior.setVelocidadeY(100);
                    warrior.setPulo(true);
                    
                }else{
                    Iterator<Turtle> iter_turtle = turtles.iterator();
                    while (iter_turtle.hasNext()){
                        Turtle turtle = iter_turtle.next();
                        if(turtle.getmRectangle().x - warrior.getmRectangle().x < 20 && turtle.getmRectangle().x - warrior.getmRectangle().x >= 0 ){
                           
                            
                            if(turtle.getmRectangle().y - warrior.getmRectangle().y < 60 && turtle.getmRectangle().y - warrior.getmRectangle().y > 1){

                                iter_turtle.remove();
                                impacto.play();
                                pontos+=10;
                            }
                        }
                    }
                    warrior.setGravidade(-2);
                    
                }
            }

            for(Turtle turtle : turtles){

                if(turtle.getmRectangle().overlaps(ob.getObRectangle())){
    
                    if(turtle.getmRectangle().y > (ob.getObRectangle().y + (ob.getObRectangle().height / 2))){
                        turtle.getmRectangle().y += (ob.getObRectangle().y + ob.getObRectangle().height ) - turtle.
                        getmRectangle().y;
                        turtle.setVelocidadeY(100);
                        turtle.setPulo(true);
                    }else{
                        turtle.setGravidade(-2);
                        
                    }
                    Integer var= (Integer)MathUtils.random(0, 2);
                    if(var == 0){
                        if((int)turtle.getmRectangle().x == ob.getObRectangle().width-7){
                            if(!(turtle.getVelocidadeX() < 0) && !(turtle.getmRectangle().x > 500)){
                                turtle.setVelocidadeX(turtle.getVelocidadeX() * -1);
                            }
                        }
                        
                    }
                }


            }
        }

        if(warrior.getmRectangle().y < 10){
            warrior.getmRectangle().y = 10;
        }
        
        
        
        for(Turtle turtle : turtles){
            turtle.handleEvent(camera);
            turtle.getmRectangle().y += turtle.getGravidade();
           
        }


        if(warrior.getmRectangle().y < 10){
            warrior.getmRectangle().y = 10;
        }
        
        
        

		Iterator<Turtle> iter_turtle = turtles.iterator();

        while (iter_turtle.hasNext()){
            Turtle turtle = iter_turtle.next();
            if(contadorObstaculos == 8){
                if(turtle.getmRectangle().overlaps(obstaculos.first().getObRectangle())){
                    if(turtle.getmRectangle().x > obstaculos.get(0).getObRectangle().width - 5  ){
                        
                        iter_turtle.remove();
                        
                    }else if(turtle.getmRectangle().x < obstaculos.get(0).getObRectangle().x + 10){
                        
                        iter_turtle.remove();
                        
                    }else{
                        turtle.setGravidade(-2);

                    }
                }

            }
            if(turtle.getmRectangle().overlaps(warrior.getmRectangle())){
                pontos = pontos - 20;
                if(pontos < 0){
                    pontos = 0;
                    
                }
            }
        }
        


        Iterator<Bola> iter_Bola = SpawnBola.iterator();
		while (iter_Bola.hasNext()) {
			Movel rectangle = iter_Bola.next();
			rectangle.move();
			if (rectangle.getmRectangle().y + 64 < 0)
                iter_Bola.remove();
			if (rectangle.getmRectangle().overlaps(warrior. getmRectangle())) {
				pontos = 0;
			}
		}
        if(pontos >= 100 && conta_bola ==0){
            SpawnBolaFogo(40);
            conta_bola++;

        }
    }
    @Override
    public void dispose(){
        plataforma.dispose();
        font.dispose();
        batch.dispose();
        impacto.dispose();
    }

    
}

class Obstaculos{
    protected Texture obImage;
    protected Rectangle obRectangle;

    public Obstaculos(Texture obImage, Rectangle obRectangle){
        this.obRectangle = obRectangle;
        this.obImage = obImage;
    }

    public Texture getObImage() {
        return obImage;
    }

    public void setObImage(Texture obImage) {
        this.obImage = obImage;
    }

   
    public Rectangle getObRectangle() {
        return obRectangle;
    }

    public void setObRectangle(Rectangle obRectangle) {
        this.obRectangle = obRectangle;
    }

}

abstract class Movel {

	protected Texture mImage_right;
    protected Texture mImage_left;
	protected Rectangle mRectangle;
    Animation<TextureRegion> walkAnimation_right;
    Animation<TextureRegion> walkAnimation_left;  
    int FRAME_COLS = 5, FRAME_ROWS = 1;
    private TextureRegion[] walkFrames_right;
    private TextureRegion[] walkFrames_left;
	

	public Movel(Rectangle rectangle, Texture texture, Texture texture_left) {
		mRectangle = rectangle;
		mImage_right = texture;
        mImage_left = texture_left;

        TextureRegion[][] tmp_right = TextureRegion.split(mImage_right,
            mImage_right.getWidth() / FRAME_COLS,
            mImage_right.getHeight() / FRAME_ROWS);
        //array que recebera todos os sprites dqa matriz tmp
        walkFrames_right = new TextureRegion[5 * FRAME_ROWS];

        // duplo for para pegar os sprites
        int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames_right[index++] = tmp_right[i][j];
			}
		}

        walkAnimation_right = new Animation<TextureRegion>(0.075f, walkFrames_right);

        TextureRegion[][] tmp_left = TextureRegion.split(mImage_left,
            mImage_left.getWidth() / FRAME_COLS,
            mImage_left.getHeight() / FRAME_ROWS);
        //array que recebera todos os sprites dqa matriz tmp
        walkFrames_left = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        // duplo for para pegar os sprites
        index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = FRAME_COLS-1; j >= 0; j--) {
				walkFrames_left[index++] = tmp_left[i][j];
			}
		}

        walkAnimation_left = new Animation<TextureRegion>(0.075f, walkFrames_left);
		
	}

	public abstract void move();

	public abstract void handleEvent(OrthographicCamera camera);

	public Texture getmImage() {
		return mImage_right;
	}

	public void setmImage(Texture mImage) {
		this.mImage_right = mImage;
	}

	public Rectangle getmRectangle() {
		return mRectangle;
	}

	public void setmRectangle(Rectangle mRectangle) {
		this.mRectangle = mRectangle;
	}

    public Animation<TextureRegion> getAnimationRight(){
        return walkAnimation_right;
    }
    public Animation<TextureRegion> getAnimationLeft(){
        return walkAnimation_left;
    }

}
class Turtle extends Movel{

    private int gravidade = -2;
    private int velocidadeX = 40;
    private int velocidadeY = 40;
    private boolean pulo = false;
    private int tempo = 0;

    public Turtle(Rectangle rectangle, Texture texture, Texture texture_left) {
        super(rectangle, texture, texture_left);
    }

    public void setVelocidadeX(int velocidadeX){
        this.velocidadeX = velocidadeX;
    }

    public int getVelocidadeX(){
        return this.velocidadeX;
    }
    public void setVelocidadeY(int velocidadeY){
        this.velocidadeY = velocidadeY;
    }

    public void setPulo(boolean pulo){
        this.pulo = pulo;
    }

    public int getVelocidade(){
        return this.velocidadeY;
    }

    public void setGravidade(int gravidade){
        this.gravidade = gravidade;
    }

    public int getGravidade(){
        return gravidade;
    }

    @Override
    public void move() {
    }

    @Override
    public void handleEvent(OrthographicCamera camera) {

        mRectangle.x += velocidadeX * Gdx.graphics.getDeltaTime();

		if (mRectangle.x < 0)
            if(this.getVelocidadeX() < 0)
                mRectangle.x = 540;
		if (mRectangle.x > 600 ){
                mRectangle.x = -20;
        }
        tempo++;
        if(tempo % 200 == 0 && pulo == false){
            gravidade = -2;
        }
    }
    
}

class Personagem extends Movel{

    private int tecla = 0;
    private int gravidade = -2;
    private int velocidadeX = 100;
    private int velocidadeY = 100;
    private boolean pulo = true;
    private float time = 0f;


    public Personagem(Rectangle rectangle, Texture texture, Texture texture_left){
        super(rectangle, texture, texture_left);
        
    }

    public void setVelocidadeX(int velocidadeX){
        this.velocidadeX = velocidadeX;
    }

    public int getVelocidadeX(){
        return this.velocidadeX;
    }
    public void setVelocidadeY(int velocidadeY){
        this.velocidadeY = velocidadeY;
    }

    public void setPulo(boolean pulo){
        this.pulo = pulo;
    }

    public int getVelocidade(){
        return this.velocidadeY;
    }

    public void setGravidade(int gravidade){
        this.gravidade = gravidade;
    }

    public int getGravidade(){
        return gravidade;
    }

    public int getTecla(){
        return tecla;
    }

    public void setTecla(int tecla){
        this.tecla = tecla;
    }

    @Override
    public void move() {
    }

    @Override
    public void handleEvent(OrthographicCamera camera) {
		if (Gdx.input.isKeyPressed(Keys.LEFT)){
            mRectangle.x -= velocidadeX * Gdx.graphics.getDeltaTime()
            ;
            tecla = -1;
            
        }else{
            tecla = 0;
        }
			
		if (Gdx.input.isKeyPressed(Keys.RIGHT)){
            mRectangle.x += velocidadeX * Gdx.graphics.getDeltaTime();
            tecla = 1;
           
        }else if(tecla != -1){
            tecla = 0;
        }
			
        if(Gdx.input.isKeyJustPressed(Keys.UP)){
            if(pulo){
                gravidade = 3;
            }
            pulo = false;
            time = TimeUtils.nanoTime();
           
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)){
            mRectangle.y -= velocidadeY * Gdx.graphics.getDeltaTime();
        }

		if (mRectangle.x < -20)
			mRectangle.x = 600-50;
		if (mRectangle.x > 600 - 50)
			mRectangle.x = -20;
        if(mRectangle.y > 480-50){
            mRectangle.y = 480-50;
            gravidade = -2;
        }
        
        
        if((TimeUtils.nanoTime()) - time  > 1000000000*0.8 && pulo  == false){
            
            gravidade = -2;
        }
        
    } 
}

class Bola extends Movel{
    private int dificuldade;
    private int velocidadeX = 100;
    private int velocidadeY = 100;

    public Bola(Rectangle rectangle, Texture texture){
        super(rectangle, texture, texture);
    }

    public void setVelocidadeX(int velocidadeX){
        this.velocidadeX = velocidadeX;
    }

    public int getVelocidadeX(){
        return this.velocidadeX;
    }
    public void setVelocidadeY(int velocidadeY){
        this.velocidadeY = velocidadeY;
    }

    public int getVelocidade(){
        return this.velocidadeY;
    }

    @Override
    public void move() {
        getmRectangle().x += (100 + dificuldade) * Gdx.graphics.getDeltaTime();
        if (mRectangle.x < -20){
            mRectangle.x = 600-50;
        }
		if (mRectangle.x > 600 - 50){
            mRectangle.x = -20;
            switch((int)mRectangle.y){
                case 400:
                    mRectangle.y = 280;
                break;
                case 280:
                    mRectangle.y = 150;
                break;
                case 150:
                    mRectangle.y = 40;
                break;
                case 40:
                    mRectangle.y = 400;
                    dificuldade = dificuldade + 10;
                break;
            }
        }	
    }

    @Override
    public void handleEvent(OrthographicCamera camera) {
        
    }
    
}

