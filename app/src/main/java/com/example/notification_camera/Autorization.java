package com.example.notification_camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Autorization extends AppCompatActivity {
    private String pasword_Autorizaton;
    private String name_Autorizaton;

    private int i;
    public static int person_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);
    }
    public void OnClickRegistration(View view){
        Intent intent = new Intent(Autorization.this, MainActivity.class);
        startActivity(intent);
    }
    public void OnClickNextMenu(View view){

        EditText editTextLogin = (EditText) findViewById(R.id.Name_Autorization);
        name_Autorizaton = editTextLogin.getText().toString();
        EditText editTextPassword2 = (EditText) findViewById(R.id.Password_Autorization);
        pasword_Autorizaton = editTextPassword2.getText().toString();

        if (!pasword_Autorizaton.isEmpty() && !name_Autorizaton.isEmpty()){
            for( i = 0; i < 15; i++) {


                if (name_Autorizaton.equals(Archivator.PersonName[i])){

                    if (pasword_Autorizaton.equals(Archivator.Personpassword[i])){
                        person_number=i;
                        Intent intent = new Intent(Autorization.this, Notification_Camera.class);
                        startActivity(intent);
                    }else {
                        findViewById(R.id.error_Autorization).setVisibility(View.VISIBLE);
                        ((TextView) findViewById(R.id.error_Autorization)).setText("неверно введён пароль или логин");
                    }
                }else {
                    findViewById(R.id.error_Autorization).setVisibility(View.VISIBLE);
                    ((TextView) findViewById(R.id.error_Autorization)).setText("нет такого пользователя");
                }

            }

        }else{
            findViewById(R.id.error_Autorization).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.error_Autorization)).setText("Есть пустые поля");
        }

    }

}