package mrzcom.example.simple_login.ruiyang;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mrzcom.example.simple_login.R;
import mrzcom.example.simple_login.ruiyang.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAccount;
    private EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAccount = findViewById(R.id.editTextAccount);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("123".equals(editTextAccount.getText().toString()) && "123".equals(editTextPassword.getText().toString())) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        });

        // Assuming you want the SignUp button to just clear the fields for now
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextAccount.setText("");
                editTextPassword.setText("");
            }
        });
    }
}
