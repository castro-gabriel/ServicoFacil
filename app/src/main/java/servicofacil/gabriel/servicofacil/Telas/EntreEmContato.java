package servicofacil.gabriel.servicofacil.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import servicofacil.gabriel.servicofacil.R;


public class EntreEmContato extends AppCompatActivity {


    private Button btn_enviar_mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entre_em_contato);

        btn_enviar_mensagem = findViewById(R.id.btn_enviar_mensagem);

        btn_enviar_mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.mv_esquerda, R.anim.find_out);
    }
}
