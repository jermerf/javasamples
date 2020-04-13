package view;
import model.CowEnemy;
import model.IViewModel;
import model.GameState;

public class View implements IControllerView {
	private IViewModel modelInterface;
	private GameState state; 
	private ScreenPainter screenPainter;
	private AnimBackground background = new AnimBackground();
	private AnimHUD hud;
	private AnimTitle title;
	
	public View(IViewModel modelInterface, controller.KeyboardInput keyWatcher){
		this.modelInterface = modelInterface;
		screenPainter = new ScreenPainter(keyWatcher);
		state = null;
		hud = new AnimHUD();
		//Images are loaded on first instantiation.
		//Making them when the View is made prevents in game slow-down.
		@SuppressWarnings( "unused" )
		Animated tmpLoader = new AnimEnemyObject(new CowEnemy(0,0,null));
		tmpLoader = new AnimExplosion();
		tmpLoader = new AnimPlayerBullet(null,0);
		tmpLoader = new AnimPowerup(null,0);
		title = new AnimTitle();
	}
	
	public void repaint() {
		//There are separate Image lists for the TITLE as opposed to all other states
		//So check to see if something is changing to or from TITLE
		//**This might change if other states get different image lists
		if(modelInterface.getState()!=state){
			if(modelInterface.getState()==GameState.TITLE){	//if the new state is title, load the title image
				Animations.clear();
			}
			state = modelInterface.getState();
		}
		if(state==GameState.TITLE){
			screenPainter.addSprite(title);
			screenPainter.repaint();
			return;
		}
		makeSprites();
		switch(state){
		case GAMEPLAY:
			break;
		case PAUSE:
//			screenPainter.addSprite(ImageLoader.getImage(2), 
//					(Config.cFrameWidth-ImageLoader.getImage(2).getWidth())/2, 
//					(Config.cFrameHeight-ImageLoader.getImage(2).getHeight())/2);
			
			break;
		case LOSE_1_LIFE:
//			screenPainter.addSprite(ImageLoader.getImage(3), 
//					(Config.cFrameWidth-ImageLoader.getImage(3).getWidth())/2, 
//					(Config.cFrameHeight-ImageLoader.getImage(3).getHeight())/2);
			break;
		case LEVEL_COMPLETE:
//			screenPainter.addSprite(ImageLoader.getImage(4), 
//					(Config.cFrameWidth-ImageLoader.getImage(4).getWidth())/2, 
//					(Config.cFrameHeight-ImageLoader.getImage(4).getHeight())/2);
			break;
			
		}
		screenPainter.addSprite(hud);
		screenPainter.repaint();
	}
	
	private void makeSprites() {
		screenPainter.addSprite(background.getNextFrame(),0,0);
		int animCount =Animations.getCount(); //Do not FUCKING delete this int!!
		for(int i=0; i<animCount;i++){
			Animated tmp = Animations.getAnimated(i);
			screenPainter.addSprite(tmp.getNextFrame(),tmp.getX(),tmp.getY());
		}
	}
	
}
