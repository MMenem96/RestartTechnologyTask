package restart.com.restarttechnologyapplication.models


import com.google.gson.annotations.SerializedName

data class Feature(
    @SerializedName("arabic_name")
    val arabicName: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)