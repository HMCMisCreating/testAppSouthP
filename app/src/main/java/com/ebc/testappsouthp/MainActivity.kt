package com.ebc.testappsouthp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebc.testappsouthp.controller.RetrofitInstance
import com.ebc.testappsouthp.databinding.ActivityMainBinding
import com.ebc.testappsouthp.models.Epis
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate (savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getEpisode()

        binding.generateBtn.setOnClickListener {
            getEpisode()
        }
    }

   private fun getEpisode() {
        GlobalScope.launch {
            try {
                val response = RetrofitInstance.episApiService.getEpisodes()
                runOnUiThread {
                    response.body()?.first()?.let {
                        //setUI(it, binding)
                    }
                }

            } catch ( e : Exception){

            }

        }
   }

}

//private fun setUI(epis: Epis){ }