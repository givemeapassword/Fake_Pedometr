package com.example.fakepedometr



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.activityViewModels
import com.example.fakepedometr.databinding.FragmentSettingBinding


class Setting : Fragment() {
    private lateinit var binding: FragmentSettingBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSettingBinding.inflate(inflater)
        Log.i("Fragment_Setting","onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Fragment_Setting","onViewCreated")

        binding.switcher.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        binding.counter.setOnClickListener {
            showEditTextDialog()
        }
    }

    private fun showEditTextDialog(){
        val builder = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.edit_text_layout,null)
        val editText = dialogLayout.findViewById<EditText>(R.id.et_text)

        with(builder){
            setTitle("Ввод шагов")
            setPositiveButton("OK"){ _, _ ->
                dataModel.message.value =  editText.text.toString()

            }
            setView(dialogLayout)
            show()
        }

    }







}