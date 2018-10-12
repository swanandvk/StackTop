package stacktop.swanand.com.stacktop.data.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import stacktop.swanand.com.stacktop.datamodel.Item;

@Dao
public interface ItemDao {


    @Query("SELECT * FROM questions")
    List<Item> getAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void bulkInsert(List<Item> items);
}
