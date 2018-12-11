package fall.jonathan.octocal.principal.principal.registering;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import fall.jonathan.octocal.R;
import fall.jonathan.octocal.databinding.ActivityRegisteringBinding;
import fall.jonathan.octocal.principal.principal.dashboard.DashboardView;

public class RegisView extends AppCompatActivity implements RegisUnderpinning.regViewStuff {

    private RegistrationPresenter myPres;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRegisteringBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_registering);
        myPres = new RegistrationPresenter(this);
        binding.setRegistrationPresenter(myPres);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void register() {

        EditText etEmail = findViewById(R.id.editTextEmail);
        EditText etPass = findViewById(R.id.editTextPassword);
        String email = etEmail.getText().toString().trim();
        String pass = etPass.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email required");
            etEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            etPass.setError("Password required");
            etPass.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_SHORT).show();
                            EditText etEmail = findViewById(R.id.editTextEmail);
                            String email = etEmail.getText().toString().trim();
                            startActivity(new Intent(getApplicationContext(), DashboardView.class).putExtra("Username", email));
                        }
                    }
                });
    }


}
