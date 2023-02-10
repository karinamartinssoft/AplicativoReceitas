package com.example.aplicativoreceitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicativoreceitas.databinding.ActivityMainBinding
import com.example.aplicativoreceitas.framework.ScreenSlidePagerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setAdapterFragment()

    }

    fun setAdapterFragment() {
        val lAdapter = ScreenSlidePagerAdapter(supportFragmentManager, lifecycle)
        lAdapter.addFragment(LoginPerfilFragment())
        lAdapter.addFragment(ReceitasFragment())
        mBinding.viewPagerMain.adapter = lAdapter
    }

    fun goToPage(aPageToGo: Int) {
        mBinding.viewPagerMain.setCurrentItem(aPageToGo, false)
    }
}