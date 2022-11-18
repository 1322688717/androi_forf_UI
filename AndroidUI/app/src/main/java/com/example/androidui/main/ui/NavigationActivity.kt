package com.example.androidui.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidui.R
import com.example.androidui.main.fragment.HomeFragment
import com.example.androidui.main.fragment.MainFragment
import com.example.androidui.main.fragment.MineFragment
import com.example.androidui.databinding.ActivityNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.ArrayList

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding
    var fragmentArr = ArrayList<Fragment>()
    private lateinit var homeFragment: HomeFragment
    private lateinit var mainFragment: MainFragment
    private lateinit var meFragment: MineFragment
    private lateinit var fragments: Array<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeFragment = HomeFragment()
        val mainFragment = MainFragment()
        val mineFragment = MineFragment()
        fragmentArr.add(homeFragment)
        fragmentArr.add(mainFragment)
        fragmentArr.add(mineFragment)
        initView()
    }


    //监听Item
    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.item_home -> {
                replaceFragment(fragments[0], fragments[0].tag.toString())

                return@OnNavigationItemSelectedListener true
            }
            R.id.item_main -> {
                replaceFragment(fragments[1], fragments[1].tag.toString())

                return@OnNavigationItemSelectedListener true
            }
            R.id.item_me -> {
                replaceFragment(fragments[2], fragments[2].tag.toString())

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

     fun initView() {

        binding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        homeFragment = HomeFragment()
        mainFragment = MainFragment()
        meFragment = MineFragment()
        fragments = arrayOf(homeFragment, mainFragment, meFragment)
        fragments.forEach {
            addFragment(it, it.tag.toString())
            hideFragment(it)
        }
        showFragment(fragments[0])
    }

    //添加Fragment到FragmentList中
    private fun addFragment(fragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment, tag)
        transaction.commit()
    }

    // 清空fragmentList的所有Fragment，替换成新的Fragment，注意Fragment里面的坑
    private fun replaceFragment(fragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, tag)
        transaction.commit()
    }

    //把Fragment设置成显示状态，但是并没有添加到FragmentList中
    private fun showFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.show(fragment)
        transaction.commit()
    }

    //把Fragment设置成显示状态，但是并没有添加到FragmentList中
    private fun hideFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.hide(fragment)
        transaction.commit()
    }

}