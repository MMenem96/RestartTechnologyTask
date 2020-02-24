package restart.com.restarttechnologyapplication.models


import com.google.gson.annotations.SerializedName

data class CityId(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lat")
    val lat: Any,
    @SerializedName("lng")
    val lng: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("zoom")
    val zoom: Any
)