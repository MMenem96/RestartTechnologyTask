package restart.com.restarttechnologyapplication.models


import com.google.gson.annotations.SerializedName


data class Category(
    @SerializedName("ar_name")
    val arName: Any,
    @SerializedName("cover_image_url")
    val coverImageUrl: String,
    @SerializedName("icon_image_url")
    val iconImageUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)