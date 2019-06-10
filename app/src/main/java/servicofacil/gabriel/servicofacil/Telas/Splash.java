package servicofacil.gabriel.servicofacil.Telas;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import servicofacil.gabriel.servicofacil.R;


public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //getSupportActionBar().hide();


        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // E inicia a activity principal
                Intent i = new Intent(Splash.this, EscolhaLogin.class);

                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat
                        .makeCustomAnimation(getApplicationContext(), R.anim.find_in, R.anim.mv_direita);
                ActivityCompat.startActivity(Splash.this, i, activityOptionsCompat.toBundle());

                //startActivity(i);

                // Fecha esta activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
