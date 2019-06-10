package servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import servicofacil.gabriel.servicofacil.R;
import servicofacil.gabriel.servicofacil.Telas.Chat;
import servicofacil.gabriel.servicofacil.Telas.EntreEmContato;
import servicofacil.gabriel.servicofacil.Telas.EscolhaLogin;
import servicofacil.gabriel.servicofacil.Telas.Notificacao;
import servicofacil.gabriel.servicofacil.Telas.Sobre;
import servicofacil.gabriel.servicofacil.Telas.TermosDeUso;
import servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.Tabs.TabHistoricoSolicitante;
import servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.Tabs.TabPerfilSolicitante;
import servicofacil.gabriel.servicofacil.Telas.UsuarioSolicitante.Tabs.TabPesquisaSolicitante;
import servicofacil.gabriel.servicofacil.helper.Transicao;


public class MainSolicitante extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private AlertDialog alerta;
    private ProgressDialog progress;
    private String servico;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    Transicao transicao = new Transicao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_solicitante);
        Toolbar toolbar = findViewById(R.id.toolbar_usuario);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container_usuario);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_usuario);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //Metodo do botao fab_pesquisar para pesquisa do servico


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_usuario, menu);

        return true;
    }


    public void setServico(String servico){
        this.servico = servico;
    }

    public String getServico(){
        return servico;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_chat) {
            transicao.transicao(MainSolicitante.this, Chat.class);
            return true;
        }
        if (id == R.id.action_notificacao) {
            transicao.transicao(MainSolicitante.this, Notificacao.class);
            return true;
        }
        if (id == R.id.action_entrar_contato) {
            transicao.transicao(MainSolicitante.this, EntreEmContato.class);
            return true;
        }
        if (id == R.id.action_sobre) {
            transicao.transicao(MainSolicitante.this, Sobre.class);
            return true;
        }
        if (id == R.id.action_termos_uso) {
            transicao.transicao(MainSolicitante.this, TermosDeUso.class);
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
                    TabPesquisaSolicitante tabPesquisaSolicitante = new TabPesquisaSolicitante();
                    return tabPesquisaSolicitante;
                case 1:
                    TabHistoricoSolicitante tabHistoricoSolicitante = new TabHistoricoSolicitante();
                    return tabHistoricoSolicitante;
                case 2:
                    TabPerfilSolicitante tabPerfilSolicitante = new TabPerfilSolicitante();
                    return tabPerfilSolicitante;
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
