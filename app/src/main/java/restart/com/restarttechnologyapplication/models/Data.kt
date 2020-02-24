package restart.com.restarttechnologyapplication.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("attractions")
    val attractions: List<Attraction>,
    @SerializedName("events")
    val events: List<Any>,
    @SerializedName("hot_spots")
    val hotSpots: List<HotSpot>
)