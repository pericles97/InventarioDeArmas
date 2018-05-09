package com.dev.pericles.inventario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ArmaDAO {

    private DBHelper helper;
    private DBGateway gateway;

    public ArmaDAO(Context context){
        gateway = DBGateway.getInstance(context);
    }

    public boolean salvarArma(Arma arma){

        ContentValues values = new ContentValues();
        long resultado;

        values.put(helper.NOME, arma.getNome());
        values.put(helper.CALIBRE, arma.getCalibre());
        values.put(helper.CATEGORIA, arma.getCategoria());
        values.put(helper.MATERIAL, arma.getMaterial());
        values.put(helper.CAPACIDADE, arma.getCapacidade());
        values.put(helper.PESO, arma.getPeso());
        values.put(helper.PAIS, arma.getPais());


        resultado = gateway.getDataBase().insert(helper.TABELA, null, values);

        if(resultado > 0){
            return true;
        }

        return false;
    }


    public void selectArmas(){

        Cursor cursor = gateway.getDataBase().rawQuery("SELECT * FROM " + helper.TABELA, null);

        try{

            cursor.moveToFirst();

            while (cursor!= null){

                int id = cursor.getInt(cursor.getColumnIndex(helper.ID));
                String nome = cursor.getString(cursor.getColumnIndex(helper.NOME));
                String calibre = cursor.getString(cursor.getColumnIndex(helper.CALIBRE));
                String categoria = cursor.getString(cursor.getColumnIndex(helper.CATEGORIA));
                String material = cursor.getString(cursor.getColumnIndex(helper.MATERIAL));
                String capacidade = cursor.getString(cursor.getColumnIndex(helper.CAPACIDADE));
                String peso = cursor.getString(cursor.getColumnIndex(helper.PESO));
                String pais = cursor.getString(cursor.getColumnIndex(helper.PAIS));

                ListaArmas.addArma(new Arma(id, nome, calibre, categoria, material, capacidade, peso, pais));
                cursor.moveToNext();
            }
            cursor.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean alterarArma(Arma arma){
        String where = helper.ID + " = ?";
        String[] args = {String.valueOf(arma.getId())};

        ContentValues values = new ContentValues();

        values.put(helper.NOME, arma.getNome());
        values.put(helper.CALIBRE, arma.getCalibre());
        values.put(helper.CATEGORIA, arma.getCategoria());
        values.put(helper.MATERIAL, arma.getMaterial());
        values.put(helper.PESO, arma.getPeso());
        values.put(helper.PAIS, arma.getPais());

        long resultado;

        resultado = gateway.getDataBase().update(helper.TABELA, values, where, args);

        if (resultado > 0){
            return true;
        }
        return false;
    }

    public boolean excluirArma(int id){
        String where = helper.ID + " = ? ";
        String[] args = {String.valueOf(id)};

        long resultado;

        resultado = gateway.getDataBase().delete(helper.TABELA, where, args);

        if (resultado > 0){
            return true;
        }
        return false;
    }
}
