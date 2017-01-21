package akitasoft.bydbuzz.com.bydbuzz.data.dbLoad;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import akitasoft.bydbuzz.com.bydbuzz.data.contracts.AuctionContract;

/**
 * Created by marty on 1/18/2017.
 */

public class AuctionLoad {

    private SQLiteDatabase sql;

    public AuctionLoad(SQLiteDatabase sql) {
        this.sql = sql;
        load();
    }

    public void load() {
        // TODO: INSERT into table
        insert(1,1,"expire one");
//        insert(1,2,"expire two");
//        insert(1,3,"expire three");
//        insert(2,1,"expire one");
//        insert(2,2,"expire two");
//        insert(2,3,"expire three");
    }

    public long insert(Integer event_id, Integer seat_id, String expire) {
        ContentValues cv = new ContentValues();
        cv.put(AuctionContract.AuctionEntry.COLUMN_EVENT_ID, event_id);
        cv.put(AuctionContract.AuctionEntry.COLUMN_SEAT_ID, seat_id);
        cv.put(AuctionContract.AuctionEntry.COLUMN_EXPIRE, expire);
        return sql.insert(AuctionContract.AuctionEntry.TABLE_NAME, null, cv);
    }
}
