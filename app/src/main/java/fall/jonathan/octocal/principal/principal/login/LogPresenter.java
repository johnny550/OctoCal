package fall.jonathan.octocal.principal.principal.login;


import android.view.View;

public class LogPresenter implements LogUnderpinningInterf.loginPresenterStuff {

    private LogUnderpinningInterf.loginViewStuff myView;

    LogPresenter(LogUnderpinningInterf.loginViewStuff view) {
        myView = view;
    }

    @Override
    public void signIn(View aView) {
        myView.showScreen();
    }
}
