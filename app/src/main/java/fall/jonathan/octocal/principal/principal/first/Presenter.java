package fall.jonathan.octocal.principal.principal.first;

/*
 * handles view originated actions & updates UI based on user actions
 */

public class Presenter implements UnderinningInterf.presenterStuff {

    private UnderinningInterf.viewStuff myView;

    Presenter(UnderinningInterf.viewStuff view) {
        myView = view;
    }


    // Presenter methods
    @Override
    public void signInOnTheGo() {
        myView.signInScreen();
    }

    @Override
    public void signUpOnTheGo() {
        myView.signUpScreen();
    }
}
