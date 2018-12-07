package fall.jonathan.octocal.principal.principal.first;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityMainBinding;
import fall.jonathan.octocal.principal.principal.login.LogView;

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
        startActivity(new Intent(this, LogView.class));
        finish();
    }

    @Override
    public void signUpScreen() {
        Toast.makeText(this, "Taking you to the sign up page", Toast.LENGTH_SHORT).show();
    }
}
