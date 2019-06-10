package servicofacil.gabriel.servicofacil.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ServidorDao extends SQLiteOpenHelper{

    private static String nomeBd = "usuariosServidores";
    private static int version = 1;

    public ServidorDao(Context context){
        super(context, nomeBd, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [servidor](\n" +
                    "[codigo] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "[nome] VARCHAR(60) NOT NULL,\n" +
                    "[cpf] VARCHAR(60) NOT NULL,\n" +
                    "[nascimento] VARCHAR(20) NOT NULL,\n" +
                    "[telefone] VARCHAR(20) NOT NULL,\n" +
                    "[email] VARCHAR(60) NOT NULL,\n" +
                    "[senha] VARCHAR(30) NOT NULL,\n" +
                    "[imagem] BLOB NOT NULL \n" +
                    ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String servidor = "DROP TABLE IF EXISTS servidor";
        sqLiteDatabase.execSQL(servidor);
    }

}
