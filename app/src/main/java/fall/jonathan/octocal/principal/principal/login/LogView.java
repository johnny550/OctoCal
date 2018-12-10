package fall.jonathan.octocal.principal.principal.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityLoginBinding;
import fall.jonathan.octocal.principal.principal.dashboard.DashboardView;


public class LogView extends AppCompatActivity implements LogUnderpinningInterf.loginViewStuff {

    private LogPresenter myLogPres;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        ActivityLoginBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_login);
        myLogPres = new LogPresenter(this);
        binder.setLoginPresenter(myLogPres);

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void showScreen() {
        EditText username = findViewById(R.id.username);
        EditText pass = findViewById(R.id.pass);
        final String email = username.getText().toString().trim();
        String password = pass.getText().toString().trim();


        if (email.isEmpty()) {
            username.setError("Email required");
            username.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            username.setError("Please enter a valid email");
            username.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            pass.setError("Password required");
            pass.requestFocus();
            return;
        }


        Toast.makeText(this, "Signing you in!", Toast.LENGTH_SHORT).show();


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(getApplicationContext(), DashboardView.class).putExtra("Username", email));

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
}
