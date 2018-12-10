package fall.jonathan.octocal.principal.principal.dashboard;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class DashboardPresenterTest {

    @Mock
    private DashUnderpinningInterf.dashViewStuff mockedView;

    private View myView;
    private DashboardPresenter presenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new DashboardPresenter(mockedView);
    }

    @Test
    public void onFilling() {
        presenter.onFilling(myView);
        verify(mockedView).fillSpace();
    }

    @Test
    public void onGetData() {
        presenter.onGetData(myView);
        verify(mockedView).getData();
    }

    @Test
    public void onLogout() {
        presenter.onLogout(myView);
        verify(mockedView).logout();
    }
}