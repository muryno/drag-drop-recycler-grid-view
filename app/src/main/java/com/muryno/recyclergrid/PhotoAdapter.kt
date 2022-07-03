package com.muryno.recyclergrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muryno.recyclergrid.reorder.ItemTouchHelperAdapter
import com.muryno.recyclergrid.reorder.OnStartDragListener
import java.util.*

class PhotoAdapter(val dragStartListener : OnStartDragListener<DataModel>) :   RecyclerView.Adapter<ReorderViewHolder>(),
    ItemTouchHelperAdapter {

    var dataList = emptyList<DataModel>()

    internal fun setDataList(dataList: List<DataModel>) {
        this.dataList = dataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReorderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
        return ReorderViewHolder(view,dragStartListener)
    }

    override fun onBindViewHolder(holder: ReorderViewHolder, position: Int) {
        holder.setData(dataList[position])
    }

    override fun getItemCount() = dataList.size

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(dataList, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onDragComplete(newPosition: Int) {
        dragStartListener.onDragComplete(dataList[newPosition])
    }

}