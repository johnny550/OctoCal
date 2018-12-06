package fall.jonathan.octocal.principal.principal.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fall.jonathan.octocal.R;

/*
* Main screen displayer
 */

public class MainActivity extends AppCompatActivity implements UnderinningInterf.viewStuff {

    private Presenter myPres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPres = new Presenter(this);
    }
}
