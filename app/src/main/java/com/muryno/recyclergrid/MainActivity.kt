package com.muryno.recyclergrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.muryno.recyclergrid.reorder.OnStartDragListener
import com.muryno.recyclergrid.reorder.ReorderHelperCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnStartDragListener<DataModel> {

    private var mItemTouchHelper: ItemTouchHelper? = null
    private lateinit var  photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(applicationContext,3)
        photoAdapter = PhotoAdapter(dragStartListener = this)


        recyclerView.adapter = photoAdapter

        val callback: ItemTouchHelper.Callback = ReorderHelperCallback(photoAdapter)
        mItemTouchHelper = ItemTouchHelper(callback)

        mItemTouchHelper?.attachToRecyclerView(recyclerView)

        dataList.add(DataModel("Title1","Desc1", R.drawable.online))
        dataList.add(DataModel("Title2","Desc2", R.drawable.online))
        dataList.add(DataModel("Title3","Desc3", R.drawable.online))
        dataList.add(DataModel("Title4","Desc4", R.drawable.online))
        dataList.add(DataModel("Title5","Desc5", R.drawable.online))
        dataList.add(DataModel("Title6","Desc6", R.drawable.online))
        dataList.add(DataModel("Title7","Desc7", R.drawable.online))
        dataList.add(DataModel("Title8","Desc8", R.drawable.online))
        dataList.add(DataModel("Title9","Desc9", R.drawable.online))
        dataList.add(DataModel("Title10","Desc10", R.drawable.online))
        dataList.add(DataModel("Title11","Desc11", R.drawable.online))
        dataList.add(DataModel("Title12","Desc12", R.drawable.online))
        dataList.add(DataModel("Title13","Desc13", R.drawable.online))
        dataList.add(DataModel("Title14","Desc14", R.drawable.online))
        dataList.add(DataModel("Title15","Desc15", R.drawable.online))
        dataList.add(DataModel("Title16","Desc16", R.drawable.online))
        photoAdapter.setDataList(dataList)


    }

    override fun onStartDrag(viewHolder: RecyclerView.ViewHolder?) {
        viewHolder?.let {
            mItemTouchHelper?.startDrag(it)
        }
    }

    override fun onItemSelected(item: DataModel) {
        print("Seee oooo $item")
    }

    override fun onDragComplete(item: DataModel) {
        print("Seee result $item")
    }
}