package com.kingtech.kinwaesystems.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.kingtech.kinwaesystems.CustomPagerAdapter
import com.kingtech.kinwaesystems.R
import com.kingtech.kinwaesystems.databinding.ActivityMainBinding
import com.kingtech.kinwaesystems.ui.fragment.ContactFragment
import com.kingtech.kinwaesystems.ui.fragment.PersonalFragment
import com.kingtech.kinwaesystems.ui.fragment.UploadFragment

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var adapter: CustomPagerAdapter
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        adapter = CustomPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        adapter.addFragment(PersonalFragment(), "Personal")
        adapter.addFragment(ContactFragment(), "Contact")
        adapter.addFragment(UploadFragment(), "Upload")

        viewBinding.viewPager.adapter = adapter
        viewBinding.viewPager.addOnPageChangeListener(this)
        viewBinding.stepperIndicator.setViewPager(viewBinding.viewPager, adapter.count)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        viewBinding.currentFragTextView.text = adapter.getPageTitle(position)
    }
}
