package fall.jonathan.octocal.principal.principal.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityLoginBinding;


public class LogView extends AppCompatActivity implements LogUnderpinningInterf.loginViewStuff{

    private LogPresenter myLogPres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        ActivityLoginBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_login);
        myLogPres = new LogPresenter(this);
        binder.setLoginPresenter(myLogPres);


    }


    @Override
    public void showScreen() {
        Toast.makeText(this,"Sign in please!",Toast.LENGTH_SHORT).show();
    }
}
