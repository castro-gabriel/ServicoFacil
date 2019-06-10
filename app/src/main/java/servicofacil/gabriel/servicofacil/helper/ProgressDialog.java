package servicofacil.gabriel.servicofacil.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;

import servicofacil.gabriel.servicofacil.R;

public class ProgressDialog {

    private android.app.ProgressDialog progress;

    public ProgressDialog(Context context, String title, String message){
        dialogTempo(context, title, message);
    }
    public void dialogTempo(Context context, String title, String message){
        progress = new android.app.ProgressDialog(context, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
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
