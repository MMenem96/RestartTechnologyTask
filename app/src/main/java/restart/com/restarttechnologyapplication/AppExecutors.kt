package restart.com.restarttechnologyapplication

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppExecutors {

    //Executor to make db operations on db (CRUD OP)
    val diskIO: Executor = Executors.newSingleThreadExecutor()

    //Executor to post data into UI (Send data from background to mainThread
    val mainThreadExecutor: Executor = MainThreadExecutor()


    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }

    }
}