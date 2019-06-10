package servicofacil.gabriel.servicofacil.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import servicofacil.gabriel.servicofacil.model.Solicitante;


public class UsuarioDao extends SQLiteOpenHelper {

    private static String nomeBd = "usuarios";
    private static int version = 1;

    private static String tabela = "CREATE TABLE [usuario](\n" +
            "[codigo] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "[nome] VARCHAR(60) NOT NULL,\n" +
            "[telefone] VARCHAR(20) NOT NULL,\n" +
            "[email] VARCHAR(60) NOT NULL,\n" +
            "[senha] VARCHAR(30) NOT NULL,\n" +
            "[imagem] BLOB NOT NULL \n" +
            ")";

    public UsuarioDao(Context context){
        super(context, nomeBd, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String usuario = "DROP TABLE IF EXISTS usuario";
        sqLiteDatabase.execSQL(usuario);
    }

    public boolean inserirUsuario(Solicitante solicitante){

        try{
            Connection connection = DB.getConnection();

            String queryInserir = "INSERT INTO prestador VALUES (null, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(queryInserir);
            ps.setString(1, solicitante.getNome());
            ps.setString(2, solicitante.getCpf());
            ps.setString(3, solicitante.getEmail());
            ps.setString(4, solicitante.getTelefone());
            ps.setString(5, solicitante.getSenha());

            ps.executeQuery();

            connection.close();

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
