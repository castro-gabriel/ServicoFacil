package servicofacil.gabriel.servicofacil.Telas;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import servicofacil.gabriel.servicofacil.R;


public class SplashSaindo extends AppCompatActivity {


    private ImageView gif;
    private ProgressDialog progress;

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_saindo);

        //gif = findViewById(R.id.gif);
        //Código para gif
        //Glide.with(SplashSaindo.this)
        //        .load(R.drawable.gif) // aqui é teu gif
        //        .asGif()
        //        .into(gif);

        dialogTempo("Saindo","Desconectando da conta");

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(SplashSaindo.this, EscolhaLogin.class);
                startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);





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
