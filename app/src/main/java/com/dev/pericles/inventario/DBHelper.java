package com.dev.pericles.inventario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB = "agenda";
    public static final String TABELA = "clientes";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CALIBRE = "calibre";
    public static final String CATEGORIA = "categoria";
    public static final String MATERIAL = "material";
    public static final String CAPACIDADE = "capacidade";
    public static final String PESO = "peso";
    public static final String PAIS = "pais";


    public static final int VERSAO = 3;

    public DBHelper(Context context){
        super(context, DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA +
        "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        NOME + " VARCHAR, " + CALIBRE + " VARCHAR, " + CATEGORIA + " VARCHAR, " + MATERIAL + " VARCHAR,  " + CAPACIDADE + " VARCHAR, " + PESO + " VARCHAR, " + PAIS + " VARCHAR);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABELA );
        onCreate(sqLiteDatabase);
    }
}
