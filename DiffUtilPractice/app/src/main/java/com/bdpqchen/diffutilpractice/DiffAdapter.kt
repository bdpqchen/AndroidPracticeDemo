package com.bdpqchen.diffutilpractice

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by bdpqchen on 17-11-3.
 *
 */
class DiffAdapter(var list: ArrayList<Model>) : RecyclerView.Adapter<DiffAdapter.ViewHolder>() {

    private val TAG = "DiffAdapter"
    private var mDataList = list
    fun getDataList(): List<Model> {
        return mDataList
    }

    fun setDataList(list: ArrayList<Model>){
        mDataList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_diff, parent, false))
    }

    override fun getItemCount(): Int {
//        Log.d(TAG, "${mDataList.size}")
        return mDataList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindView$position")
        with(holder) {
            with(mDataList[position]) {
                tvName.text = name
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvItem)
    }


}