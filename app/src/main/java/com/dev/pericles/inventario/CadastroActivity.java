package com.dev.pericles.inventario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    int id = 0;
    String nome;
    String calibre;
    String categoria;
    String material;
    String capacidade;
    String peso;
    String pais;
    boolean atualizar;
    Arma arma;
    String msg;
    ArmaDAO dao;
    String categ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // elementos da interface:
        final EditText edtNome = findViewById(R.id.edtNome);
        final EditText edtCalibre = findViewById(R.id.edtCalibre);
        final EditText edtMaterial = findViewById(R.id.edtMaterial);
        final EditText edtCapacidade = findViewById(R.id.edtCapacidade);
        final EditText edtPeso = findViewById(R.id.edtPeso);
        final EditText edtPais = findViewById(R.id.edtPais);
        final Button btnCadastrar = findViewById(R.id.btnCadastrar);
        final Button btnCancelar = findViewById(R.id.btnCancelar);
        final RadioGroup rdGroup = findViewById(R.id.rdGroup);

        final RadioButton rdPt = findViewById(R.id.rdPt);
        final RadioButton rdSmg = findViewById(R.id.rdSmg);
        final RadioButton rdAr = findViewById(R.id.rdAr);
        final RadioButton rdSg = findViewById(R.id.rdSg);
        final RadioButton rdSr = findViewById(R.id.rdSr);
        final RadioButton rdMg = findViewById(R.id.rdMg);



        // seta dao
        dao = new ArmaDAO(getApplicationContext());
        // recebe intent
        Intent intent = getIntent();
        // recebe bundle da intent (se tiver)
        Bundle bundle = intent.getExtras();
        // nao atualizará (ainda)
        atualizar = false;

        // se recebeu o bundle
        if (bundle != null){

            // a ação do botão será atualizar:
            atualizar = true;
            // variáveis globais recebem valores do bundle:
            id = bundle.getInt("id");
            nome = bundle.getString("nome");
            calibre = bundle.getString("calibre");
            categoria = bundle.getString("categoria");
            material = bundle.getString("material");
            capacidade = bundle.getString("capacidade");
            peso = bundle.getString("peso");
            pais = bundle.getString("pais");

            // seta campos de texto com valores recebidos:
            edtNome.setText(nome.toString());
            edtCalibre.setText(calibre.toString());
            edtMaterial.setText(material.toString());
            edtCapacidade.setText(capacidade.toString());
            edtPeso.setText(peso.toString());
            edtPais.setText(pais.toString());

            //categ = categoria;
            if (categoria.equals("PT")) {
                rdPt.setChecked(true);
            }if (categoria.equals("SMG")){
                rdSmg.setChecked(true);
            }if (categoria.equals("AR")){
                rdAr.setChecked(true);
            }if (categoria.equals("SG")){
                rdSg.setChecked(true);
            }if (categoria.equals("SR")){
                rdSr.setChecked(true);
            }else if(categoria.equals("MG")){
                rdMg.setChecked(true);
            }

        }


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // variáveis globais recebem valores dos campos de texto (exceto o id, que não deve ser alterado)
                    categ = ((RadioButton)findViewById(rdGroup.getCheckedRadioButtonId())).getText().toString();
                    nome = edtNome.getText().toString();
                    calibre = edtCalibre.getText().toString();
                    categoria = categ.toString();
                    material = edtMaterial.getText().toString();
                    capacidade = edtCapacidade.getText().toString();
                    peso = edtPeso.getText().toString();
                    pais = edtPais.getText().toString();

                    // se atualizar for 'true':
                    if (atualizar){
                        categ = ((RadioButton)findViewById(rdGroup.getCheckedRadioButtonId())).getText().toString();
                        // arma receberá dados dos campos de texto e o id
                        // (obs: o id é o valor recebido do bundle. Não deve ser digitado)
                        arma = new Arma(id, nome, calibre, categoria, material, capacidade, peso, pais);

                        // chama método que tenta atualizar dados do cliente
                        if (dao.alterarArma(arma)){
                            // se retornar 'true':
                            msg = "Arma atualizada com sucesso";
                        }else {
                            // senão:
                            msg = "Erro ao atualizar arma";
                        }
                    }else {// se o valor de 'atualizar' for false

                        // cria objeto de Arma com as informações recebidas
                        // (obs: o id informamos zero, pois nesse momento ele não é importante)
                        Arma arma = new Arma(id, nome, calibre, categoria, material, capacidade, peso, pais);

                        ArmaDAO dao = new ArmaDAO(getApplicationContext());

                        // chama método que tentará salvar ciente no BD
                        if (dao.salvarArma(arma)){// se ação bem-sussedida
                            msg = "Arma cadastrada com sucesso!";
                        }else {
                            msg = "Erro ao cadastrar arma...";
                        }
                    }

                    int id = 0;

                    //ListaArmas.addArma(new Arma(id, nome, email, fone));

                    Toast.makeText(CadastroActivity.this, msg, Toast.LENGTH_LONG).show();
                }catch (NullPointerException e){
                    e.printStackTrace();
                    Toast.makeText(CadastroActivity.this, "Erro ao conectar com o banco de dados", Toast.LENGTH_LONG).show();
                }
                // cadastrando nova arma ou editando um existente, voltaremos para o Main Activity de qualquer forma...
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}
