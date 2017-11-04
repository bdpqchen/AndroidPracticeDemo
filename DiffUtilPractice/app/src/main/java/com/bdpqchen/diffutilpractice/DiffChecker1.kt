package com.bdpqchen.diffutilpractice

import android.support.v7.util.DiffUtil
import java.util.*

/**
 * Created by bdpqchen on 17-11-3.
 *
 */
abstract class DiffChecker1(old: ArrayList<Model>, new: ArrayList<Model>) : DiffUtil.Callback() {

    private var mOld: ArrayList<Model> = old
    private var mNew: ArrayList<Model> = new

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//        return mOld[oldItemPosition].id == mNew[newItemPosition].id
        return mOld[oldItemPosition].hashCode() == mNew[newItemPosition].hashCode()
    }

    override fun getOldListSize(): Int {
        return mOld.size
    }

    override fun getNewListSize(): Int {
        return mNew.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
     /*   if (mOld[oldItemPosition].name == mNew[newItemPosition].name){
            return true
        }
        return false
    */
        return _areContentsTheSame(oldItemPosition, newItemPosition)
    }

    abstract fun _areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

}