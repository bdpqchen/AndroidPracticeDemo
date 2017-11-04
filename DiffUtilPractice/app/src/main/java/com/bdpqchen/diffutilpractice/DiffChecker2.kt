package com.bdpqchen.diffutilpractice

import android.support.v7.util.DiffUtil
import java.util.ArrayList

/**
 * Created by bdpqchen on 17-11-3.
 *
 */

abstract class DiffChecker2(old: ArrayList<Model>, new: ArrayList<Model>) : DiffChecker1(old, new) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return _areItemsTheSame(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return _areContentsTheSame(oldItemPosition, newItemPosition)
    }

    abstract fun _areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    abstract override fun _areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

}