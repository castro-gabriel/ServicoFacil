package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.helper.Transicao;
import servicofacil.gabriel.servicofacil.model.Funcao;
import servicofacil.gabriel.servicofacil.model.Prestador;

public class EscolherServico extends AppCompatActivity {

    private ListView lista_escolher_servicos;
    private String se = "nenhum";

    Transicao transicao = new Transicao();
    ArrayList<String> s = new ArrayList<String>();
    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolher_servico);

        lista_escolher_servicos = findViewById(R.id.lista_escolha_servico);

        ArrayList<Funcao> funcaos = todosServicos();
        ArrayAdapter<Funcao> adapter = new ArrayAdapter<Funcao>(this, android.R.layout.simple_list_item_checked, funcaos);

        lista_escolher_servicos.setAdapter(adapter);

        lista_escolher_servicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        se = s.get(0);
                        pegarServico();
                        break;
                    case 1:
                        se = s.get(1);
                        pegarServico();
                        break;
                    case 2:
                        se = s.get(2);
                        pegarServico();
                        break;
                    case 3:
                        se = s.get(3);
                        pegarServico();
                        break;
                    case 4:
                        se = s.get(4);
                        pegarServico();
                        break;
                    case 5:
                        se = s.get(5);
                        pegarServico();
                        break;
                    case 6:
                        se = s.get(6);
                        pegarServico();
                        break;
                    case 7:
                        se = s.get(7);
                        pegarServico();
                        break;
                    case 8:
                        se = s.get(8);
                        pegarServico();
                        break;
                    case 9:
                        se = s.get(9);
                        pegarServico();
                        break;
                    case 10:
                        se = s.get(10);
                        pegarServico();
                        break;
                    case 11:
                        se = s.get(11);
                        pegarServico();
                        break;
                    case 12:
                        se = s.get(12);
                        pegarServico();
                        break;
                    case 13:
                        se = s.get(13);
                        pegarServico();
                        break;
                    case 14:
                        se = s.get(14);
                        pegarServico();
                        break;
                    case 15:
                        se = s.get(15);
                        pegarServico();
                        break;
                }


            }
        });

    }

    private ArrayList todosServicos(){
        s.add("Babá");
        s.add("Cabeleleira a domicílio");
        s.add("Cuidar de idosos");
        s.add("Decorador de festas");
        s.add("Diárista");
        s.add("Dog walker (passeador de cães)");
        s.add("Eletricista");
        s.add("Encanador");
        s.add("Fotografo");
        s.add("Jardinagem");
        s.add("Manicure e Pedicure a domicílio");
        s.add("Manutenão de celular");
        s.add("Manutenção de computadores");
        s.add("Manutenção em antenas digitais");
        s.add("Maquiagem a domicílio");
        s.add("Pedreiro");
        s.add("Pintor");

        return s;
    }

    private void pegarServico(){

        AlertDialog.Builder alert = new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        alert.setTitle("Confirmar serviço");
        alert.setMessage(se);

        alert.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                startActivity(new Intent(EscolherServico.this, MainPrestador.class));
                finish();

            }
        });
        alert.create();
        alert.show();
    }
}
