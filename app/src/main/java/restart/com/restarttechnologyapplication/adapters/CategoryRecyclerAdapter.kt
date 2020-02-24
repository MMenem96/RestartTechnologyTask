package restart.com.restarttechnologyapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import restart.com.restarttechnologyapplication.R
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot


class CategoryRecyclerAdapter(private var categoryType: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //Category type: 1--> HotSpots, 2--> Events, 3--> Attractions

    private var attractionList: MutableList<Attraction>? = ArrayList()
    private var hotSpotList: MutableList<HotSpot>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder(

            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_category_item,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        if (categoryType == 1) {
            return hotSpotList?.size ?: 0
        } else if (categoryType == 3) {
            return attractionList?.size ?: 0

        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (categoryType == 1) {
            (holder as CategoryViewHolder).onBind(hotSpotList?.get(position))
        } else if (categoryType == 3) {
            (holder as CategoryViewHolder).onBind(attractionList?.get(position))
        }
    }

    fun setAttractionList(attractionList: MutableList<Attraction>?) {
        this.attractionList = attractionList
        notifyDataSetChanged()
    }

    fun setHotSpotList(hotSpotList: MutableList<HotSpot>?) {
        this.hotSpotList = hotSpotList
        notifyDataSetChanged()
    }

}