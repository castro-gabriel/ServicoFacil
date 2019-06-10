package servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.UUID;
import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.TermosDeUso;
import servicofacil.gabriel.servicofacil.dao.DBsource;
import servicofacil.gabriel.servicofacil.helper.Transicao;
import servicofacil.gabriel.servicofacil.model.Solicitante;


public class CadastroSolicitante extends AppCompatActivity {

    DBsource dbsource = new DBsource(CadastroSolicitante.this);
    Transicao transicao = new Transicao();

    //Declaracao de variavi e componentes utilizados
    private LinearLayout cadastroLayout;
    private Button botao;
    private EditText editNome;
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
        setContentView(R.layout.cadastro_solicitante);


        fotoUser = findViewById(R.id.rfotoUser_usuario);
        editNome = findViewById(R.id.rNome_usuario);
        editCpf = findViewById(R.id.rCpf);
        editTel = findViewById(R.id.rNumero_ususuario);
        editEmail = findViewById(R.id.rEmail_usuario);
        editSenha = findViewById(R.id.rSenha_usuario);
        editConfSenha = findViewById(R.id.rConfSenha_usuario);
        termos = findViewById(R.id.rtermos_usuario);
        termosUso = findViewById(R.id.rtermosUso_usuario);
        cadastroLayout = findViewById(R.id.rcadastroLayout);
        botao = findViewById(R.id.rbtnCadastrar_usuario);

        //adicionando uma mascara para o campo de telefone
        SimpleMaskFormatter MaskForNumero = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher textT = new MaskTextWatcher(editTel, MaskForNumero);
        editTel.addTextChangedListener(textT);

        //evento de clique do botao cadastrar
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    //SETANDO VALORES EM SOLICITANTE
                    Solicitante solicitante = new Solicitante();
                    solicitante.setId(UUID.randomUUID().toString());
                    solicitante.setNome(editNome.getText().toString());
                    solicitante.setCpf(editCpf.getText().toString());
                    solicitante.setEmail(editEmail.getText().toString());
                    solicitante.setTelefone(editTel.getText().toString());
                    solicitante.setSenha(editSenha.getText().toString());

//                    //ENVIANDO DADOS PARA O BANCO
//                    firebaseReference.child("solicitantes").child(solicitante.getId()).setValue(solicitante);
//
//                    //C
//                    firebaseAuth.createUserWithEmailAndPassword(solicitante.getEmail(), solicitante.getSenha())
//                            .addOnCompleteListener(CadastroSolicitante.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if(task.isSuccessful()){//sucesso ao cadastrar
//                                        Snackbar snackbar = Snackbar.make(getCurrentFocus(), "Sucesso! Realize o seu login", Snackbar.LENGTH_INDEFINITE)
//                                                .setAction("OK", new View.OnClickListener() {
//                                                    @Override
//                                                    public void onClick(View view) {
//                                                        startActivity(new Intent(CadastroSolicitante.this, MainSolicitante.class));
//                                                        finish();
//                                                    }
//                                                });
//                                        snackbar.setActionTextColor(Color.CYAN);
//                                        snackbar.show();
//
//                                    }
//                                }
//                            });

                    dbsource.inserirDadosSolicitante(solicitante);

                    Snackbar.make(getCurrentFocus(), "Sucesso ao realizar cadastro. Agora realize o seu login", Snackbar.LENGTH_INDEFINITE)
                            .setAction("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getApplicationContext(), LoginSolicitante.class));
                                    finish();
                                }
                            }).show();

                }catch (Exception e){
                    e.printStackTrace();
                    Snackbar.make(getCurrentFocus(), "Erro ao inserir, verifique os dados", Snackbar.LENGTH_SHORT).show();
                }
            }
        });


        //Clique para selecionar foto
        fotoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //Clique para visualizar os termos
        termosUso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transicao.transicao(CadastroSolicitante.this, TermosDeUso.class);
            }
        });

    }

}
