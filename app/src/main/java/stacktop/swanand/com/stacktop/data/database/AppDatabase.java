package stacktop.swanand.com.stacktop.data.database;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import stacktop.swanand.com.stacktop.datamodel.Item;

@Database(entities = {Item.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "stackdb";
    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }

    // The associated DAOs for the database
    public abstract ItemDao itemDao();
}
