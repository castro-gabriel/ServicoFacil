package servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.Tabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.helper.Recursos;

public class TabPerfilSolicitante extends Fragment{

    private ImageView image;
    private TextView nome;
    private TextView email;
    private TextView tel;
    private Button trabalheConosco;
    private static final int RESULT_LOAD_IMAGE = 123;
    private FirebaseAuth firebaseUser;
    private DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.tab_perfil_solicitante, container, false);

        image = View.findViewById(R.id.fotoUserPerfil_s);
        nome = View.findViewById(R.id.nomeUserPerfil_u);
        email = View.findViewById(R.id.emailUserPerfil_u);
        tel = View.findViewById(R.id.telUserPerfil_u);
        trabalheConosco = View.findViewById(R.id.trabalheConosco);

        nome.setText(Recursos.getInstance().getSolicitanteAtivo().getNome());
        email.setText(Recursos.getInstance().getSolicitanteAtivo().getEmail());
        tel.setText(Recursos.getInstance().getSolicitanteAtivo().getTelefone());

//        //FREBASE
//        databaseReference = ConfigFirebase.getFirebase();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null){
//
//            for (UserInfo prof: user.getProviderData()){
//                nome.setText(prof.getDisplayName());
//                email.setText(prof.getEmail());
//                tel.setText(prof.getPhoneNumber());
//            }
//
//        }


        trabalheConosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 123){
                Uri imagemSelecionada = data.getData();

            }
        }
    }
}
