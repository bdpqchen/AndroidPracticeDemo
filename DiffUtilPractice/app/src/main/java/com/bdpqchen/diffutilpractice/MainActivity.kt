package com.bdpqchen.diffutilpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: DiffAdapter
    private var mList = ArrayList<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()

        rvDiff.layoutManager = LinearLayoutManager(this)
        mAdapter = DiffAdapter(mList)
        rvDiff.adapter = mAdapter

        refresh.setOnClickListener({
            refresh()
        })

    }

    private fun refresh() {
        var list = ArrayList<Model>()
        for (i in 0..10) {
            list.add(Model(i, "name-->$i"))
        }
        list[1].name = "changed name"
//        mAdapter.notifyItemChanged(1)
//        val model = list[1]
//        list.remove(model)
//        list.add(model)

//        println("size of mList is ${mList.size} and \n size of newList is ${list.size}")
        val result = DiffUtil.calculateDiff(DiffCallback(mList, list), false)
        result.dispatchUpdatesTo(mAdapter)
//        mAdapter.setDataList(list)

    }

    private fun initList() {
        for (i in 0..10) {
            mList.add(Model(i, "name-->$i"))
        }
    }
}
