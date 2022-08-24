package com.example.myapplication

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.GzipSource
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class RestApiService {
    fun addUser(userDatax: SibillaModel, onResult: (SibillaResponse?) -> Unit){
        Log.d("sibilla","in addUser userDatax to POST value " + userDatax)
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userDatax).enqueue(
            object : Callback<SibillaResponse> {
                override fun onFailure(call: Call<SibillaResponse>, t: Throwable) {

                    Log.d("sibilla","onFailure POST call... " + call)
                    Log.d("sibilla","onFailure POST value... " + t)
                    onResult(null)
                }
                override fun onResponse(call: Call<SibillaResponse>, response: Response<SibillaResponse>) {
                   // val addedUser = response


                    Log.d("sibilla","OK onResponse to POST response.body... " + response.body())
                    Log.d("sibilla","OK onResponse to POST response.errorBody... " + response.errorBody()?.string())
                    onResult(response.body())
                }
            }
        )
    }
}
/*
class RestApiService1 {
    fun addUser(userData: SibillaModel, onResult: (SibillaResponse?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<SibillaResponse> {
                override fun onFailure(call: Call<SibillaResponse>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<SibillaResponse>, response: Response<SibillaResponse>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}
*/
