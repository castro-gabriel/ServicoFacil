package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.TermosDeUso;
import servicofacil.gabriel.servicofacil.dao.DBsource;
import servicofacil.gabriel.servicofacil.helper.Transicao;
import servicofacil.gabriel.servicofacil.model.Prestador;


public class CadastroPrestador extends AppCompatActivity {

    ConstraintLayout layout;
    Transicao transicao = new Transicao();
    DBsource dbsource = new DBsource(CadastroPrestador.this);
    Prestador prestador = new Prestador();

    private LinearLayout cadastroLayout;
    private Button botao;
    private EditText editNome;
    private EditText editNasc;
    private EditText editCpf;
    private EditText editTel;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editConfSenha;
    private CheckBox termos;
    private TextView termosUso;
    private ImageView fotoUser;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_prestador);

        editEmail = findViewById(R.id.rEmail_servidor);
        editSenha = findViewById(R.id.rSenha_servidor);
        editConfSenha = findViewById(R.id.rConfSenha_servidor);
        termos = findViewById(R.id.rtermos_servidor);
        termosUso = findViewById(R.id.rtermosUso_servidor);
        fotoUser = findViewById(R.id.rfotoUser_servidor);
        editNasc = findViewById(R.id.rNascimento_servidor);
        editCpf = findViewById(R.id.rCpf_servidor);
        editTel = findViewById(R.id.rNumero_servidor);
        cadastroLayout = findViewById(R.id.rcadastroLayout_servidor);
        botao = findViewById(R.id.rbtnCadastrar_servidor);
        editNome = findViewById(R.id.rNome_servidor);
        fotoUser = findViewById(R.id.rfotoUser_servidor);

        layout = findViewById(R.id.layoutCadastro);

        SimpleMaskFormatter MaskForNasc = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher textN = new MaskTextWatcher(editNasc, MaskForNasc);
        editNasc.addTextChangedListener(textN);

        SimpleMaskFormatter MaskForCpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher textC = new MaskTextWatcher(editCpf, MaskForCpf);
        editCpf.addTextChangedListener(textC);

        SimpleMaskFormatter MaskForNumero = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher textT = new MaskTextWatcher(editTel, MaskForNumero);
        editTel.addTextChangedListener(textT);


        //Eventos de clique
        // Botao Cadastrar
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //SETANDO OS VALORES DE PRESTADOR PARA SER INSERIDO
                    prestador.setId(UUID.randomUUID().toString());
                    prestador.setNome(editNome.getText().toString());
                    prestador.setCpf(editCpf.getText().toString());
                    prestador.setNascimento(editNasc.getText().toString());
                    prestador.setEmail(editEmail.getText().toString());
                    prestador.setTelefone(editTel.getText().toString());
                    prestador.setSenha(editSenha.getText().toString());


                    //                    //ENVIANDO OS DADOS PARA O BANCO
//                    firebaseReference.child("prestadores").child(prestador.getId()).setValue(prestador);
//
////                    dbsource.inserirDadosPrestador(prestador);
//
//                    //C
//                    firebaseAuth.createUserWithEmailAndPassword(prestador.getEmail(), prestador.getSenha())
//                            .addOnCompleteListener(CadastroPrestador.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if(task.isSuccessful()){//sucesso ao cadastrar
//                                        Snackbar snackbar = Snackbar.make(getCurrentFocus(), "Sucesso! Realize o seu login", Snackbar.LENGTH_INDEFINITE)
//                                                .setAction("OK", new View.OnClickListener() {
//                                                    @Override
//                                                    public void onClick(View view) {
//                                                        startActivity(new Intent(CadastroPrestador.this, EscolherServico.class));
//                                                        finish();
//                                                    }
//                                                });
//                                        snackbar.setActionTextColor(Color.CYAN);
//                                        snackbar.show();
//
//                                    }
//                                }
//                            });

                    dbsource.inserirDadosPrestador(prestador);

                }catch (Exception e){
                    //AVISO QUE DEU ERRO
                    Snackbar.make(getCurrentFocus(), "Erro, verifique os seus dados", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        fotoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Clique para visualizar os termos
        termosUso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transicao.transicao(CadastroPrestador.this, TermosDeUso.class);
            }
        });

    }

    public Prestador getPrestador(){
        return prestador;
    }
}
