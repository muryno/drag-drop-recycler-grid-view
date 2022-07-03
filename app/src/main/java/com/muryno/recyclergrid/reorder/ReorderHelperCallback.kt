package com.muryno.recyclergrid.reorder

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


class ReorderHelperCallback(private val adapter : ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END
        val swipeFlags = ItemTouchHelper.ACTION_STATE_DRAG
        return makeMovementFlags(
            dragFlags,
            swipeFlags
        )
    }

    override fun clearView(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) {    //called when you dropped the item
        super.clearView(recyclerView, viewHolder)
        adapter.onDragComplete(viewHolder.adapterPosition)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        source: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        // Notify the adapter of the move
        adapter.onItemMove(source.adapterPosition, target.adapterPosition)
        return true
    }



    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit
}