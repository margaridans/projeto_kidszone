package projeto_kidszone.database_library.Model;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import projeto_kidszone.database_library.Database.MyDbHelper;

public class User {
    public static String NAME_TABLE = "tblUser", ID_USER = "id_user", USERNAME = "username", PASS = "password";
    private int id_user;
    private String username;
    private String password;

    public User(int id_user, String username, String password) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static User getUsersByUsername(SQLiteDatabase db, String username) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE + "WHERE " + USERNAME + "=" + username + ";", null);
            User user = null;

            //se o cursor não estiver vazio e se estiver na primeira linha
            if (c != null && c.moveToFirst()) {
                user = new User(c.getInt(0), c.getString(1), c.getString(2));
            }
            return user;

        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }

    public static ArrayList<User> getUsers(SQLiteDatabase db, ArrayList<User> usersList) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + NAME_TABLE, null);

            if (c != null && c.moveToFirst()) {
                do {
                    usersList.add(new User(c.getInt(0), c.getString(1), c.getString(2)));
                } while (c.moveToNext());
            }

            return usersList;
        } catch (SQLException ex) {
            db.close();
            return null;
        }
    }
}
