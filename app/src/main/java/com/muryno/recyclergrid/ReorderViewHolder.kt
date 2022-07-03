package com.muryno.recyclergrid

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.core.view.MotionEventCompat
import androidx.recyclerview.widget.RecyclerView
import com.muryno.recyclergrid.reorder.OnStartDragListener
import kotlinx.android.synthetic.main.photo_layout.view.*


class ReorderViewHolder(
    holder: View, private val dragStartListener: OnStartDragListener<DataModel>? = null)
    : RecyclerView.ViewHolder(holder) {

    @SuppressLint("ClickableViewAccessibility")
    fun setData(data: DataModel) {

        itemView.apply {
            title.text = data.title
            desc.text = data.desc

            image.setImageResource(data.image)

            image?.setOnTouchListener { _, event ->
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    dragStartListener?.onStartDrag(this@ReorderViewHolder)
                }
                false
            }
            //click on the item
            setOnClickListener {
                dragStartListener?.onItemSelected(data)
            }
        }
    }



}