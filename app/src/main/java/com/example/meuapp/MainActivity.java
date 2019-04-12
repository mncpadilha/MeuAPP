package com.example.meuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
                if (login.equals("monica")&&senha.equals("123456")){
                    alert("Login realizado com sucesso");
                    irParaSegundaTela();
                }else{
                    alert("Login ou Senha incorretos");
                }
            }
        });
    }

    private void irParaSegundaTela() {
        startActivity(new Intent(this, SegundaActivity.class));
    }
    private void alert(String s ){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
