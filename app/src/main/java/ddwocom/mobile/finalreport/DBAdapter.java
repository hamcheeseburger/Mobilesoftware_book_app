package ddwocom.mobile.finalreport;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DBAdapter extends CursorAdapter {

    private Context context;
    private int layout;
    Cursor cursor;
    private LayoutInflater layoutInflater;

    public DBAdapter(Context context, int layout, Cursor c) {
        super(context, c);
        this.context = context;
        this.layout = layout;
        this.cursor = c;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView image = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.name);
        TextView author = view.findViewById(R.id.author);
        TextView publisher = view.findViewById(R.id.publisher);

        final int pos = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID));
        switch(pos){
            case 1:
                image.setImageResource(R.drawable.item01);
                break;
            case 2:
                image.setImageResource(R.drawable.item02);
                break;
            case 3:
                image.setImageResource(R.drawable.item03);
                break;
            case 4:
                image.setImageResource(R.drawable.item04);
                break;
            case 5:
                image.setImageResource(R.drawable.item05);
                break;
            case 6:
                image.setImageResource(R.drawable.item06);
                break;
            default:
                image.setImageResource(R.drawable.item00);
        }

        name.setText(cursor.getString(cursor.getColumnIndex("name")));
        author.setText(cursor.getString(cursor.getColumnIndex("author")));
        publisher.setText(cursor.getString(cursor.getColumnIndex("publisher")));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
       View v = layoutInflater.inflate(layout, parent, false);

        return v;
    }

    public Cursor getCursor(){
        return cursor;
    }
}
