package com.arthur.loginmvc.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.arthur.loginmvc.datamodel.UsuarioDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "MVC_Arthur.sqlite";
    private static final int VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioDataModel.criarTabela());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean insert(String tabela, ContentValues dados) {
        db = getWritableDatabase();
        boolean retorno = false;
        try {
            // Se o insert der certo, o método retorna o ID do registro, que será > 0
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public boolean checkUser(String email) {
        db = getWritableDatabase();
        String sql = "SELECT * FROM " + UsuarioDataModel.TABELA + " WHERE email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email});
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }

    public boolean checkUserPassword(String email, String password) {
        db = getWritableDatabase();
        String sql = "SELECT * FROM " + UsuarioDataModel.TABELA + " WHERE email = ? AND senha = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email, password});
        boolean corresponde = cursor.getCount() > 0;
        cursor.close();
        return corresponde;
    }
}