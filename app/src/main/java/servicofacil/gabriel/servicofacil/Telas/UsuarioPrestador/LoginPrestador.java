package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.EscolhaLogin;
import servicofacil.gabriel.servicofacil.Telas.NovaSenha;
import servicofacil.gabriel.servicofacil.config.ConfigInternet;
import servicofacil.gabriel.servicofacil.dao.DBsource;
import servicofacil.gabriel.servicofacil.helper.Recursos;
import servicofacil.gabriel.servicofacil.helper.Transicao;
import servicofacil.gabriel.servicofacil.model.Prestador;

public class LoginPrestador extends AppCompatActivity {

    private EditText campoEmail;
    private EditText campoSenha;
    private Button buttonEntrar;
    private TextView esqueceuSenha;
    private TextView cadastrar;
    private ImageView back;
    private ConstraintLayout loginLayout;
    private ProgressDialog progress;
    private FirebaseAuth firebaseAuth;

    Transicao transicao = new Transicao();
    ConfigInternet configInternet = new ConfigInternet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_prestador);

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        if(firebaseAuth.getCurrentUser() != null){
//            startActivity(new Intent(LoginPrestador.this, MainPrestador.class));
//            finish();
//        }

        loginLayout = findViewById(R.id.ConstraintLayout_servidor);
        campoEmail = findViewById(R.id.cEmail_servidor);
        campoSenha = findViewById(R.id.cSenha_servidor);
        esqueceuSenha = findViewById(R.id.novaSenha_servidor);
        cadastrar = findViewById(R.id.cadastro_servidor);
        buttonEntrar = findViewById(R.id.bEntrar_servidor);
        back = findViewById(R.id.voltars);


        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(configInternet.isOnline(LoginPrestador.this)){

                    String email = campoEmail.getText().toString();
                    String senha = campoSenha.getText().toString();

//                    firebaseAuth.signInWithEmailAndPassword(email, senha)
//                            .addOnCompleteListener(LoginPrestador.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                    if(!task.isSuccessful()){
//                                        Snackbar.make(getCurrentFocus(), "Erro ao realizar login, tente novamente", Snackbar.LENGTH_SHORT).show();
//                                    }else{
//                                        startActivity(new Intent(LoginPrestador.this, MainPrestador.class));
//                                        finish();
//                                    }
//
//                                }
//                            });

                    DBsource dBsource = new DBsource(getApplicationContext());
                    Prestador prestador = dBsource.consultaDadosPrestador(campoEmail.getText().toString());

                    if(prestador==null){
                        Snackbar.make(getCurrentFocus(), "Não existe usuário cadastro com este email", Snackbar.LENGTH_SHORT).show();
                    }else if(!campoSenha.getText().toString().equals(prestador.getSenha())){
                        Snackbar.make(getCurrentFocus(), "Senha incorreta!", Snackbar.LENGTH_SHORT).show();
                    }else{
                        Recursos.getInstance().setPrestadorAtivo(prestador);
                        startActivity(new Intent(LoginPrestador.this, MainPrestador.class));
                        finish();
                    }

                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginPrestador.this);
                    alert.setTitle("Sem conexao");
                    alert.setMessage("Conecte-se a internet");
                    alert.create();
                    alert.show();
                }
                }
        });

        esqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transicao.transicao(LoginPrestador.this, NovaSenha.class);
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(configInternet.isOnline(LoginPrestador.this)) {
                    startActivity(new Intent(LoginPrestador.this, CadastroPrestador.class));
                    finish();
                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginPrestador.this);
                    alert.setTitle("Erro!");
                    alert.setMessage("Conecte-se a internet para ir para a tela de cadastro");
                    alert.create();
                    alert.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transicao.transicao(LoginPrestador.this, EscolhaLogin.class);
                finish();
            }
        });

    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.mv_esquerda, R.anim.find_out);
    }

    private void dialogTempo(String title, String message){
        progress = new ProgressDialog(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        progress.setTitle(title);
        progress.setMessage(message);
        progress.show();

        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.cancel();
            }
        };

        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);

        progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                progress.dismiss();
            }
        });
    }
}

