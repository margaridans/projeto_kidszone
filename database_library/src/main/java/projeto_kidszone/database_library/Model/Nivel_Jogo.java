package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by mjtm on 19-12-2016.
 */

public class Nivel_Jogo {
    public static String NAME_TABLE="nivelJogo", ID="id", NOME="nome", PONTUACAO="pontuacao";
    private int id;
    private String nome;
    private int pontuacao;

    public Nivel_Jogo(String nome, int pontuacao) {
        id = -1;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public Nivel_Jogo(int id, String nome, int pontuacao) {
        this(nome, pontuacao);
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean addNivelJogo(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + " (" + NOME + ", " + PONTUACAO + ") VALUES ('" +  nome +"', " + pontuacao + ");");
            //db.close();
            return true;
        } catch(SQLException ex) {
            db.close();
            throw ex;
        }
    }

    public boolean deleteNivelJogo(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + " WHERE " + ID + " = '" + id + "';");
            //db.close();
            return true;
        } catch(SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updateNivelJogo(SQLiteDatabase db) {
        try {
            String sql = "UPDATE " + NAME_TABLE + " SET " + NOME + " = '" + nome + "', " + PONTUACAO + " = " + pontuacao + " WHERE "+ ID +" = " + id + ";";
            db.execSQL(sql);
            //db.close();
            return true;
        }catch(SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Nivel_Jogo getNivel_Jogo_By_Id(SQLiteDatabase db, int id){

        try{
            Cursor c = db.rawQuery("SELECT * FROM "+NAME_TABLE+" WHERE "+ ID + " = " + id, null);
            Nivel_Jogo nivel = null;
            if(c != null && c.moveToFirst()){
                //c.getString(1);
                nivel = new Nivel_Jogo(c.getInt(0), c.getString(1), c.getInt(2));
            }
            return nivel;
        }catch (SQLException ex){
            db.close();
            return null;
        }
    }

    public static int getIdNivelJogoByNome(String nome, SQLiteDatabase db){

        try{
            Cursor c = db.rawQuery("SELECT " + ID + " FROM "+ NAME_TABLE +" WHERE "+ NOME + " = '" + nome + "';", null);
            if(c != null && c.moveToFirst()){
                return c.getInt(0);
            }
            return -1;
        }catch (SQLException ex){
            db.close();
            return -1;
        }
    }

    public static ArrayList<Nivel_Jogo> getNiveisJogo(SQLiteDatabase db, ArrayList<Nivel_Jogo> niveis) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE, null);
            if(c != null && c.moveToFirst()) {
                do {
                    niveis.add((new Nivel_Jogo(c.getInt(0), c.getString(1), c.getInt(2))));
                }while(c.moveToNext());
            }
            //db.close();
            return niveis;
        } catch(SQLException ex) {
            db.close();
            return null;
        }
    }
}
