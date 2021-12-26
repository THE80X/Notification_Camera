package com.example.notification_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String pasword_1;
    public static String pasword_2;
    public static String nickname_1;
    public static String nickname_2;
    public static int i = 0;
    public static int j = 0;
    public static int k = 0;
    public static Boolean check_thing;
    Button buttonnext;
    Button buttonautorize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonnext = findViewById(R.id.button_next_Registration);
        buttonautorize = findViewById(R.id.button_autorization_Registrtion);


    }
    public void OnClickCamera(View view) {
        EditText editTextPassword1 = (EditText) findViewById(R.id.Password_Registration);
        pasword_1 = editTextPassword1.getText().toString();
        EditText editTextPassword2 = (EditText) findViewById(R.id.Password_Registration_Check);
        pasword_2 = editTextPassword2.getText().toString();
        EditText editTextNickname1 = (EditText) findViewById(R.id.Name_Registration);
        nickname_1 = editTextNickname1.getText().toString();
        if (!nickname_1.isEmpty()) {
            if ((pasword_1.isEmpty()) && (pasword_2.isEmpty())) {
                findViewById(R.id.Result_1).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.Result_1)).setText("Вы не ввели пароль");
            }

            if (!(pasword_1.isEmpty()) && (pasword_1.equals(pasword_2)))
            {
                check_thing = true;
                for (j = 0; j < 15; j++)
                {
                    if (nickname_1.equals(Archivator.PersonName[j]))
                    {
                        findViewById(R.id.Result_1).setVisibility(View.VISIBLE);
                        ((TextView) findViewById(R.id.Result_1)).setText("Данный Логин уже занят");
                        check_thing = false;
                    }
                }

                if (check_thing)
                {
                    for(i=0; i<15; i++)
                    { nickname_2=Archivator.PersonName[i];

                        if (nickname_2.isEmpty() && k==0)
                        {
                            Archivator.PersonName[i] = nickname_1;
                            Archivator.Personpassword[i] = pasword_1;
                            k++;
                            Intent intent = new Intent(MainActivity.this, Autorization.class);
                            startActivity(intent);
                        }
                    }

                }
            }


            if (!pasword_1.equals(pasword_2))
            {
                findViewById(R.id.Result_1).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.Result_1)).setText("Ваши пароли не совпадают");
            }
        }
        else
        {
            findViewById(R.id.Result_1).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.Result_1)).setText("Вы не ввели логин");
        }


    }

    public void OnClickAutorize(View view) {
        Intent intent = new Intent(MainActivity.this, Autorization.class);
        startActivity(intent);
    }
}
