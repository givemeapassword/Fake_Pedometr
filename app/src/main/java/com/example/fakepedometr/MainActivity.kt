package com.example.fakepedometr



import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fakepedometr.databinding.ActiveMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActiveMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiveMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        //очень топорно
        binding = ActiveMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> {
                    //и это кажется тоже очень топорно
                    onResume()
                }

                R.id.Settings -> { replaceFragment(Setting()) }

                R.id.Histogram -> { replaceFragment(StatisticFragment()) }

                else -> { }

            }
            true
        }
        dataModel.message.observe(this) {
            binding.countersteps.text = dataModel.message.value
        }
    }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main, fragment)
        fragmentTransaction.commit()
    }



    }


