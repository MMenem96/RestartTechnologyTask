package restart.com.restarttechnologyapplication.presistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot


@Database(entities = [Attraction::class, HotSpot::class], version = 1)
abstract class AreaCategoriesDB : RoomDatabase() {
    companion object {
        val DATABASE_NAME = "recipes_db"
        lateinit var instance: AreaCategoriesDB

        fun getRecipeDatabase(context: Context): AreaCategoriesDB {
            synchronized(AreaCategoriesDB::class) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AreaCategoriesDB::class.java, DATABASE_NAME
                )
                    .build()


            }
            return instance

        }
    }

    abstract fun getRecipeDao(): AreaCategoriesDao
}