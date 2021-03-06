package akitasoft.bydbuzz.com.bydbuzz.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;
import akitasoft.bydbuzz.com.bydbuzz.data.dbHelper.BidDbHelper;
import akitasoft.bydbuzz.com.bydbuzz.venue.VenueActivity;

public class LoginActivity extends AppCompatActivity {

    private static DbHelper dbHelper;
    private static SQLiteDatabase sql;
    private BidDbHelper bidDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        dbHelper = DbHelper.getsInstance(this);
        sql = DbHelper.sql;
        bidDbHelper = new BidDbHelper(sql);
        bidDbHelper.truncate();

        final Button button = (Button) findViewById(R.id.btn_sign_in);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), VenueActivity.class);
//                intent.putExtra("sampleText", "thereisnocowlevel");
                startActivity(intent);
            }
        });
    }
}
