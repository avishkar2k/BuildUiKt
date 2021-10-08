package com.app.builduikt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.app.builduikt.ui.main.PlaceholderFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        //val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val sectionsPagerAdapter = MySectionsPagerAdapter(
            supportFragmentManager,
            arrayListOf(
                PlaceholderFragment.newInstance(1),
                PlaceholderFragment.newInstance(2),
                PagerOneFragment.newInstance("avi", "shkar"),
                PagerTwoFragment.newInstance("yad", "av")
            )
        )
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.offscreenPageLimit = 12;
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        viewPager.setCurrentItem(1, true)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Log.d(
                    Companion.TAG, "onPageScrolled: position " + position
                            + " positionOffset " + positionOffset
                            + " positionOffsetPixels " + positionOffsetPixels
                )
            }

            override fun onPageSelected(position: Int) {

                Log.d(TAG, "onPageSelected: position $position")
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.d(TAG, "onPageScrollStateChanged: State $state")
            }

        })
        fab.setOnClickListener {

            viewPager.setCurrentItem(0, true)
            /*Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
    }

    companion object {
        private const val TAG = "ViewPagerActivity"
    }
}
