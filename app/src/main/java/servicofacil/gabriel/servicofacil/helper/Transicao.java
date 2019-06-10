package servicofacil.gabriel.servicofacil.helper;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import servicofacil.gabriel.servicofacil.R;

public class Transicao {

    //Metodo que faz a animacao de tranzicao das telas
    public void transicao(Context context, Class classeDestino){

        Intent i = new Intent(context, classeDestino);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat
                .makeCustomAnimation(context, R.anim.find_in, R.anim.mv_direita);
        ActivityCompat.startActivity(context, i, activityOptionsCompat.toBundle());

    }

}
