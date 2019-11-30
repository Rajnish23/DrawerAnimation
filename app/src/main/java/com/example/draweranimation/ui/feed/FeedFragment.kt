package com.example.draweranimation.ui.feed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator

import com.example.draweranimation.R
import com.example.draweranimation.ui.feed.adapter.FeedAdapter
import kotlinx.android.synthetic.main.feed_fragment.*

class FeedFragment : Fragment() {

    companion object {
        private const val TAG = "FeedFragment"
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.getFeedData()
        viewModel.feedData.observe(this, Observer {
            feed_recyclerview.adapter = FeedAdapter(it)
            feed_recyclerview.itemAnimator = DefaultItemAnimator()
        })

        viewModel.showProgress.observe(this, Observer {
            if(it == View.VISIBLE){
                feed_motion_layout.transitionToState(R.id.feed_loading)
            }
            else{
                feed_motion_layout.transitionToState(R.id.feed_end)
            }
        })
    }
}
