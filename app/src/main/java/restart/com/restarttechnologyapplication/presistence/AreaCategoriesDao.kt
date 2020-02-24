package restart.com.restarttechnologyapplication.presistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot

@Dao
interface AreaCategoriesDao {

    //Insert HotSpots with replacing existing ones
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAreaHotSpot(hotSpots: List<HotSpot>)

//    //Insert Events with replacing existing ones
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAreaEvents(events: List<Any>)

    //Insert Attractions with replacing existing ones
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAreaAttractions(attractions: List<Attraction>)


    //Get Hotspot
    @Query("SELECT * FROM hotpots")
    fun getHotSpots(): LiveData<MutableList<HotSpot>>

    //Get Attractions
    @Query("SELECT * FROM attractions")
    fun getAttraction(): LiveData<MutableList<Attraction>>

}