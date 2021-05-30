package com.codepalace.darkmodetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.codepalace.darkmodetest.databinding.ActivityMainBinding
import fragments.*


class MainActivity : AppCompatActivity() {

    val cFragment = CFragment()
    val javaFragment = JavaFragment()
    val pythonFragment = PythonFragment()
    val jsFragment = JsFragment()
    val kotlinFragment = KotlinFragment()
    val homeFragment = HomeFragment()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTabBar()

    setCurrentFragment(homeFragment)
}

    private fun setUpTabBar() {

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.c -> setCurrentFragment(cFragment)
                R.id.java -> setCurrentFragment(javaFragment)
                R.id.python -> setCurrentFragment(pythonFragment)
                R.id.js -> setCurrentFragment(jsFragment)
                R.id.kotlin -> setCurrentFragment(kotlinFragment)
            }
        }
    }


    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}