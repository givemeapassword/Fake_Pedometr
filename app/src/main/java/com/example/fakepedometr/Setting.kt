package com.example.fakepedometr

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.fakepedometr.databinding.ActiveMainBinding
import com.example.fakepedometr.databinding.FragmentSettingBinding


class Setting : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(layoutInflater)
        binding.switcher.setOnClickListener{
            Log.d("ss","ssasa")
        }
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

}