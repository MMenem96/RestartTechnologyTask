package restart.com.restarttechnologyapplication.requests

import android.util.Log
import okhttp3.OkHttpClient
import restart.com.restarttechnologyapplication.util.Constants
import restart.com.restarttechnologyapplication.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceGenerator {

    private val okHttpClient by lazy {
        return@lazy OkHttpClient().newBuilder()
            //Establish connection time to the server
            .connectTimeout(Constants.NETWORK_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            //time between each byte read from the server
            .readTimeout(Constants.NETWORK_READ_TIMEOUT, TimeUnit.SECONDS)
            //time between each byte sent to the server
            .writeTimeout(Constants.NETWORK_WRITE_TIMEOUT, TimeUnit.SECONDS)
            //after the connection failed don't try again
            .retryOnConnectionFailure(false)
            .build()
    }

    val getCategoriesApi by lazy {
        Log.d("ServiceGenerator", "Creating retrofit client")
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(CategoriesApi::class.java)
    }


}