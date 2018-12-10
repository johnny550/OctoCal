package fall.jonathan.octocal.principal.principal.registering;

import android.view.View;

public class RegistrationPresenter implements RegisUnderpinning.regPresenterStuff {
    private RegisUnderpinning.regViewStuff myView;

    RegistrationPresenter(RegisUnderpinning.regViewStuff view) {
        myView = view;
    }

    @Override
    public void onRegister(View aView) {
        myView.register();
    }
}
