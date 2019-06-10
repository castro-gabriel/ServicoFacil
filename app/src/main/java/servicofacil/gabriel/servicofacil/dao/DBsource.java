package servicofacil.gabriel.servicofacil.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import servicofacil.gabriel.servicofacil.model.Prestador;
import servicofacil.gabriel.servicofacil.model.Funcao;
import servicofacil.gabriel.servicofacil.model.Solicitante;

public class DBsource extends SQLiteOpenHelper{

    // bd usado para a criação e utilização do banco de dados
    private SQLiteDatabase bd;

    private static final String name_bd = "servicofacil";
    private static final int version_bd = 1;

    // CONSTRUCTOR -------------------------------------------------------------------------------------------
    public DBsource(Context context){
        super(context, name_bd, null, version_bd);
    }

    // CONSTANTES PARA TABELAS -----------------------------------------------------------------------

    // TABELA FUNCAO ---------------------------------------------------------------------------------
    public static final String TB_FUNCAO = "tb_funcao";
    public static final String ID_FUNCAO = "id_funcao";
    public static final String TITULO_FUNCAO = "titulo_funcao";
    public static final String DESCRICAO_FUNCAO = "descricao_funcao";

    // TABELA PRESTADOR ---------------------------------------------------------------------------------
    public static final String TB_PRESTADOR = "tb_prestador";
    public static final String ID_PRESTADOR = "id_prestador";
    public static final String NOME_PRESTADOR = "nome_prestador";
    public static final String CPF_PRESTADOR = "cpf_prestador";
    public static final String EMAIL_PRESTADOR = "email_prestador";
    public static final String TEL_PRESTADOR = "tel_prestador";
    public static final String SENHA_PRESTADOR = "senha_prestador";
    public static final String NASC_PRESTADOR = "nasc_prestador";



    // TABELA CADASTRO PRESTADORES ---------------------------------------------------------------------------------
    public static final String TB_CADASTROPRESTADORES = "tb_cadastro_prestadores";
    public static final String ID_CADASTROPRESTADORES = "id_cadastro_prestadores";
    public static final String ID_PRESTADOR_FK = "id_prestador_fk";
    public static final String ID_FUNCAO_FK = "id_funcao_fk";
    public static final String AVALIACAO = "avaliacao";
    public static final String QTD_SERVICO = "qtd_servico";
    public static final String QTD_SUCESSO = "qtd_sucesso";
    public static final String TAXA_VISITA = "taxa_visita";

    // TABELA SOLICITANTE ---------------------------------------------------------------------------------
    public static final String TB_SOLICITANTE = "tb_solicitante";
    public static final String ID_SOLICITANTE = "id_solicitante";
    public static final String NOME_SOLICITANTE = "nome_solicitante";
    public static final String CPF_SOLICITANTE = "cpf_solicitante";
    public static final String EMAIL_SOLICITANTE = "email_solicitante";
    public static final String TEL_SOLICITANTE = "tel_solicitante";
    public static final String SENHA_SOLICITANTE = "senha_solicitante";


    // TABELA AVALIACAO ---------------------------------------------------------------------------------
    public static final String TB_AVALIACAO = "tb_avaliacao";
    public static final String ID_AVALIACAO = "id_avaliacao";
    public static final String ID_SOLICITANTE_FK = "id_solicitante_fk";
    public static final String NIVEL_AVALIACAO = "nivel_avaliacao";
    public static final String OBS_AVALIACAO = "obs_avaliacao";


    // TABELA SERVICO ---------------------------------------------------------------------------------
    public static final String TB_SERVICO = "tb_servico";
    public static final String ID_SERVICO = "id_servico";
    public static final String ID_SOLICITANTE_FKM = "id_solicitante_fkm";
    public static final String ID_CADASTROPRESTADORES_FK = "id_cadastroprestadores_fk";
    public static final String TAXADESLOCAMENTO_SERVICO = "taxadeslocamento_servico";
    public static final String DATA_SERVICO = "data_servico";
    public static final String ESTADO_SERVICO = "estado_servico";


