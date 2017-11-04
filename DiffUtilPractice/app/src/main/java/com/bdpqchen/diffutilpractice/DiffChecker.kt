package com.bdpqchen.diffutilpractice

import java.util.ArrayList

/**
 * Created by bdpqchen on 17-11-4.
 *
 */
abstract class DiffChecker(old: ArrayList<Model>, new: ArrayList<Model>) : DiffCallback(old, new){
    abstract override fun _areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

}