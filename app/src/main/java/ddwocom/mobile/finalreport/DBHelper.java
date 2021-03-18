package ddwocom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    final static String TAG = "DBHelper";
    final static String DB_NAME = "books.db";
    public final static String TABLE_NAME = "book_table";
    public final static String COL_ID = "_id";
    public final static String COL_NAME = "name";
    public final static String COL_AUTHOR = "author";
    public final static String COL_PUBLISHER = "publisher";
    public final static String COL_RATE = "rate";
    public final static String COL_COMMENT = "comment";

    public DBHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, "
                + COL_NAME + " TEXT, " + COL_AUTHOR + " TEXT, " + COL_PUBLISHER + " TEXT, " +
               COL_RATE + " TEXT, " + COL_COMMENT + " TEXT);";

        Log.d(TAG, sql);
        db.execSQL(sql);
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'당신은 언제 노래가 되지', '허연', '문학과지성사', '9', '진솔하고 담백한 우리만의 이야기');" );
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'말하기를 말하기', '김하나', '콜라주', '8', '읽고 쓰고 듣고 말하는 사람 김하나의 말하기에 관한 부드러운 간섭');" );
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'이토록 친밀한 배신자', '마사 스타우트', '사계절', '10', '우리 주변의 연기자들에 대하여');" );
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'유원', '백온유', '창비', '7', '모순투성이 마음을 딛고 날아오르는 모든 이를 위한 성장소설');" );
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'사피엔스', '유발 하라리', '김영사', '8', '유인원에서 사이보그까지, 인간 역사의 대담하고 위대한 질문');" );
        db.execSQL("insert into " + TABLE_NAME + " values( null, " + "'이기적 유전자', '리처드 도킨스', '을유문화사', '6', '인간은 유전자의 생존기계이다');" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