    // TABELAS -------------------------------------------------------------------------------------------
    private static final String table_funcao =
            "CREATE TABLE IF NOT EXISTS " + TB_FUNCAO + "(" +
                    ID_FUNCAO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TITULO_FUNCAO + "titulo VARCHAR(30)," +
                    DESCRICAO_FUNCAO + "descricao VARCHAR(60))";

    private static final String table_prestador =
            "CREATE TABLE IF NOT EXISTS " + TB_PRESTADOR + "(" +
                    ID_PRESTADOR + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NOME_PRESTADOR + " VARCHAR," +
                    NASC_PRESTADOR + " VARCHAR," +
                    CPF_PRESTADOR + " VARCHAR," +
                    EMAIL_PRESTADOR + " VARCHAR," +
                    TEL_PRESTADOR + " VARCHAR," +
                    SENHA_PRESTADOR + " VARCHAR )";

    private static final String table_cadastro_prestadores =
            "CREATE TABLE IF NOT EXISTS " + TB_CADASTROPRESTADORES + "(" +
                    ID_CADASTROPRESTADORES + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_PRESTADOR_FK + " INT," +
                    ID_FUNCAO_FK + " INT," +
                    AVALIACAO + " VARCHAR," +
                    QTD_SERVICO + " INT," +
                    QTD_SUCESSO + " INT," +
                    TAXA_VISITA + " INT," +
                    "FOREIGN KEY (" + ID_FUNCAO_FK +") REFERENCES tb_funcao (" + ID_FUNCAO + ")," +
                    "FOREIGN KEY ("+ ID_PRESTADOR_FK +") REFERENCES tb_prestador ("+ ID_PRESTADOR +"))";

    private static final String table_solicitante =
            "CREATE TABLE IF NOT EXISTS " + TB_SOLICITANTE + "(" +
                    ID_SOLICITANTE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NOME_SOLICITANTE + " VARCHAR," +
                    CPF_SOLICITANTE + " VARCHAR," +
                    EMAIL_SOLICITANTE + " VARCHAR," +
                    TEL_SOLICITANTE + " VARCHAR," +
                    SENHA_SOLICITANTE + " VARCHAR )";

    private static final String table_avaliacao =
            "CREATE TABLE IF NOT EXISTS " + TB_AVALIACAO + "(" +
                    ID_AVALIACAO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_SOLICITANTE_FK + " INT," +
                    NIVEL_AVALIACAO + " VARCHAR," +
                    OBS_AVALIACAO + " VARCHAR," +
                    "FOREIGN KEY ("+ ID_SOLICITANTE_FK +") REFERENCES tb_solicitante ("+ ID_SOLICITANTE +"))";


    private static final String table_servico =
            "CREATE TABLE IF NOT EXISTS " + TB_SERVICO + "(" +
                    ID_SERVICO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ID_SOLICITANTE_FKM + " INT," +
                    ID_CADASTROPRESTADORES_FK + " INT," +
                    TAXADESLOCAMENTO_SERVICO + " INT," +
                    DATA_SERVICO + " DATETIME," +
                    ESTADO_SERVICO + " INT(3)," +
                    "FOREIGN KEY ("+ ID_SOLICITANTE_FKM +") REFERENCES tb_solicitante ("+ ID_SOLICITANTE +")," +
                    "FOREIGN KEY ("+ ID_CADASTROPRESTADORES_FK +") REFERENCES tb_cadastro_prestadores ("+ ID_CADASTROPRESTADORES +"))";



