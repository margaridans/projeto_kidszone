package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Pontuacao {
    public static String NAME_TABLE = "tblPontuacao", ID_PONT="id_pontuacao", PONTUACAO="pontuacao", USER="nome_user";
    private int id_pontuacao;
    private int pontuacao;
    private String nome_user;

    public Pontuacao(int id_pontuacao, int pontuacao, String nome_user) {
        this.id_pontuacao = id_pontuacao;
        this.pontuacao = pontuacao;
        this.nome_user = nome_user;
    }

    public Pontuacao(int pontuacao, String nome_user) {
        this.pontuacao = pontuacao;
        this.nome_user = nome_user;
    }

    public int getId_pontuacao() {
        return id_pontuacao;
    }

    public void setId_pontuamcao(int id_pontuacao) {
        this.id_pontuacao = id_pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }


    public boolean addPontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + PONTUACAO + ")VALUES ('" + pontuacao + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deletePontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_PONT + "=" + id_pontuacao + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updatePontuacao(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + PONTUACAO + " = '" + pontuacao + "' WHERE " + ID_PONT + "=" + id_pontuacao + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Pontuacao getPontuacaoByUser(SQLiteDatabase db, String nome) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM tblPontuacao WHERE nome_user = " + nome, null);
            Pontuacao pontuacao = null;
            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                pontuacao = new Pontuacao(c.getInt(0),c.getInt(1), c.getString(2));
            }

            return pontuacao;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }



}
