package com.dev.pericles.inventario;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter {

    private ArrayList<Arma> listaArmas;
    private Context context;

    public Adapter(ArrayList<Arma> listaArmas, Context context) {
        this.listaArmas = listaArmas;
        this.context = context;
    }
    //Ctrl + I - para abrir os metodos que devem obrigatoriamente serem implementados
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Determina o Layout de cada celula do "holder" na view
        /*Informamos o contexto em que sera inserida essa RecyclerList e
        qual o arquivo de layout (xml presente na pasta res:layout)
        será utilizado para cada célula*/
        View view = LayoutInflater.from(context).inflate(R.layout.arma_layout, parent, false);

        //Determina o "holder" que será utilizado:
        ViewHolder holder = new ViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        // Esse metodo é responsável por atualiza os elementos da lsita a cada rolagem de tela
        ViewHolder holderArm = (ViewHolder)holder;

        // seta para cada elemento visivel na tela, para os elementos programados no
        // layout (contato_layout, nesse exemplo), o valor correspodente de cada elemento
        // existente na lista de armas:
        holderArm.txtNome.setText(listaArmas.get(position).getNome());
        //holderArm.txtNome.setText("Ver Detalhes");

        holderArm.txtNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Posição na lisa e não no Banco de Dados
                //Toast.makeText(context, "Arma na posição " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetalhesActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });

        /*
        // determina qual icone/foto irá ser exibido na tela baseando-se no genero cadastrado:
        if(ListaContatos.getContato(position).getSexo().equals("Masculino")){

            viewHolder.iconContato.setImageResource(R.drawable.male_icon);
        }else{
            viewHolder.iconContato.setImageResource(R.drawable.female_icon);
        }*/

    }

    @Override
    public int getItemCount() {
        return listaArmas.size();
    }
}