    // DDL -------------------------------------------------------------------------------------------

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_funcao);
        db.execSQL(table_prestador);
        db.execSQL(table_cadastro_prestadores);
        db.execSQL(table_solicitante);
        db.execSQL(table_avaliacao);
        db.execSQL(table_servico);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    // DML -----------------------------------------------------------------------------------------

    // MÉTODOS PRESTADOR ---------------------------------------------------------------------------
    public long inserirDadosPrestador(Prestador prestador){
        ContentValues valores;
        long result;

        bd = getWritableDatabase();
        valores = new ContentValues();

        valores.put(NOME_PRESTADOR, prestador.getNome());
        valores.put(CPF_PRESTADOR, prestador.getCpf());
        valores.put(EMAIL_PRESTADOR, prestador.getEmail());
        valores.put(TEL_PRESTADOR, prestador.getTelefone());
        valores.put(SENHA_PRESTADOR, prestador.getSenha());
        valores.put(NASC_PRESTADOR, prestador.getNascimento());

        result = bd.insert(DBsource.TB_PRESTADOR, null, valores);
        bd.close();
        return result;
    }

    public Prestador consultaDadosPrestador(String email){
        Prestador dados = null;
        String query = "SELECT * FROM " + TB_PRESTADOR + " WHERE " + EMAIL_PRESTADOR + " = " + "'" + email + "'";

        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursor = bd.rawQuery(query, null);

        if (cursor.moveToFirst()) { // verifica se a consulta retornou dados
            dados = new Prestador();
            // não precisa iterar, pois esse select só retorna um registro
            dados.setNome(cursor.getString(cursor.getColumnIndex(NOME_PRESTADOR)));
            dados.setCpf(cursor.getString(cursor.getColumnIndex(CPF_PRESTADOR)));
            dados.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL_PRESTADOR)));
            dados.setTelefone(cursor.getString(cursor.getColumnIndex(TEL_PRESTADOR)));
            dados.setSenha(cursor.getString(cursor.getColumnIndex(SENHA_PRESTADOR)));
            dados.setNascimento(cursor.getString(cursor.getColumnIndex(NASC_PRESTADOR)));
        }

        return dados;
    }

    public void removerDadosPrestador(){
        //Implementar método de remover usuário
    }

    public void addServicoPrestador(Funcao funcao, Prestador prestador){
    }

    // MÉTODOS SOLICITANTE -------------------------------------------------------------------------
    public long inserirDadosSolicitante(Solicitante solicitante){
        ContentValues valores;
        long result;

        bd = getWritableDatabase();
        valores = new ContentValues();

        valores.put(NOME_SOLICITANTE, solicitante.getNome());
        valores.put(CPF_SOLICITANTE, solicitante.getCpf());
        valores.put(EMAIL_SOLICITANTE, solicitante.getEmail());
        valores.put(TEL_SOLICITANTE, solicitante.getTelefone());
        valores.put(SENHA_SOLICITANTE, solicitante.getSenha());

        result = bd.insert(DBsource.TB_SOLICITANTE, null, valores);
        bd.close();
        return result;
    }

    public Solicitante consultaDadosSolicitante(String email){
        Solicitante dados = null;
        String query = "SELECT * FROM " + TB_SOLICITANTE + " WHERE " + EMAIL_SOLICITANTE + " = " + "'" + email + "'";

        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursor = bd.rawQuery(query, null);

        if (cursor.moveToFirst()) { // verifica se a consulta retornou dados
            dados = new Solicitante();
            // não precisa iterar, pois esse select só retorna um registro
            dados.setNome(cursor.getString(cursor.getColumnIndex(NOME_SOLICITANTE)));
            dados.setCpf(cursor.getString(cursor.getColumnIndex(CPF_SOLICITANTE)));
            dados.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL_SOLICITANTE)));
            dados.setTelefone(cursor.getString(cursor.getColumnIndex(TEL_SOLICITANTE)));
            dados.setSenha(cursor.getString(cursor.getColumnIndex(SENHA_SOLICITANTE)));
        }

        return dados;
    }


    public void removerDadosSolicitante(){
        //Implementar o método de remover usuario

    }


}