package com.app.builduikt

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MySectionsPagerAdapter(
    supportFragmentManager: FragmentManager
) : FragmentStatePagerAdapter(supportFragmentManager) {

    @Suppress("JoinDeclarationAndAssignment")
    private lateinit var fragmentList: ArrayList<Fragment>

    constructor(
        supportFragmentManager: FragmentManager,
        fragmentList: ArrayList<Fragment>
    ) : this(supportFragmentManager) {
        this.fragmentList = fragmentList
    }


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return """TAB ${position + 1}"""
    }


}
