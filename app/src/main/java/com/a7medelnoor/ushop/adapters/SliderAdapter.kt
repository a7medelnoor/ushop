package com.a7medelnoor.ushop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.data.model.dto.ImageSlider
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter : SliderViewAdapter<SliderAdapter.SliderViewHolder>() {
    private lateinit var imageSlider: ImageSlider
    private var mSliderItem = ArrayList<String>()

    fun renewItem(sliderItems: ArrayList<String>) {
        mSliderItem = sliderItems
        notifyDataSetChanged()
    }

    fun addItem(item: String) {
        mSliderItem.add(item)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mSliderItem.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val inflate: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.slider_layout, null)
        return SliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        imageSlider = ImageSlider(position.toString())
        if (viewHolder != null) {
            Glide.with(viewHolder.itemView)
                .load(mSliderItem[position])
                .fitCenter()
                .into(viewHolder.imageView)
        }

    }

    inner class SliderViewHolder(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_silder_layout)
    }
}


