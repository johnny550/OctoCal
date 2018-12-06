package fall.jonathan.octocal.principal.principal.first;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityMainBinding;

/*
 * Main screen displayer
 */

public class MainActivity extends AppCompatActivity implements UnderinningInterf.viewStuff {

    private Presenter myPres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // setContentView(R.layout.activity_main);
        ActivityMainBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myPres = new Presenter(this);
        bind.setPresenter(myPres);
    }


    //View methods
    @Override
    public void signInScreen() {
        Toast.makeText(this, "Taking you to the sign in page", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpScreen() {
        Toast.makeText(this, "Taking you to the sign up page", Toast.LENGTH_SHORT).show();
    }
}
