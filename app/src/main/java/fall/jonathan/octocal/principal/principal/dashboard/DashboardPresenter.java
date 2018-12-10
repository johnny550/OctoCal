package fall.jonathan.octocal.principal.principal.dashboard;

import android.view.View;

public class DashboardPresenter implements DashUnderpinningInterf.dashPresenterStuff {
    private DashUnderpinningInterf.dashViewStuff myView;

    DashboardPresenter(DashUnderpinningInterf.dashViewStuff view){ myView = view;}


    @Override
    public void onFilling(View aView) {
         myView.fillSpace();
    }

    @Override
    public void onGetData(View aView) {
        myView.getData();
    }

    @Override
    public void onLogout(View aView) {
        myView.logout();
    }
}
