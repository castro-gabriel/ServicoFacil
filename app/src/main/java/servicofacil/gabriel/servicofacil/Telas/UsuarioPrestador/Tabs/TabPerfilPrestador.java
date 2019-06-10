package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.Tabs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.helper.Recursos;
import servicofacil.gabriel.servicofacil.model.Prestador;

public class TabPerfilPrestador extends Fragment{

    private ImageView image;
    private TextView nome;
    private TextView email;
    private TextView tel;
    private FloatingActionButton btn_add;
    private FloatingActionButton btn_editar_perfil;
    private ListView list;
    public static final int RESULT_LOAD_IMAGE = 123;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Prestador prestador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.tab_perfil_prestador, container, false);

        nome = View.findViewById(R.id.nomeUserPerfil_s);
        email = View.findViewById(R.id.emailUserPerfil_s);
        tel = View.findViewById(R.id.telUserPerfil_s);
        btn_add = View.findViewById(R.id.fab_add_servico);
        list = View.findViewById(R.id.list_servicos);
        image = View.findViewById(R.id.fotoUserPerfil_s);

        nome.setText(Recursos.getInstance().getPrestadorAtivo().getNome());
        email.setText(Recursos.getInstance().getPrestadorAtivo().getEmail());
        tel.setText(Recursos.getInstance().getPrestadorAtivo().getTelefone());

//        //FREBASE
//        FirebaseApp.initializeApp(getContext());
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference();
//
//        databaseReference.child("prestadores").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for(DataSnapshot d : dataSnapshot.getChildren()) {
//                    Prestador prestador = dataSnapshot.getValue(Prestador.class);
//                    nome.setText(prestador.getNome());
//                    email.setText(prestador.getEmail());
//                    tel.setText(prestador.getTelefone());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_servico();
            }
        });

/*        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });*/

        return View;
    }


    private void add_servico(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        //Configuracao do alertDialog
        alertDialog.setTitle("Adicionar Serviço");
        alertDialog.setCancelable(false);
        final EditText editText = new EditText(getContext());
        editText.setHint("Digite o serviço aqui");
        alertDialog.setView(editText);

        //Configuracao dos botoes
        alertDialog.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.create();
        alertDialog.show();
    }


}
