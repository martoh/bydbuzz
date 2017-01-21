package akitasoft.bydbuzz.com.bydbuzz.seat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import akitasoft.bydbuzz.com.bydbuzz.R;
import akitasoft.bydbuzz.com.bydbuzz.async.AsyncBidder;
import akitasoft.bydbuzz.com.bydbuzz.auctions.AuctionActivity;
import akitasoft.bydbuzz.com.bydbuzz.data.DbHelper;

public class SeatActivity extends AppCompatActivity {

    public static DbHelper dbHelper;
    public static SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        dbHelper = DbHelper.getsInstance(this);
        sql = dbHelper.sql;

        final Button button = (Button) findViewById(R.id.btn_bid_now);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AuctionActivity.class);
//                intent.putExtra("sampleText", "thereisnocowlevel");
                startActivity(intent);
            }
        });

        AsyncBidder asyncBidder = new AsyncBidder(this);
        asyncBidder.execute();

        final EditText et_bid_history = (EditText) findViewById(R.id.et_bid_history);
        et_bid_history.append("thereisnocowlevel\n");
        et_bid_history.append("thereisnocowlevel");

    }
}
