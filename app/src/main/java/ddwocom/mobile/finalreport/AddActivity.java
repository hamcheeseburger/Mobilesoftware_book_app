package ddwocom.mobile.finalreport;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText et_name;
    EditText et_author;
    EditText et_publisher;
    EditText et_rate;
    EditText et_comment;

    DBManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        manager = new DBManager(this);

        et_name = findViewById(R.id.et_add_name);
        et_author = findViewById(R.id.et_add_author);
        et_publisher = findViewById(R.id.et_add_publisher);
        et_rate = findViewById(R.id.et_add_rate);
        et_comment = findViewById(R.id.et_add_comment);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_add:
                BookInfo book = new BookInfo();
                book.setName(et_name.getText().toString());
                book.setAuthor(et_author.getText().toString());
                book.setPublisher(et_publisher.getText().toString());
                book.setRate(et_rate.getText().toString());
                book.setComment(et_comment.getText().toString());

                manager.addBook(book);
                Toast.makeText(this, "도서가 추가되었습니다", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                break;
            case R.id.btn_cancel:
                Toast.makeText(this, "추가 취소", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
