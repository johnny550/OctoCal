package fall.jonathan.octocal.principal.principal.login;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fall.jonathan.octocal.principal.principal.first.Presenter;
import fall.jonathan.octocal.principal.principal.first.UnderinningInterf;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class LogPresenterTest {

    @Mock
    private LogUnderpinningInterf.loginViewStuff mockedView;

    private View myView;
    private LogPresenter presenter;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        presenter = new LogPresenter(mockedView);
    }
    @Test
    public void signIn() {
        presenter.signIn(myView);
        verify(mockedView).showScreen();
    }
}