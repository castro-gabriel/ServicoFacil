package servicofacil.gabriel.servicofacil.Telas;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import servicofacil.gabriel.servicofacil.R;

public class NovaSenha extends AppCompatActivity {

    private EditText campoRecuperar;
    private Button btnNewSenha;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_senha);

        campoRecuperar = findViewById(R.id.campoRecuperar);
        btnNewSenha = findViewById(R.id.bRecuperar);

        firebaseAuth = FirebaseAuth.getInstance();

        //Clque para recuperar ou gerar nova senha
        btnNewSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth
                        .sendPasswordResetEmail(campoRecuperar.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if ( task.isSuccessful() ){
                                    campoRecuperar.setText("");
                                    Snackbar.make(getCurrentFocus(), "Email enviado com sucesso!", Snackbar.LENGTH_LONG).show();
                                }else {
                                    Snackbar.make(getCurrentFocus(), "Erro, verifique o email", Snackbar.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });

    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.mv_esquerda, R.anim.find_out);
    }
}
