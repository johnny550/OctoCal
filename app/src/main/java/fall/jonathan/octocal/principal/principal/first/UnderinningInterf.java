package fall.jonathan.octocal.principal.principal.first;

/*
 * defines abstract functions between view (main activity & layout) and presenter
 */
public interface UnderinningInterf {
    interface viewStuff{
        void signInScreen();
        void signUpScreen();

    }
    interface presenterStuff{
        void signInOnTheGo();
        void signUpOnTheGo();
    }
}
