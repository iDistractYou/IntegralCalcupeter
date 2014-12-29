package appstate;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.SpringLayout;

import main.AppScreen;

/** Description: This class contains the various states of the game. States are changed through this class.
 * @author Peter Huang
 * @version 1.0 December 28 2014
*/

public class AppStateManager {
	/** Holds the game states.
	   */
	  public ArrayList <AppState> appStates;
	  /** Holds the current state.
	   */
	  public int currentState;
	  /** Holds the pane of the game.
	   */
	  AppScreen pane;
	  
	  /** Holds the layout of the pane.
	   */
	  SpringLayout layout;
	  
	  /** Holds the value for splashstate.
	   */
	  public final int SPLASHSTATE = 0;
	  /** Holds the value for menustate.
	   */
	  public final int MENUSTATE = 1;
	  /** Holds the value for stageonestate.
	   */
	  public final int STAGEONESTATE = 2;
	  /** Holds the value for inputscorestate.
	   */
	  public final int INPUTSCORESTATE = 3;
	  /** Holds the value for difficultystate.
	   */
	  public final int DIFFICULTYSTATE = 4;
	  
	  /** Creates the gamestatemanager while sending in the game screen for the game and its layout.
	    * @param a AppScreen contains the screen of the game
	    * @param s SpringLayout contains the layout of the game
	   */
	  public AppStateManager(AppScreen a, SpringLayout s) { 
		  appStates = new ArrayList<AppState>();
	    this.pane = a;
	    this.layout = s;
	    appStates.add(new SplashState(this));
	    //appStates.add(new MenuState(this));
	    //appStates.add(new StageOneState(this));
	    //appStates.add(new InputScoreState(this));
	    //appStates.add(new DifficultyState(this));
	    setState(SPLASHSTATE);
	  }
	  
	  /** Changes the state of the game.
	    * @param state int takes in the state to be changed to
	   */
	  public void setState(int state) {
	    pane.removeAll();
	    currentState = state;
	    appStates.get(currentState).init();
	  }

	  /** Calls the states update method.
	   */
	  public void update() {
		  appStates.get(currentState).update();
	  }
	  
	  /** Calls the states draw method.
	   */
	  public void draw(java.awt.Graphics2D g) {
		  appStates.get(currentState).draw(g);
	  }
	  
	  /** Calls the states paintComponent method.
	   */
	  public void paintComponent(Graphics g) {
		  appStates.get(currentState).paintComponent(g);
	  }	
}
