package restart.com.restarttechnologyapplication.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "attractions")
data class Attraction(
    @Ignore
    @SerializedName("categories")
    var categories: List<Category>,
    @PrimaryKey
    @SerializedName("id")
    var id: Int,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String,
    @Ignore
    @SerializedName("photos")
    var photos: List<String>,
    @ColumnInfo(name = "timestamp")
    @SerializedName("timeStamp")
    var timeStamp: Int,
    @ColumnInfo(name = "photo")
    var photo: String,
    @ColumnInfo(name = "categoryName")
    var categoryName: String

) {
    constructor() : this(
        listOf(), 0,
        "", listOf(),
        0, "", ""
    )
}