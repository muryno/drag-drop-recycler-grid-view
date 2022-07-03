package com.muryno.recyclergrid.reorder

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean

    fun onDragComplete(newPosition: Int)
}