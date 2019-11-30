package com.example.draweranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.draweranimation.ui.feed.FeedFragment
import com.example.draweranimation.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToProfileFragment()

        profile.setOnClickListener {
            changeFragment(Status.PROFILE)
        }

        feed.setOnClickListener {
            changeFragment(Status.FEED)

        }

        settings.setOnClickListener {
            changeFragment(Status.SETTINGS)
        }
    }



    private fun changeFragment(currentSttatus : Status ){
        if(currentSttatus == Status.PROFILE){
            title_app.text = getString(R.string.profile_title)
            moveToProfileFragment()
        }
        else if(currentSttatus == Status.FEED){
            title_app.text = getString(R.string.feed_title)
            moveToFeedFragment()
        }
        else{
            title_app.text = getString(R.string.settings_title)
        }
        motion_base.transitionToState(R.id.start)

    }

    private fun moveToProfileFragment() {
        val supportFragmentManager = supportFragmentManager
        val fragment = supportFragmentManager.findFragmentByTag(getString(R.string.profile_title))
        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_content, ProfileFragment.newInstance(), getString(R.string.profile_title))
                .commit()
        }
    }

    private fun moveToFeedFragment() {
        val supportFragmentManager = supportFragmentManager
        val fragment = supportFragmentManager.findFragmentByTag(getString(R.string.feed_title))
        if(fragment == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_content, FeedFragment.newInstance(),getString(R.string.feed_title))
                .commit()
        }

    }

    enum class Status{
        PROFILE,
        FEED,
        SETTINGS
    }

}
