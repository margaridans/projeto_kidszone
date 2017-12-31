package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


public class Dicas{

    public static String NAME_TABLE = "tblDicas", ID_DICAS = "id_dica", NOME_DICA = "dica_name";
    private int id_dica;
    private String dica_name;

    public  Dicas(int id_dica, String dica_name) {
        this.id_dica = id_dica;
        this.dica_name = dica_name;
    }

    public Dicas(String dica_name) {
        this.dica_name = dica_name;
    }

    public int getId_dica() {
        return id_dica;
    }

    public void setId_dica(int id_dica) {
        this.id_dica = id_dica;
    }

    public String getDica_name() {
        return dica_name;
    }

    public void setDica_name(String dica_name) {
        this.dica_name = dica_name;
    }

    public boolean addDica(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + NOME_DICA + ")VALUES ('" + dica_name + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deleteDica(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_DICAS + "=" + id_dica + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updateDica(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + NOME_DICA + " = '" + dica_name + "' WHERE " + ID_DICAS + "=" + id_dica + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }


    public static Dicas getDicasById(SQLiteDatabase db, int id_dica) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_DICAS + "=" + id_dica + ";", null);
            Dicas dica = null;

            if (c != null && c.moveToFirst()) {
                dica = new Dicas(c.getInt(0), c.getString(1));
            }

            return dica;
        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

    public static ArrayList<Dicas> getDicas(SQLiteDatabase db, ArrayList<Dicas> dicasList) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE, null);

            if (c != null && c.moveToFirst()) {
                do {
                    dicasList.add(new Dicas(c.getInt(0), c.getString(1)));
                } while (c.moveToNext());
            }

            return dicasList;
        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }
}
