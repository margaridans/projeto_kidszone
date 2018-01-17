package projeto_kidszone.database_library.Model;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class Pergunta {
    public static String NAME_TABLE = "tblPergunta", ID_PERG = "id_pergunta", NOME_PERG = "pergunta_nome",
            ID_CAT = "id_categoria", ID_DIFIC = "id_dificuldade", RESP1 = "resposta1", RESP2 = "resposta2", RESP3 = "resposta3",
            RESP4 = "resposta4", RESP_CERTA = "resposta_certa";
    private int id_pergunta;
    private String pergunta_name;
    private int id_categoria;
    private int id_dificuldade;
    private String resposta1;
    private String resposta2;
    private String resposta3;
    private String resposta4;
    private String resposta_certa;

    public Pergunta(String pergunta_name) {
        this.pergunta_name=pergunta_name;
    }

    public Pergunta( String resposta1, String resposta2, String resposta3, String resposta4, String resposta_certa) {
        this.pergunta_name = pergunta_name;
        this.id_categoria = id_categoria;
        this.id_dificuldade = id_dificuldade;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resposta_certa = resposta_certa;
    }

    public Pergunta(int id_pergunta, String pergunta_name, int id_categoria, int id_dificuldade, String resposta1, String resposta2, String resposta3, String resposta4, String resposta_certa) {
        this.id_pergunta = id_pergunta;
        this.pergunta_name = pergunta_name;
        this.id_categoria = id_categoria;
        this.id_dificuldade = id_dificuldade;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.resposta_certa = resposta_certa;
    }



    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getPergunta_name() {
        return pergunta_name;
    }

    public void setPergunta_name(String pergunta_name) {
        this.pergunta_name = pergunta_name;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_dificuldade() {
        return id_dificuldade;
    }

    public void setId_dificuldade(int id_dificuldade) {
        this.id_dificuldade = id_dificuldade;
    }

    public String getResposta1() {
        return resposta1;
    }

    public void setResposta1(String resposta1) {
        this.resposta1 = resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public void setResposta2(String resposta2) {
        this.resposta2 = resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public void setResposta3(String resposta3) {
        this.resposta3 = resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public void setResposta4(String resposta4) {
        this.resposta4 = resposta4;
    }

    public String getResposta_certa() {
        return resposta_certa;
    }

    public void setResposta_certa(String resposta_certa) {
        this.resposta_certa = resposta_certa;
    }


    public boolean addPergunta(SQLiteDatabase db) {
        try {
            db.execSQL("INSERT INTO " + NAME_TABLE + " (" + ID_PERG + ", " + NOME_PERG + ", " + ID_CAT + ", " + ID_DIFIC + ", " + RESP1 + ", " +
                    RESP2 + ", " + RESP3 + ", " + RESP4 + ", " + RESP_CERTA + ") VALUES (" + id_pergunta + ", '" + pergunta_name + "', " + id_categoria + ", " + id_dificuldade + ", '" + resposta1 + "', '" + resposta2 + "', '" + resposta3 + "', '" + resposta4 + "', '" + resposta_certa + "');");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean deletePergunta(SQLiteDatabase db) {
        try {
            db.execSQL("DELETE FROM " + NAME_TABLE + "WHERE " + ID_PERG + "=" + id_pergunta + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public boolean updatePergunta(SQLiteDatabase db) {
        try {
            db.execSQL("UPDATE " + NAME_TABLE + " SET " + NOME_PERG + " = '" + pergunta_name + "', "
                    + ID_CAT + " = " + id_categoria + ", " + ID_DIFIC + " = " + id_dificuldade + ", " + RESP1 + " = '" + resposta1 + "', " + RESP2
                    + " = '" + resposta2 + "', " + RESP3 + " = '" + resposta3 + "'," + RESP4 + " = '" + resposta4 + "'," + RESP_CERTA + " = '" + resposta_certa + "' WHERE " + ID_PERG + " = " + id_pergunta + ";");
            return true;
        } catch (SQLException ex) {
            db.close();
            return false;
        }
    }

    public static Pergunta getPerguntaById(SQLiteDatabase db, int id_pergunta) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + ID_PERG + "=" + id_pergunta + ";", null);
            Pergunta pergunta = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                pergunta = new Pergunta(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8));
            }
            return pergunta;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

    public static String getPerguntaByIdCatg(SQLiteDatabase db, int id_categoria) {
        try {
            Cursor c = db.rawQuery("SELECT " + NOME_PERG + " FROM " + NAME_TABLE + " WHERE " + ID_CAT + "= " + id_categoria + ";", null);
            String pergunta = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                pergunta = c.getString(0);
            }
            return pergunta;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

    public static String getRespostasByIdCatg(SQLiteDatabase db, int id_categoria) {

        try {

            Cursor c = db.rawQuery("SELECT " + RESP1 + ", " + RESP2 + ", " + RESP3 + ", " + RESP4 + ", " + RESP_CERTA + " FROM " + NAME_TABLE + "WHERE " + ID_CAT + "=" + id_categoria + ";", null);
            String pergunta = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                pergunta = c.getString(0);
            }
            return pergunta;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

    public static ArrayList<Pergunta> getPerguntas(SQLiteDatabase db, ArrayList<Pergunta> perguntasList) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE, null);

            if (c != null && c.moveToFirst()) {
                do {
                    perguntasList.add(new Pergunta(c.getInt(0), c.getString(1), c.getInt(2), c.getInt(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8)));
                } while (c.moveToNext());
            }

            return perguntasList;
        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

}
