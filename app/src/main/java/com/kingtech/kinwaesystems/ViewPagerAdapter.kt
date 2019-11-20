package com.kingtech.kinwaesystems

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class CustomPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    private val fragments = ArrayList<Fragment>()
    private val fragmentTitle = ArrayList<String>()

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentTitle.add(title)
    }
}