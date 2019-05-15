package com.example.appreceotas009;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class receirasDAO {
    private Conexaobd conexao;
    private SQLiteDatabase banco;

    public receirasDAO (Context context){
        conexao = new Conexaobd(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirReceita (receitas Rec){
        ContentValues values = new ContentValues();
        values.put("nome", Rec.getNome());
        values.put("ingredientes", Rec.getIngredientes());
        return banco.insert("receitas", null, values);
    }

    public List<receitas> retornarTodasCategorias(){
        List<receitas> categorias = new ArrayList<>();
        Cursor cursor = banco.query("receitas", new String[]{"id", "nome", "ingredientes"},
                null, null, null, null, null, null);
        while (cursor.moveToNext()){
            receitas r = new receitas();
            r.setId(cursor.getInt(0));
            r.setNome(cursor.getString(1));
            r.setIngredientes(cursor.getString(2));
            receitas.add(r);
        }

        return receitas;
    }

    public void excluirCategoria (receitas ret){
        banco.delete("categoria", "id = ?", new String[]{rec.getId().toString()});
    }

    public void atualizarReceitas (receitas rec){
        ContentValues values = new ContentValues();
        values.put("nome", rec.getNome());
        values.put("ingredientes", rec.getIngredientes());
        banco.update("receitas", values,
                "where = ?", new String[]{receitas.getId().toString()});
    }
}
