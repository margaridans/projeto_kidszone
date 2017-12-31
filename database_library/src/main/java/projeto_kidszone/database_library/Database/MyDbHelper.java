package projeto_kidszone.database_library.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import projeto_kidszone.database_library.Model.Categoria;
import projeto_kidszone.database_library.Model.Dicas;
import projeto_kidszone.database_library.Model.Dificuldade;
import projeto_kidszone.database_library.Model.Pergunta;
import projeto_kidszone.database_library.Model.Pontuacao;
import projeto_kidszone.database_library.Model.User;


public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kidszone";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Categoria.NAME_TABLE + "(" + Categoria.ID_CAT + " INTEGER PRIMARY KEY, " + Categoria.NOME_CAT + " VARCHAR(20) NOT NULL );");
        db.execSQL("CREATE TABLE " + Dicas.NAME_TABLE + "(" + Dicas.ID_DICAS + " INTEGER PRIMARY KEY, " + Dicas.NOME_DICA + " VARCHAR(20) NOT NULL );");
        db.execSQL("CREATE TABLE " + Dificuldade.NAME_TABLE + "(" + Dificuldade.ID_DIFIC + " INTEGER PRIMARY KEY, " + Dificuldade.NOME_DIFIC + " VARCHAR(20) NOT NULL, " + Dificuldade.PONTUACAO_PERG + " INTEGER NOT NULL );");
        db.execSQL("CREATE TABLE " + Pergunta.NAME_TABLE + "(" + Pergunta.ID_PERG + " INTEGER PRIMARY KEY, " + Pergunta.NOME_PERG + " VARCHAR(70) NOT NULL, " + Pergunta.ID_CAT + " INTEGER NOT NULL, " + Pergunta.ID_DIFIC + " INTEGER NOT NULL, " + Pergunta.RESP1 + " VARCHAR(25) NOT NULL, " + Pergunta.RESP2 + " VARCHAR(25) NOT NULL, " + Pergunta.RESP3 + " VARCHAR(25) NOT NULL, " + Pergunta.RESP4 + " VARCHAR(25) NOT NULL, " + Pergunta.RESP_CERTA + " VARCHAR(25) NOT NULL);");
        db.execSQL("CREATE TABLE " + Pontuacao.NAME_TABLE + "(" + Pontuacao.ID_PONT + " INTEGER PRIMARY KEY, " + Pontuacao.PONTUACAO + " INTEGER NOT NULL, " + Pontuacao.USER + " VARCHAR(25) NOT NULL );");
        db.execSQL("CREATE TABLE " + User.NAME_TABLE + "(" + User.ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + User.USERNAME + " VARCHAR(20) NOT NULL, " + User.PASS + " VARCHAR(15) NOT NULL );");

        criarPergunta(db);
    }


    public void criarPergunta(SQLiteDatabase db) {
        //Instanciar Categoria
        Categoria categoria_ingles = new Categoria(1, "Inglês");
        Categoria categoria_portugues = new Categoria(2, "Português");
        Categoria categoria_matematica = new Categoria(3, "Matemática");

        //Add categoria à bd
        categoria_ingles.addCategoria(db);
        categoria_portugues.addCategoria(db);
        categoria_matematica.addCategoria(db);

        //Instnciar Dicas
        Dicas dica1 = new Dicas(1, "Poupar água");
        Dicas dica2 = new Dicas(2, "Não passar mais de 2h seguidas a jogar computador");
        Dicas dica3 = new Dicas(3, "Reciclar");

        //Add dica à bd
        dica1.addDica(db);
        dica2.addDica(db);
        dica3.addDica(db);

        //Instanciar Dificuldade
        Dificuldade facil = new Dificuldade(1, "fácil", 2);
        Dificuldade medio = new Dificuldade(2, "médio", 5);
        Dificuldade dificil = new Dificuldade(3, "difícil", 8);

        //Add dificuldade à bd
        facil.addDificuldade(db);
        medio.addDificuldade(db);
        dificil.addDificuldade(db);

        //Instanciar Pergunta
        Pergunta pergunta1 = new Pergunta(1, "Qual o plural de batata?", 1, 1, "Tomatos", "Potatos", "Apples", "Potatoes", "Potatoes");
        Pergunta pergunta2 = new Pergunta(2, "Qual palavra abaixo não é um verbo?", 1, 2, "Feeding", "Amazing", "Going", "Looking", "Amazing");
        Pergunta pergunta3 = new Pergunta(3, "Qual membro da família é do sexo masculino?", 1, 3, "Granddaughter", "Grandfather", "Daughter", "Stepmother", "Grandfather");
        Pergunta pergunta4 = new Pergunta(4, "Qual o contrário de algumas?", 2, 1, "muitas", "todas", "nenhuma", "poucas", "todas");
        Pergunta pergunta5 = new Pergunta(5, "Qual é o plural de guarda-chuva?", 2, 2, "guarda-chuva", "guarda-chuvas", "guardas-chuvas", "guardas-chuva", "guarda-chuvas");
        Pergunta pergunta6 = new Pergunta(6, "Qual a palavra que está mal escrita?", 2, 3, "mexer", "chícara", "enxergar", "caprichar", "chícara");
        Pergunta pergunta7 = new Pergunta(7, "Qual destas expressões corresponde ao número mais pequeno?", 3, 1, "2/5", "5/10", "3/2", "1/7", "1/7");
        Pergunta pergunta8 = new Pergunta(8, "Qual dos números completa a seguinte sequência: 2 3 6 18 ", 3, 2, "22", "32", "64", "108", "108");
        Pergunta pergunta9 = new Pergunta(9, "Qual é 6b-10+2b=06", 3, 3, "41", "02", "06", "10", "02");

        //Add pergunta à bd
        pergunta1.addPergunta(db);
        pergunta2.addPergunta(db);
        pergunta3.addPergunta(db);
        pergunta4.addPergunta(db);
        pergunta5.addPergunta(db);
        pergunta6.addPergunta(db);
        pergunta7.addPergunta(db);
        pergunta8.addPergunta(db);
        pergunta9.addPergunta(db);

    }

    public long criarUtilizador(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        long result = db.insert("tblUser", null, cv);
        return result;
    }

    public String validarUtilizador(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM tblUser WHERE username=? AND password=?", new String[]{username,password});
        if(c.getCount()>0){
            return "OK";
        }
        return "ERRO";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tblcategoria");
        this.onCreate(db);
    }

}
