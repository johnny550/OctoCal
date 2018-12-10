package fall.jonathan.octocal.principal.principal.dashboard;

import android.view.View;

public interface DashUnderpinningInterf {
    interface dashViewStuff{
        void fillSpace();
        void getData();
        void logout();
    }
    interface dashPresenterStuff{
        void onFilling(View aView);
        void onGetData(View aView);
        void onLogout(View aView);
    }
}
