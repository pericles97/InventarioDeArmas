package com.dev.pericles.inventario;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder{

    //Quais são os elementos que você quer referenciar
    //Quais são os elementos da classe estarão visiveis na célula: *Nesse caso só traz o Nome
    TextView txtNome;

    //Construtor do holder:
    public ViewHolder(View itemView){
        super(itemView);

        //Capturando
        txtNome = itemView.findViewById(R.id.txtNome);
    }

}
