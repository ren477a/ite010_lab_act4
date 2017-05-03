package cs33fc1.ite010.tipqc.com.labactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText user, pass;
    private Button btnLogin;
    private final String USERNAME = "admin";
    private final String PASSWORD = "ITE010";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().toLowerCase().equals(USERNAME)
                        && pass.getText().toString().equals(PASSWORD)) {
                    System.out.println("Login Successful");
                    launchPA1();
                }
            }
        });
    }

    public void launchPA1() {
        Intent intent = new Intent(this, PersonalInfoActivity1.class);
        startActivity(intent);
    }
}
