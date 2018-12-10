package fall.jonathan.octocal.principal.principal.registering;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class RegistrationPresenterTest {
    @Mock
    private RegisUnderpinning.regViewStuff mockedView;

    private View myView;
    private RegistrationPresenter presenter;


    @Test
    public void onRegister() {
        presenter.onRegister(myView);
        verify(mockedView).register();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new RegistrationPresenter(mockedView);
    }

}