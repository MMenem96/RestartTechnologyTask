package restart.com.restarttechnologyapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import restart.com.restarttechnologyapplication.adapters.CategoryRecyclerAdapter
import restart.com.restarttechnologyapplication.util.Resource
import restart.com.restarttechnologyapplication.viewmodels.HomeViewModel


class HomeActivity : BaseActivity(), View.OnClickListener {
    private val TAG = "HomeActivity"


    private var fabIsOpen = false
    private lateinit var fbMap: LinearLayout
    private lateinit var fbAttraction: LinearLayout
    private lateinit var fbEvents: LinearLayout
    private lateinit var fbHotSpots: LinearLayout
    private lateinit var fbBellMan: FloatingActionButton
    private lateinit var scrollView: ScrollView

    private val homeViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(this.application)).get(
            HomeViewModel::class.java
        )
    }

    private lateinit var rvHotSpot: RecyclerView
    private lateinit var rvAttractions: RecyclerView
    private val hotSpotAdapter = CategoryRecyclerAdapter(1)
    private val attractionsAdapter = CategoryRecyclerAdapter(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Init all the views
        initViews()
        //Subscribe all the observers
        subscribeObservers()
    }

    private fun subscribeObservers() {
        homeViewModel.getAttractions().observe(this, Observer {
            if (it != null) {
                if (it.data != null && it.data.isNotEmpty()) {
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            Log.d(TAG, "onChanged: status :Loading ")
                            showParent(View.GONE)
                            showProgressBar(View.VISIBLE)

                        }
                        Resource.Status.ERROR -> {
                            showParent(View.VISIBLE)
                            showProgressBar(View.GONE)
                            toast(it.message.toString())
                            Log.d(TAG, "onChanged: status :ErrorMessage ${it.message}")
                            attractionsAdapter.setAttractionList(it.data)
                            rvAttractions.adapter = attractionsAdapter
                        }
                        Resource.Status.SUCCESS -> {
                            Log.d(TAG, "onChanged: status :Success ${it.status}")
                            showParent(View.VISIBLE)
                            showProgressBar(View.GONE)
                            attractionsAdapter.setAttractionList(it.data)
                            rvAttractions.adapter = attractionsAdapter

                        }
                    }
                }
            }

        })
        homeViewModel.getHotSpots().observe(this, Observer {
            hotSpotAdapter.setHotSpotList(it?.data)
            rvHotSpot.adapter = hotSpotAdapter

        })


    }


    private fun initViews() {

        //Linear layouts and floating buttons
        fbMap = find(R.id.layout_fb_map)
        fbAttraction = find(R.id.layout_fb_attraction)
        fbEvents = find(R.id.layout_fb_events)
        fbHotSpots = find(R.id.layout_fb_hotspots)
        fbBellMan = find(R.id.fb_main_menu)
        fbBellMan.setOnClickListener(this)

        scrollView = find(R.id.layout_body)

        //Recycler views and adapters
        rvAttractions = find(R.id.rv_attractions)
        rvHotSpot = find(R.id.rv_hotspots)


    }

    private fun closeMenu(fb: LinearLayout, milliSec: Long) {
        fabIsOpen = false
        val handler = Handler()
        handler.postDelayed(Runnable {
            // Hide
            fb.animate().alpha(0f)
        }, milliSec)
        if (milliSec.toInt() == 400)
            fbBellMan.isEnabled = true
    }

    private fun openMenu(fb: LinearLayout, milliSec: Long) {
        fabIsOpen = true
        val handler = Handler()
        handler.postDelayed(Runnable {
            // Show
            fb.animate().alpha(1f)

        }, milliSec)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fb_main_menu -> {
                if (fabIsOpen) {
                    fbBellMan.isEnabled = false
                    closeMenu(fbMap, 100)
                    closeMenu(fbAttraction, 200)
                    closeMenu(fbEvents, 300)
                    closeMenu(fbHotSpots, 400)
                } else {
                    openMenu(fbHotSpots, 100)
                    openMenu(fbEvents, 200)
                    openMenu(fbAttraction, 300)
                    openMenu(fbMap, 400)
                }
            }
        }
    }

    fun showParent(visibility: Int) {
        scrollView.visibility = visibility

    }

}
