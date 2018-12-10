package fall.jonathan.octocal.principal.principal.login;

import android.view.View;

public interface LogUnderpinningInterf {
    interface loginViewStuff {
        void showScreen();
    }

    interface loginPresenterStuff {
        void signIn(View aView);
    }
}
