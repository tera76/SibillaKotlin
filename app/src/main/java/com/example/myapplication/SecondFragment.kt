package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentSecondBinding



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    // Add RecyclerView member
    private val recyclerView: RecyclerView? = null

    var recyclerAdapter: Adapter? =null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

     //   _binding = FragmentSecondBinding.inflate(inflater, container, false)
      //  return binding.root


        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val recyclerView = view.findViewById(com.example.myapplication.R.id.recycler_view) as RecyclerView



        recyclerView.layoutManager=LinearLayoutManager(activity)

       // recyclerView.adapter = Adapter()

        val apiInterface = ApiInterface.create().getMovies()
        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<List<Model>>{
            override fun onResponse(call: Call<List<Model>>?, response: Response<List<Model>>?) {

                if(response?.body() != null) {
                   // recyclerAdapter.setListItems(response.body()!!)

                    recyclerView.adapter = context?.let { Adapter(it, fetchListRetrofit(response.body()!!)) }
                  //  recyclerView.adapter =  recyclerAdapter.setListItems()
              //      recyclerView.adapter.setListItems(response.body()!!)
                    // recyclerView.adapter = context?.let { Adapter(it, fetchListRetrofit(response.body()!!)) }
            }
            else Log.d("sibilla", "Thisaaaaaaa is my message");
            //  recyclerAdapter.setMovieListItems(response.body()!!)


        }

                override fun onFailure(call: Call<List<Model>>?, t: Throwable?) {

        }
    })


     //   recyclerView.adapter = context?.let { Adapter(it, fetchListRetrofit(response.body()!!)) }








      //  return view

          _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // val recyclerView: RecyclerView = findViewById(com.example.myapplication.R.id.recycler_view)

     //   val view: View = inflater.inflate(com.example.myapplication.R.layout.fragment_second, container, false)
      //  val recyclerView = view.findViewById(com.example.myapplication.R.id.recycler_view) as RecyclerView

      //  recyclerView.layoutManager = LinearLayoutManager(context)
       // recyclerView.adapter = context?.let { Adapter(it, fetchList()) }
      //  binding.root.addView(recyclerView)


  binding.root.addView(view)

        //initData();


        //initData();



     return binding.root
    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()
/*
        for (i in 0..22) {
            val model = Model(
                androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp,
                "Title : $i", "Subtitle : $i", "imageLink : $i")
            list.add(model)
        }
  */      return list
    }



    private fun fetchListRetrofit(body: List<Model>): ArrayList<Model> {
        val list = arrayListOf<Model>()



                    for (i in 0..3) {
                        Log.d("sibilla", "This is my message:"+ body.get(i).name )
                        val model = Model(
                            androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp,
                            "Title : $i " + body.get(i).name  , "Subtitle : $i", "","name : $i")
                        list.add(model)
                        //  Log.d("sibilla", "This is my messagedddd:" + nnn)

                    }


/*
        for (i in 5..6) {
            // val nnn = response?.body()!!.get(i).name
            val model = Model(
                androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp,
                "Title : $i" , "Subtitle : $i", "imageLink : $i","name : $i")
            list.add(model)
            //  Log.d("sibilla", "This is my messagedddd:" + nnn)

        }
        */


     //   Log.d("sibilla", "This is my pppppp:" + list.get(1).title)

        return list


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}