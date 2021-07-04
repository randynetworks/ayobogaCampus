package randyramadhan.ayoboga.ayobogacampus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_JK = "JK";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "" +
                "CREATE TABLE " + STUDENT_TABLE +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_JK + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_ADDRESS + " TEXT)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(StudentModel studentModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, studentModel.getName());
        cv.put(COLUMN_JK, studentModel.getJk());
        cv.put(COLUMN_DATE, studentModel.getDate());
        cv.put(COLUMN_ADDRESS, studentModel.getAddress());

        long insert = db.insert(STUDENT_TABLE, null, cv);
        return insert != -1;
    }
}
