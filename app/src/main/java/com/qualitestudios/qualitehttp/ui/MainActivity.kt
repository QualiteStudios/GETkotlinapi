package com.qualitestudios.qualitehttp.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.qualitestudios.qualitehttp.R
import com.qualitestudios.qualitehttp.data.remote.ApiService
import com.qualitestudios.qualitehttp.data.remote.DataObject
import com.qualitestudios.qualitehttp.data.remote.NationData
import com.qualitestudios.qualitehttp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
       binding.button.setOnClickListener { Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()

GlobalScope.launch {
    getData( binding.etName.text.toString())
}


}
    }

    private suspend fun getData(name:String) {
      val retrofitBuilder=Retrofit.Builder().
              addConverterFactory(GsonConverterFactory.create())
          .baseUrl("https://api.nationalize.io/").
              build().
              create(ApiService::class.java)

        val data=retrofitBuilder.getData(name)
        data.enqueue(object : Callback<NationData?> {
            override fun onResponse(call: Call<NationData?>, response: Response<NationData?>) {

                var data=response.body()!!
               binding.tvData.text=data.name



            }

            override fun onFailure(call: Call<NationData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })



    }

}