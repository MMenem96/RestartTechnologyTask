package restart.com.restarttechnologyapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class HomeActivity : AppCompatActivity() {
    var fabIsOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        fb_main_menu.onClick {
            if (fabIsOpen) {
                closeMenu(fb_map, tv_map_fb, 100)
                closeMenu(fb_attraction, tv_attractions_fb, 200)
                closeMenu(fb_events, tv_events_fb, 300)
                closeMenu(fb_hotspots, tv_hotspots_fb, 400)
            } else {
                openMenu(fb_hotspots, tv_hotspots_fb, 100)
                openMenu(fb_events, tv_events_fb, 200)
                openMenu(fb_attraction, tv_attractions_fb, 300)
                openMenu(fb_map, tv_map_fb, 400)
            }
        }
    }

    private fun closeMenu(fb: FloatingActionButton, tvFb: TextView, milliSec: Long) {
        fabIsOpen = false
        val handler = Handler()
        handler.postDelayed(Runnable {
            // Do something after 0.5s = 500ms
            fb.hide()
            tvFb.visibility = View.GONE
        }, milliSec)
    }

    private fun openMenu(fb: FloatingActionButton, tvFb: TextView, milliSec: Long) {
        fabIsOpen = true
        val handler = Handler()
        handler.postDelayed(Runnable {
            // Do something after 0.5s = 500ms
            fb.show()
            tvFb.visibility = View.VISIBLE
        }, milliSec)
    }


}
