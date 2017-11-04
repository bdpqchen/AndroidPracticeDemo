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
        println(Math.random())
        val random: Int = (Math.random() * 10).toInt()
        println(random)
        list[random].name = "changed name"
        val model = list[random]
        list.remove(model)
        list.add(model)
        val result = DiffUtil.calculateDiff(object : DiffChecker1(mList, list) {

            override fun _areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                if (mList[oldItemPosition].name == list[newItemPosition].name) {
                    return true
                }
                return false
            }
        }, true)
        mList.clear()
        mList.addAll(list)
        mAdapter.setDataList(mList)
        result.dispatchUpdatesTo(mAdapter)

    }

    private fun initList() {
        for (i in 0..10) {
            mList.add(Model(i, "name-->$i"))
        }
    }
}
