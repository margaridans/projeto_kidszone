package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class Categoria {
    public static String NAME_TABLE = "tblCategoria", NOME_CAT = "categoria_name", ID_CAT = "id_categoria";
    private int id_categoria;
    private String categoria_name;

    public Categoria(int id_categoria, String categoria_name) {
        this.id_categoria = id_categoria;
        this.categoria_name = categoria_name;
    }

    public Categoria(String categoria_name) {
        //id_categoria=-1;
        this.categoria_name = categoria_name;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return categoria_name;
    }

    public void setNome(String categoria_name) {
        this.categoria_name = categoria_name;
    }

    public boolean addCategoria(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + "(" + NOME_CAT + ")VALUES ('" + categoria_name + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deleteCategoria(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_CAT + "=" + id_categoria + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updateCategoria(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + "SET " + NOME_CAT + " = '" + categoria_name + "' WHERE " + ID_CAT + "=" + id_categoria + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Categoria getCategoriaById(SQLiteDatabase db, int id_categoria) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_CAT + "=" + id_categoria + ";", null);
            Categoria categoria = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                categoria = new Categoria(c.getInt(0), c.getString(1));
            }

            return categoria;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

}
