package restart.com.restarttechnologyapplication.util

class Constants {

    companion object {
        const val BASE_URL = "http://bellman-bd.restart-technology.com/"
        const val NETWORK_CONNECTION_TIMEOUT = 10L //10 SEC
        const val NETWORK_READ_TIMEOUT = 5L //10 SEC
        const val NETWORK_WRITE_TIMEOUT = 5L //10 SEC
        const val RECIPE_REFRESH_TIME = 60 * 60 * 24 * 1//1 days to refresh cache
    }
}