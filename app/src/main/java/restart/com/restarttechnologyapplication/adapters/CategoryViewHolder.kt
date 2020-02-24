package restart.com.restarttechnologyapplication.adapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import restart.com.restarttechnologyapplication.R
import restart.com.restarttechnologyapplication.models.Attraction
import restart.com.restarttechnologyapplication.models.HotSpot

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val TAG = "CategoryViewHolder"


    var name: TextView = itemView.findViewById(R.id.tv_category_name)
    var title: TextView = itemView.findViewById(R.id.tv_category_title)
    var image: ImageView = itemView.findViewById(R.id.iv_Category_photo)


    fun onBind(category: Attraction?) {
        Log.d(TAG, "Name ${category?.name}")
        name.text = category?.name
        title.text = category?.categoryName
        Glide.with(itemView.context).load(category?.photo)
            .placeholder(R.drawable.ic_image_grey_24dp).into(image)

    }

    fun onBind(category: HotSpot?) {

        name.text = category?.name
        title.text = category?.categoryName
        Glide.with(itemView.context).load(category?.photo)
            .placeholder(R.drawable.ic_image_grey_24dp).into(image)

    }

}