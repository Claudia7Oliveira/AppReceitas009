package com.example.appreceotas009;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class cadastro_receitas extends AppCompatActivity {

    private Conexaobd conexao;
    private SQLiteDatabase banco;

    public receirasDAO (Context context){
        conexao = new Conexaobd(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir (receitas rec){
        ContentValues values = new ContentValues();
        values.put("nome", rec.getNome());
        values.put("ingredientes", rec.getIngredientes());
        return banco.insert("receitas", null, values);
    }

    public List<receitas> returnAll(){
        List<receitas> categorias = new ArrayList<>();
        Cursor cursor = banco.query("receitas", new String[]{"id", "nomeR", "ingredientes"},
                null, null, null, null, null, null);
        while (cursor.moveToNext()){
            receitas r = new receitas();
            r.setId(cursor.getInt(0));
            r.setNome(cursor.getString(1));
            r.setIngredientes(cursor.getString(2));
            categorias.add(r);
        }

        return categorias;
    }

    public void excluirReceita (receitas rec){
        banco.delete("receitas", "id = ?", new String[]{rec.getId().toString()});
    }

    public void atualizarReceitas (receitas rec){
        ContentValues values = new ContentValues();
        values.put("nome", rec.getNome());
        values.put("ingredientes", rec.getIngredientes());
        banco.update("receitas", values,
                "where = ?", new String[]{rec.getId().toString()});
    }
}
