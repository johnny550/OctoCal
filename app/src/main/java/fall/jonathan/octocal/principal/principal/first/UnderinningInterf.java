package fall.jonathan.octocal.principal.principal.first;

import android.view.View;

/*
 * defines abstract functions between view (main activity & layout) and presenter
 */
public interface UnderinningInterf {
    interface viewStuff {
        void signInScreen();

        void signUpScreen();

    }

    interface presenterStuff {
        void signInOnTheGo(View aView);

        void signUpOnTheGo(View aView);
    }
}
