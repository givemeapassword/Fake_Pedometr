package com.example.fakepedometr

import android.annotation.SuppressLint
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
import com.example.fakepedometr.databinding.ActiveMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActiveMainBinding
    private lateinit var constraintLayout: ConstraintLayout

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiveMainBinding.inflate(layoutInflater)
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

