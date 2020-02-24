package restart.com.restarttechnologyapplication.repo

import android.content.Context
import androidx.lifecycle.LiveData
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot
import restart.com.restarttechnologyapplication.presistence.AreaCategoriesDB
import restart.com.restarttechnologyapplication.presistence.AreaCategoriesDao
import restart.com.restarttechnologyapplication.requests.ServiceGenerator
import restart.com.restarttechnologyapplication.requests.responses.ApiResponse
import restart.com.restarttechnologyapplication.requests.responses.AreaCategoriesResponse
import restart.com.restarttechnologyapplication.util.NetworkBoundResource
import restart.com.restarttechnologyapplication.util.Resource

object AreaCategoriesRepo {

    private val TAG = "AreaCategoriesRepo"
    lateinit var context: Context

    val areaCategoriesDao: AreaCategoriesDao by lazy {
        return@lazy AreaCategoriesDB.getRecipeDatabase(context).getRecipeDao()
    }


    fun fetchAreaAttractions(): LiveData<Resource<MutableList<Attraction>>> {
        return object : NetworkBoundResource<MutableList<Attraction>, AreaCategoriesResponse>() {
            override fun saveCallResult(item: AreaCategoriesResponse?) {

                if (item?.data != null) {
                    for (i in item.data.attractions.indices) {
                        item.data.attractions[i].timeStamp = 330
                        if (item.data.attractions[i].photos.isNotEmpty())
                            item.data.attractions[i].photo = item.data.attractions[i].photos[0]

                        if (item.data.attractions[i].categories.isNotEmpty())
                            item.data.attractions[i].categoryName =
                                item.data.attractions[i].categories[0].name
                    }
                    for (i in item.data.hotSpots.indices) {
                        item.data.hotSpots[i].timeStamp = 330
                        if (item.data.hotSpots[i].photos.isNotEmpty())
                            item.data.hotSpots[i].photo = item.data.hotSpots[i].photos[0]

                        if (item.data.hotSpots[i].categories.isNotEmpty())
                            item.data.hotSpots[i].categoryName =
                                item.data.hotSpots[i].categories[0].name
                    }

                    areaCategoriesDao.insertAreaAttractions(item.data.attractions)
                    areaCategoriesDao.insertAreaHotSpot(item.data.hotSpots)
                }
            }


            override fun createCall(): LiveData<ApiResponse<AreaCategoriesResponse>> {
                return ServiceGenerator.getCategoriesApi.fetchCategories()
            }

            override fun shouldFetch(data: MutableList<Attraction>?): Boolean {
                return true
            }

            override fun loadFromDb(): LiveData<MutableList<Attraction>> {
                return areaCategoriesDao.getAttraction()
            }

        }.asLiveData()
    }

    fun fetchAreaHotSpots(): LiveData<Resource<MutableList<HotSpot>>> {
        return object : NetworkBoundResource<MutableList<HotSpot>, AreaCategoriesResponse>() {
            override fun saveCallResult(item: AreaCategoriesResponse?) {

            }
            override fun createCall(): LiveData<ApiResponse<AreaCategoriesResponse>> {
                return ServiceGenerator.getCategoriesApi.fetchCategories()
            }

            override fun shouldFetch(data: MutableList<HotSpot>?): Boolean {
                return false
            }

            override fun loadFromDb(): LiveData<MutableList<HotSpot>> {
                return areaCategoriesDao.getHotSpots()
            }

        }.asLiveData()
    }
}