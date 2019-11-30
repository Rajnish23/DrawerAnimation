package com.example.draweranimation.ui.feed

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.draweranimation.data.Response
import com.example.draweranimation.network.ApiClient
import com.example.draweranimation.network.ApiEndpoints
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    private val TAG = "FeedViewModel"
    private var apiEndpoints: ApiEndpoints
    private val compositeDisposable = CompositeDisposable()

    init {
        apiEndpoints = ApiClient.create()
    }

    private val showProgressObserver = MutableLiveData<Int>()
    val showProgress: LiveData<Int>
        get() = showProgressObserver

    private val feedLiveData = MutableLiveData<List<Response>>()
    val feedData: LiveData<List<Response>>
        get() = feedLiveData

    fun getFeedData() {

        showProgressObserver.value = View.VISIBLE
        val feefObservable = apiEndpoints.getQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                showProgressObserver.value = View.GONE
                if(response != null){
                    feedLiveData.value = response
                }
                Log.d(TAG, "getFeedData: " + response.toString())
            }, { error ->
                showProgressObserver.value = View.GONE
                Log.d(TAG, "getFeedData: " + error.localizedMessage)
            })

        compositeDisposable.add(feefObservable)
    }


}
