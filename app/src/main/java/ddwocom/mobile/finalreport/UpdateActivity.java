package ddwocom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    int position;
    ImageView imageView;
    EditText et_name;
    EditText et_author;
    EditText et_publisher;
    EditText et_rate;
    EditText et_comment;

    TextView tv_name;
    TextView tv_author;
    TextView tv_publisher;
    TextView tv_rate;
    TextView tv_comment;

    BookInfo book;
    Button btn_ok;
    Button btn_home;

    DBManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        manager = new DBManager(this);

        final Intent intent = getIntent();
        book = (BookInfo) intent.getSerializableExtra("book");
        position = intent.getIntExtra("position", 0);

        imageView = findViewById(R.id.update_imageView);
        et_name = findViewById(R.id.et_add_name);
        et_author = findViewById(R.id.et_update_author);
        et_publisher = findViewById(R.id.et_update_publisher);
        et_rate = findViewById(R.id.et_update_rate);
        et_comment = findViewById(R.id.et_update_comment);

        tv_name = findViewById(R.id.tv_update_name);
        tv_author = findViewById(R.id.tv_update_author);
        tv_publisher = findViewById(R.id.tv_update_publisher);
        tv_rate = findViewById(R.id.tv_update_rate);
        tv_comment = findViewById(R.id.tv_update_comment);

        imageView.setImageResource(book.getImageId());
        et_name.setHint(book.getName());
        et_author.setHint(book.getAuthor());
        et_publisher.setHint(book.getPublisher());
        et_rate.setHint(book.getRate());
        et_comment.setText(book.getComment());

        tv_name.setText(book.getName());
        tv_author.setText(book.getAuthor());
        tv_publisher.setText(book.getPublisher());
        tv_rate.setText(book.getRate());
        tv_comment.setText("'" + book.getComment() + "'");

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btn_ok = findViewById(R.id.btn_update_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                book.setName(et_name.getText().toString());
                book.setAuthor(et_author.getText().toString());
                book.setPublisher(et_publisher.getText().toString());
                book.setRate(et_rate.getText().toString());
                book.setComment(et_comment.getText().toString());

                if(book.getName().equals("")|| book.getAuthor().equals("") || book.getPublisher().equals("")||book.getRate().equals("")||book.getComment().equals("")){
                    Toast.makeText(UpdateActivity.this, "내용을 빠짐없이 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    if(manager.updateBook(book)) {
                        Toast.makeText(UpdateActivity.this, "업데이트 되었습니다", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK);
                    }
                    else {
                        Toast.makeText(UpdateActivity.this, "error : 업데이트 실패", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_CANCELED);
                    }
                    finish();
                }
            }
        });
    }

}
