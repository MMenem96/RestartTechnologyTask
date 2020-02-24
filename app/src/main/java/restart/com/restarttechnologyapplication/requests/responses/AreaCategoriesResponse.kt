package restart.com.restarttechnologyapplication.requests.responses


import com.google.gson.annotations.SerializedName
import restart.com.restarttechnologyapplication.models.Data

data class AreaCategoriesResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status_code")
    val statusCode: Int
)