
package example.csci567.simpledbapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tejas on 3/8/2015.
 */
public class myDBHelper extends SQLiteOpenHelper
{

        Context ctx;
        public static final String DatabaseName = "DB8";
        public static final int DatabaseVersion = 1;
        private static final String TableName = "Mytable4";
        //database naming
    public myDBHelper(Context context)
        {
            super(context, DatabaseName, null, DatabaseVersion);
            this.ctx = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "(mycol VARCHAR primary key);" );
        }//create database
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TableName);
            onCreate(db);
        }//drop if exists

        public boolean toDatabase(String text)
        {
            try
            {
                SQLiteDatabase mydb5 = this.getWritableDatabase();
                Log.d("DB Insert : ", "INSERT OR REPLACE INTO " +
                        TableName + " (mycol) Values (" + text + ");");
                mydb5.execSQL("INSERT OR REPLACE INTO " + TableName + " (mycol) values (\"" + text + "\");");
                mydb5.close();
            }
            catch (SQLiteException e)
            {
                Log.d("ERROR", e.toString());
                return false;
            }

            return true;
        }

        public String fromDatabase()
        {
            String user_text = " ";
            try
            {
                SQLiteDatabase mydb4=this.getReadableDatabase();
                mydb4.execSQL("CREATE TABLE IF NOT EXISTS " + TableName + "(mycol VARCHAR Primary Key);");

                Cursor c =mydb4.rawQuery("SELECT *FROM " +TableName , null);
                if(c != null)
                {
                    if (c.moveToFirst())
                    {
                        do
                        {
                            String text = c.getString(0);
                            user_text = user_text + text + "\n";
                        }
                        while (c.moveToNext());
                    }
                }
                mydb4.close();
            }
            catch (SQLiteException se)
            {
                Log.d("DB Select Error: ", se.toString());
                return "";
            }
            return user_text;
        }

}
