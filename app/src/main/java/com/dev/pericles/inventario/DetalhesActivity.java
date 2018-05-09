package com.dev.pericles.inventario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity {
    private Arma arma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        final TextView txtId = findViewById(R.id.txtId);
        final TextView txtNome = findViewById(R.id.txtNome);
        final TextView txtCalibre = findViewById(R.id.txtCalibre);
        final TextView txtCategoria = findViewById(R.id.txtCategoria);
        final TextView txtMaterial = findViewById(R.id.txtMaterial);
        final TextView txtCapacidade = findViewById(R.id.txtCapacidade);
        final TextView txtPeso = findViewById(R.id.txtPeso);
        final TextView txtPais = findViewById(R.id.txtPais);

        final Button btnVoltar = findViewById(R.id.btnVoltar);
        final Button btnAlterar = findViewById(R.id.btnAlterar);
        final Button btnExcluir = findViewById(R.id.btnExcluir);


        Intent intent = getIntent();
        int index = intent.getIntExtra("index", -1);
        //Arma arma = ListaArmas.getListaArmas().get(index);

        if (index != -1){
            arma = ListaArmas.getListaArmas().get(index);

            txtId.setText(String.valueOf(arma.getId()));
            txtNome.setText(arma.getNome().toString());
            txtCalibre.setText(arma.getCalibre().toString());
            txtCategoria.setText(arma.getCategoria().toString());
            txtMaterial.setText(arma.getMaterial().toString());
            txtCapacidade.setText(arma.getCapacidade().toString());
            txtPeso.setText(arma.getPeso().toString());
            txtPais.setText(arma.getPais().toString());
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentAlterar = new Intent(getApplicationContext(), CadastroActivity.class);
                Bundle bundle = new Bundle();

                bundle.putInt("id", arma.getId());
                bundle.putString("nome", arma.getNome());
                bundle.putString("calibre", arma.getCalibre());
                bundle.putString("categoria", arma.getCategoria());
                bundle.putString("material", arma.getMaterial());
                bundle.putString("capacidade", arma.getCapacidade());
                bundle.putString("peso", arma.getPeso());
                bundle.putString("pais", arma.getPais());

                intentAlterar.putExtras(bundle);

                startActivity(intentAlterar);
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArmaDAO dao = new ArmaDAO(getApplicationContext());

                String msg;
                if (dao.excluirArma(arma.getId())){
                    msg = "Arma excluida com sucesso";
                }else {
                    msg = "Erro ao excluir a arma";
                }
                Toast.makeText(DetalhesActivity.this, msg, Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });



    }
}
