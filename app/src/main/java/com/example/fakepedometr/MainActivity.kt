package com.example.fakepedometr

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.fragment.app.Fragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fakepedometr.databinding.ActiveMainBinding
import com.example.fakepedometr.databinding.FragmentSettingBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActiveMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiveMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> {

                    replaceFragment(Home())
                }

                R.id.Settings -> {
                    replaceFragment(Setting())
                }

                R.id.histogram -> {
                    replaceFragment(StatisticFragment())
                }

                else -> {

                }

            }
            true
        }


        /*bindingSetting.switcher.setOnCheckedChangeListener{
                _,checkeId ->
            Log.i("Я ТУТ БЫЛ21212","СВИТЧЕР ХОРО221Ш")
            when(checkeId){
                true -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }*/

    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.commit()
    }


    }

