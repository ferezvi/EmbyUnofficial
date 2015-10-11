package ioembyunofficial.github.httpferezvi.embyunofficial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by fernando on 10/10/15.
 */
public class DataBaseManager {
    public static final String TABLE_NAME = "settings";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String VALUE = "value";
    private DBHelper helper;
    private SQLiteDatabase db;

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key autoincrement,"
            + NAME + " text not null,"
            + VALUE + " text);";

    public DataBaseManager(Context context) {

        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String nombre, String value) {
        ContentValues valores = new ContentValues();
        valores.put(NAME, nombre);
        valores.put(VALUE, value);
        return valores;
    }

    public void insert(String name, String value) {
        //bd.insert(TABLA, NullColumnHack, ContentValues);
        db.insert(TABLE_NAME, null, generarContentValues(name, value));
    }

    public void delete(String name) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where)
        db.delete(TABLE_NAME, NAME + "=?", new String[]{name});
    }

    public void deleterMultiple(String nom1, String nom2) {
        db.delete(TABLE_NAME, NAME + "IN (?,?)", new String[]{nom1,nom2});
    }

    public void updateValue(String name, String newValue) {
        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, generarContentValues(name, newValue), NAME + "=?", new String[]{name});
    }
    public Cursor loadSettings() {
        String[] columnas = new String[]{ID, NAME,VALUE};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }
    public Cursor getValue(String name) {
        String[] columnas = new String[]{ID,NAME,VALUE};
        return db.query(TABLE_NAME,columnas,NAME + "=?",new String[]{name},null,null,null);
    }

}
