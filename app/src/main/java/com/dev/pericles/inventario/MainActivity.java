package com.dev.pericles.inventario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCadastro = findViewById(R.id.btnCadastro);
        final RecyclerView rclArmas = findViewById(R.id.rclArmas);

        //Entrou na activity mata a lista para não serem carregados os mesmos dados
        // se a lista está preenchida, limpar a lista antes de carregar os dados do BD:
        if (ListaArmas.getTamanhoListaArmas() > 0){
            ListaArmas.getListaArmas().clear();
        }

        // carregar a lista:
        ArmaDAO dao = new ArmaDAO(getApplicationContext());
        dao.selectArmas();

        Adapter armAdapter = new Adapter(ListaArmas.getListaArmas(), getApplicationContext());

        rclArmas.setAdapter(armAdapter);

        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false
        );

        rclArmas.setLayoutManager(meuLayout);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
            }
        });

    }
}
