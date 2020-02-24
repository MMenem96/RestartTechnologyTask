package restart.com.restarttechnologyapplication.models


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")
    val id: Int,
    @SerializedName("lat")
    val lat: Any,
    @SerializedName("lng")
    val lng: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("zoom")
    val zoom: Any
)