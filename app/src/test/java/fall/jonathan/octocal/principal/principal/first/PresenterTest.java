package fall.jonathan.octocal.principal.principal.first;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/*
 * presenter dedicated local unit tests
 */
public class PresenterTest {

    @Mock
    private UnderinningInterf.viewStuff mockedView;

    private Presenter myPresenter;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        myPresenter=new Presenter(mockedView);

    }
    @Test
    public void signInOnTheGo() {
        myPresenter.signInOnTheGo();
        verify(mockedView).signInScreen();
    }

    @Test
    public void signUpOnTheGo() {
        myPresenter.signUpOnTheGo();
        verify(mockedView).signUpScreen();
    }
}