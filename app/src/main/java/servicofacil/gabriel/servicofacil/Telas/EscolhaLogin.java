package servicofacil.gabriel.servicofacil.Telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.LoginSolicitante;
import servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.LoginPrestador;
import servicofacil.gabriel.servicofacil.helper.Transicao;

public class EscolhaLogin extends AppCompatActivity {

    //declaracao dos componentes de escolha que temos na tela
    private Button btn_usuario_c;
    private Button btn_usuario_s;

    //criando um objeto do tipo transicao para utilizar na tela
    Transicao t = new Transicao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolha_login);

        //Fazendo referencias das váriaveis para os seus elementos por id
        btn_usuario_c = findViewById(R.id.btn_uc);
        btn_usuario_s = findViewById(R.id.btn_us);

        //evento de clique dos botoes
        btn_usuario_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.transicao(EscolhaLogin.this, LoginSolicitante.class);
            }
        });

        btn_usuario_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.transicao(EscolhaLogin.this, LoginPrestador.class);
            }
        });


    }



}
