package restart.com.restarttechnologyapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot
import restart.com.restarttechnologyapplication.repo.AreaCategoriesRepo
import restart.com.restarttechnologyapplication.util.Resource

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    //    var isFetchingData = false
//    private var cancelRequest = false
    init {
        AreaCategoriesRepo.context = application.applicationContext
    }


    fun getAttractions(): LiveData<Resource<MutableList<Attraction>>> {
        return AreaCategoriesRepo.fetchAreaAttractions()
    }

    fun getHotSpots(): LiveData<Resource<MutableList<HotSpot>>> {
        return AreaCategoriesRepo.fetchAreaHotSpots()
    }
}