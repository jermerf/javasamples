/*
 * @author: Leanne
 */

package controller;

import model.IViewModel;
import model.IControllerModel;

public class GameApplication {
	
	static model.Model mModel;
	static view.View mView;
	static Controller mController;
	static KeyboardInput mKeyWatcher;
	
	public static void main(String[] args) {
		
		// create the model, view and controller classes
		// These things are in this order for a reason. DON'T CHANGE IT
		mModel = new model.Model();
		
		mKeyWatcher = new KeyboardInput();
		
		mView = new view.View( (IViewModel)mModel, mKeyWatcher);
		
		mController = new Controller( (IControllerModel)mModel, (view.IControllerView)mView, mKeyWatcher);
		
		mController.run();
	}
}
