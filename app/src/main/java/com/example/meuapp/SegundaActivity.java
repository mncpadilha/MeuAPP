package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;

public class SegundaActivity extends AppCompatActivity {

    EditText tCadastro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela);

        tCadastro = (EditText) findViewById(R.id.editText2);

        FileWriter writer = null;
        final JSONObject objetoJson = new JSONObject();
        Button btCadastro = (Button) findViewById(R.id.btCadastro);
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String livro = pegarValorDoCadastro();
                Log.d("Valor variavel livro: " , livro);
                if (livro !=  null || livro != ""){
                    try {
                        objetoJson.put("livros.json",tCadastro);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    alert("Cadastro realizado com sucesso");

                }else{
                    alert("Campo vazio");
                }
            }

        });

       Button btConsulta = (Button) findViewById(R.id.btConsulta);
        btConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String livro = pegarValorDoCadastro();
                if (livro !=  ""){
                    alert("Consulta realizada com sucesso");
                    irParaTerceiraTela();

                }else{
                    alert("Campo vazio");
                }
            }
        });

        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String livro = pegarValorDoCadastro();
                if (livro !=  null){
                    alert("Livro excluido com sucesso");

                }else{
                    alert("Campo vazio");
                }
            }
        });
    }

    public String pegarValorDoCadastro() {
        return tCadastro.getText().toString();
    }

    public Boolean validarNomeDoLivro() {
        Boolean livro = tCadastro.getText().toString().isEmpty();
        if (livro) {
            tCadastro.setError("Campo Obrigatorio");
        }
        return livro;
    }
    private void irParaTerceiraTela() {
        startActivity(new Intent(this, TerceiraActivity.class));
    }
    private void alert(String s ){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
