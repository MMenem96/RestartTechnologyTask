package restart.com.restarttechnologyapplication.requests

import androidx.lifecycle.LiveData
import restart.com.restarttechnologyapplication.requests.responses.ApiResponse
import restart.com.restarttechnologyapplication.requests.responses.AreaCategoriesResponse
import retrofit2.http.GET

interface CategoriesApi {

    //Get all categories(Hot spots, events, and attractions)
    @GET("api/home")
    fun fetchCategories(): LiveData<ApiResponse<AreaCategoriesResponse>>
}