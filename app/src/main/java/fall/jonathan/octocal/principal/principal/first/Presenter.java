package fall.jonathan.octocal.principal.principal.first;

/*
 * handles view originated actions & updates UI based on user actions
 */

import android.view.View;

public class Presenter implements UnderinningInterf.presenterStuff {

    private UnderinningInterf.viewStuff myView;

    Presenter(UnderinningInterf.viewStuff view) {
        myView = view;
    }


    // Presenter methods
    @Override
    public void signInOnTheGo(View aView) {
        myView.signInScreen();
    }

    @Override
    public void signUpOnTheGo(View aView) {
        myView.signUpScreen();
    }
}
