package com.qualitestudios.qualitehttp.ui

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.qualitestudios.qualitehttp.R
import com.qualitestudios.qualitehttp.data.remote.ApiService
import com.qualitestudios.qualitehttp.data.remote.DataObject
import com.qualitestudios.qualitehttp.data.remote.NationData
import com.qualitestudios.qualitehttp.data.remote.postData
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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
       binding.button.setOnClickListener { Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
binding.progressBar2.visibility= View.VISIBLE
GlobalScope.launch {
    getData()
    //changed
}


}
    }

    private fun getData() {
      val retrofitBuilder=Retrofit.Builder().
              addConverterFactory(GsonConverterFactory.create())
          .baseUrl("https://jsonplaceholder.typicode.com/").
              build().
              create(ApiService::class.java)

        val data=retrofitBuilder.getData()
        data.enqueue(object : Callback<List<postData>?> {
            override fun onResponse(
                call: Call<List<postData>?>,
                response: Response<List<postData>?>
            ) {
                if(response.isSuccessful)
                {  binding.progressBar2.visibility= View.INVISIBLE
                    var listofdata= ArrayList<postData>()
                    for(i in response.body()!!)
                    {
                        listofdata.add(i)

                    }
                   // binding.tvData.text=response.body()!!.title
                    binding.recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
                    binding.recyclerView.adapter=RecyclerView(listofdata)

                }
            }

            override fun onFailure(call: Call<List<postData>?>, t: Throwable) {

            }
        })



    }

}