package servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.Chat;
import servicofacil.gabriel.servicofacil.Telas.EntreEmContato;
import servicofacil.gabriel.servicofacil.Telas.EscolhaLogin;
import servicofacil.gabriel.servicofacil.Telas.Notificacao;
import servicofacil.gabriel.servicofacil.Telas.Sobre;
import servicofacil.gabriel.servicofacil.Telas.TermosDeUso;
import servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.Tabs.TabHistoricoPrestador;
import servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.Tabs.TabPerfilPrestador;
import servicofacil.gabriel.servicofacil.Telas.UsuarioPrestador.Tabs.TabPesquisaPrestador;
import servicofacil.gabriel.servicofacil.helper.Transicao;


public class MainPrestador extends AppCompatActivity {

    Transicao transicao = new Transicao();
    ArrayList<String> s = new ArrayList<String>();

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private AlertDialog alerta;
    private FirebaseAuth autenticacao;
    private ProgressDialog progress;
    private String ss;
    private boolean estado = false;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_prestador);
        Toolbar toolbar = findViewById(R.id.toolbar_servidor);
        setSupportActionBar(toolbar);

        // Crie o adaptador que retornará um fragmento para cada uma das três seções principais da atividade.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Configure o ViewPager com o adaptador de seções.
        mViewPager = (ViewPager) findViewById(R.id.container_servidor);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_servidor);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }



    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_ativo_inativo){

            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);

            if(estado!=true) {
                builder.setTitle(R.string.ficar_disponivel);
                builder.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        item.setIcon(R.drawable.bola_verde);
                        estado = true;
                    }
                });
                builder.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        item.setIcon(R.drawable.bola_vermelha);
                        estado = false;
                    }
                });
            }else{
                builder.setTitle(R.string.ficar_indisponivel);
                builder.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        item.setIcon(R.drawable.bola_vermelha);
                        estado = false;
                    }
                });
                builder.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        item.setIcon(R.drawable.bola_verde);
                        estado = true;
                    }
                });
            }

            alerta = builder.create();
            alerta.show();

        }
        if (id == R.id.action_chat) {
            transicao.transicao(MainPrestador.this, Chat.class);
            return true;
        }
        if (id == R.id.action_notificacao) {
            transicao.transicao(MainPrestador.this, Notificacao.class);
            return true;
        }
        if (id == R.id.action_entrar_contato) {
            transicao.transicao(MainPrestador.this, EntreEmContato.class);
            return true;
        }
        if (id == R.id.action_sobre) {
            transicao.transicao(MainPrestador.this, Sobre.class);
            return true;
        }
        if (id == R.id.action_termos_uso) {
            transicao.transicao(MainPrestador.this, TermosDeUso.class);
            return true;
        }
        if (id == R.id.action_sair) {


            //Cria o gerador do AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
            //define o titulo
            builder.setTitle(R.string.sainda_da_conta);
            //define um icone
            builder.setIcon(R.mipmap.ic_launcher_foreground);
            //define a mensagem
            builder.setMessage(R.string.deseja_sair_da_conta);
            //define um botão como positivo
            builder.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    dialogTempo(getString(R.string.saindo),getString(R.string.desconectando_da_sua_conta));
                    firebaseAuth.signOut();
                    startActivity(new Intent(getApplicationContext(), EscolhaLogin.class));
                }
            });
            //define um botão como negativo.
            builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                }
            });
            //cria o AlertDialog
            alerta = builder.create();
            //Exibe
            alerta.show();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    TabPesquisaPrestador tabPesquisaPrestador = new TabPesquisaPrestador();
                    return tabPesquisaPrestador;
                case 1:
                    TabHistoricoPrestador tabHistoricoPrestador = new TabHistoricoPrestador();
                    return tabHistoricoPrestador;
                case 2:
                    TabPerfilPrestador tabPerfilPrestador = new TabPerfilPrestador();
                    position = 0;
                    return tabPerfilPrestador;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

    private void dialogTempo(String title, String message){
        progress = new ProgressDialog(this);
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
        pdCanceller.postDelayed(progressRunnable, 4000);

        progress.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                progress.dismiss();
            }
        });
    }

}
