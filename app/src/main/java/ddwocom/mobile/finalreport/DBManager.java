package ddwocom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    DBHelper helper = null;
    Cursor cursor = null;

    public DBManager(Context context){
        helper = new DBHelper(context);
    }

    //db의 모든내용 cursor로 반환
    public Cursor getAllBook(){
        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME, null);

        return cursor;
    }

    public BookInfo getPositionBook(int position){
        BookInfo book = new BookInfo();

        if(!cursor.moveToPosition(position)){
            return null;
        }

        int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID));
        switch(id){
            case 1:
                book.setImageId(R.drawable.item01);
                break;
            case 2:
                book.setImageId(R.drawable.item02);
                break;
            case 3:
                book.setImageId(R.drawable.item03);
                break;
            case 4:
                book.setImageId(R.drawable.item04);
                break;
            case 5:
                book.setImageId(R.drawable.item05);
                break;
            case 6:
                book.setImageId(R.drawable.item06);
                break;
            default:
                book.setImageId(R.drawable.item00);
        }

        book.setId(id);
        book.setName(cursor.getString(cursor.getColumnIndex(DBHelper.COL_NAME)));
        book.setAuthor(cursor.getString(cursor.getColumnIndex(DBHelper.COL_AUTHOR)));
        book.setPublisher(cursor.getString(cursor.getColumnIndex(DBHelper.COL_PUBLISHER)));
        book.setRate(cursor.getString(cursor.getColumnIndex(DBHelper.COL_RATE)));
        book.setComment(cursor.getString(cursor.getColumnIndex(DBHelper.COL_COMMENT)));

        return book;
    }

    public Cursor searchBook(int spinnerPosition, String value){
       SQLiteDatabase db = helper.getReadableDatabase();

       String selection = null;
       String [] selectArgs = new String[]{value};

        switch(spinnerPosition){
            case 0:
                     selection = DBHelper.COL_NAME + "=?";
                break;
            case 1:
                    selection = DBHelper.COL_AUTHOR + "=?";
                break;
            case 2:
                    selection = DBHelper.COL_PUBLISHER + "=?";
                break;
        }

        cursor = db.query(DBHelper.TABLE_NAME, null, selection, selectArgs, null, null, null, null);

        return cursor;
    }

    public void addBook(BookInfo book){
        ContentValues row = new ContentValues();
        row.put(DBHelper.COL_NAME, book.getName());
        row.put(DBHelper.COL_AUTHOR, book.getAuthor());
        row.put(DBHelper.COL_PUBLISHER, book.getPublisher());
        row.put(DBHelper.COL_RATE, book.getRate());
        row.put(DBHelper.COL_COMMENT, book.getComment());

        SQLiteDatabase db = helper.getWritableDatabase();

        db.insert(DBHelper.TABLE_NAME, null, row);

    }

    public void deleteBook(int position){
        SQLiteDatabase db = helper.getWritableDatabase();
        cursor.moveToPosition(position);

        String whereClause = DBHelper.COL_ID +"=?";
        String [] whereArgs = new String[]{String.valueOf(cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID)))};

        db.delete(DBHelper.TABLE_NAME, whereClause, whereArgs);

    }

    public boolean updateBook(BookInfo book) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(DBHelper.COL_NAME, book.getName());
        row.put(DBHelper.COL_AUTHOR, book.getAuthor());
        row.put(DBHelper.COL_PUBLISHER, book.getPublisher());
        row.put(DBHelper.COL_RATE, book.getRate());
        row.put(DBHelper.COL_COMMENT, book.getComment());

        String whereClause = DBHelper.COL_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(book.getId())};

        int result = db.update(DBHelper.TABLE_NAME, row, whereClause, whereArgs);

        helper.close();

        if (result > 0)
            return true;

        return false;
    }
}
