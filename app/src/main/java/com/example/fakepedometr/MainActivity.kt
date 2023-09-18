package com.example.fakepedometr

import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.LinearLayout.LayoutParams
import android.widget.LinearLayout.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fakepedometr.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        constraintLayout = findViewById(R.id.main)

            binding.bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.Home -> {

                        constraintLayout.visibility = View.VISIBLE
                        replaceFragment(Home())
                    }

                    R.id.Settings -> {
                        constraintLayout.visibility = View.INVISIBLE
                        replaceFragment(Setting())
                    }

                    else -> {

                    }

                }
                true
            }

    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.commit()
    }


    }

