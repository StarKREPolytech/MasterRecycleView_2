package com.github.stephenvinouze.advancedrecyclerview.sample.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.github.stephenvinouze.advancedrecyclerview.core.adapters.RecyclerAdapter
import com.github.stephenvinouze.advancedrecyclerview.sample.models.Sample
import com.github.stephenvinouze.advancedrecyclerview.sample.views.SampleItemView

/**
 * Created by Stephen Vinouze on 09/11/2015.
 */
open class SampleAdapter(context: Context) : RecyclerAdapter<Sample>(context) {

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): View = SampleItemView(context)

    override fun onBindItemView(view: View, position: Int) {
        when (view) {
            is SampleItemView -> view.bind(items[position], isItemViewToggled(position))
        }
    }

}
