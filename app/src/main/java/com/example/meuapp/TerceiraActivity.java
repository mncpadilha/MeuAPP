package com.example.meuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TerceiraActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiratela);
        ListView listView = findViewById(R.id.listView);
        List<String> livros = retornarLivros();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, livros);
        listView.setAdapter(adapter);
    }


    public List<String> retornarLivros(){
        JsonParser jsonParser =new JsonParser();
        ArrayList<String> livros= new ArrayList<>();

        try{
            Object obj = jsonParser.parse(new InputStreamReader(getAssets().open( "livros/livros.json")));
            JsonArray jsonArray= (JsonArray) obj;

            Log.d("FIRST",jsonArray.get(0).getAsString());

            for(int i =0; i<jsonArray.size();i++){
                livros.add(jsonArray.get(i).getAsString());
            }

            return livros;
        }catch (Exception e){
            Log.e("ARQUIVO NAO ENCONTRADO", e.getMessage());
            e.printStackTrace();
            return  null;
        }

    }

    public List<String> retornarPorNome(String nome){
        List<String> todosLivros = retornarLivros();

        List<String> livrosPorNome = new ArrayList<>();

        for(int i =0; i<todosLivros.size();i++){
            if(todosLivros.get(i).toLowerCase().contains(nome.toLowerCase())){
                livrosPorNome.add(todosLivros.get(i));
            }
        }
        return livrosPorNome;

    }


    public void onClick(View v) {

//        if(v.getId() == R.id.btVoltar)
//        irParaSegundaTela();

    }
    private void irParaSegundaTela() {
        startActivity(new Intent(this, SegundaActivity.class));
    }
}