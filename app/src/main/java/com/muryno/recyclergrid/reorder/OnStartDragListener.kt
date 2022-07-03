package com.muryno.recyclergrid.reorder

import androidx.recyclerview.widget.RecyclerView

interface OnStartDragListener<T> {

    fun onStartDrag(viewHolder: RecyclerView.ViewHolder?)

    fun onItemSelected( item: T)

    fun onDragComplete(item: T)
}