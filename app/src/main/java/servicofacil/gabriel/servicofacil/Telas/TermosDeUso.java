package servicofacil.gabriel.servicofacil.Telas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import servicofacil.gabriel.servicofacil.R;


public class TermosDeUso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termos_de_uso);


    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.mv_esquerda, R.anim.find_out);
    }
}
