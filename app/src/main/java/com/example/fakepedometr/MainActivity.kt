package com.example.fakepedometr



import android.os.Bundle
import android.util.Log
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
        Log.i("Activity","onCreate")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        Log.i("Activity","onResume")


        super.onResume()
        //очень топорно
        binding = ActiveMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> {
                    Log.i("Activity","Home")
                    //и это кажется тоже очень топорно
                    onResume()
                }

                R.id.Settings -> {
                    replaceFragment(Setting())
                    Log.i("Activity","Settings")
                }

                R.id.Histogram -> {
                    replaceFragment(StatisticFragment())
                    Log.i("Activity","Histogram")
                }

                else -> { }

            }
            true
        }
        dataModel.message.observe(this) {
            Log.i("Activity","Change Data")
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


