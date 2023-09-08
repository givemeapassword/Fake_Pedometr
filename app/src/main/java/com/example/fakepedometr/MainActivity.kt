package com.example.fakepedometr

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.renderscript.ScriptGroup.Binding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.fakepedometr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.Home -> replaceFragment(Home())
                R.id.Settings -> replaceFragment(Setting())

                else -> {

                }

            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main,fragment)
        fragmentTransaction.commit()
    }
}