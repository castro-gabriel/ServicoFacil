package servicofacil.gabriel.servicofacil.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import servicofacil.gabriel.servicofacil.R;

public class Notificacao extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> notificacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificacao);

        listView = findViewById(R.id.list_notificacao);

        //Instânciar osobjetos
        notificacoes = new ArrayList<>();

        adapter = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,
                notificacoes
        );
        listView.setAdapter(adapter);

    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.mv_esquerda, R.anim.find_out);
    }
}
