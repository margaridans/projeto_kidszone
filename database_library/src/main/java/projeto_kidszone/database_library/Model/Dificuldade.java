package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import projeto_kidszone.database_library.Database.MyDbHelper;

public class Dificuldade {
    public static String NAME_TABLE = "tblDificuldade", ID_DIFIC = "id_dificuldade", NOME_DIFIC = "dificuldade_name", PONTUACAO_PERG = "pontuacao_perg";
    private int id_dificuldade;
    private String dificuldade_name;
    private int pontuacao_perg;

    public Dificuldade(int id_dificuldade, String dificuldade_name, int pontuacao_perg) {
        this.id_dificuldade = id_dificuldade;
        this.dificuldade_name = dificuldade_name;
        this.pontuacao_perg = pontuacao_perg;
    }

    public Dificuldade(String dificuldade_name, int pontuacao_perg) {
        this.dificuldade_name = dificuldade_name;
        this.pontuacao_perg = pontuacao_perg;
    }

    public Dificuldade(String dificuldade_name) {
        this.dificuldade_name = dificuldade_name;
    }

    public int getId_dificuldade() {
        return id_dificuldade;
    }

    public void setId_dificuldade(int id_dificuldade) {
        this.id_dificuldade = id_dificuldade;
    }

    public String getDificuldade_name() {
        return dificuldade_name;
    }

    public void setDificuldade_name(String dificuldade_name) {
        this.dificuldade_name = dificuldade_name;
    }

    public int getPontuacao_perg() {
        return pontuacao_perg;
    }

    public void setPontuacao_perg(int pontuacao_perg) {
        this.pontuacao_perg = pontuacao_perg;
    }

    public boolean addDificuldade(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + ID_DIFIC + ", " + NOME_DIFIC + ", " + PONTUACAO_PERG + ")VALUES ('" + id_dificuldade + "','" + dificuldade_name + "','" + pontuacao_perg + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deleteDificuldade(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_DIFIC + "=" + id_dificuldade + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updateDificuldade(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + ID_DIFIC + " = '" + id_dificuldade + ", " + NOME_DIFIC + " = " + dificuldade_name + "' WHERE " + ID_DIFIC + "=" + id_dificuldade + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public Dificuldade getDificuldadeById(SQLiteDatabase db, int id_dificuldade) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_DIFIC + "=" + id_dificuldade + ";", null);
            Dificuldade dificuldade = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                dificuldade = new Dificuldade(c.getInt(0), c.getString(1), c.getInt(2));
            }

            return dificuldade;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }
}
