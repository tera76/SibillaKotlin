package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentThirdBinding






import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
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

   //    _binding = FragmentSecondBinding.inflate(inflater, container, false)
      //  return binding.root


        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val recyclerView = view.findViewById(com.example.myapplication.R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager=LinearLayoutManager(activity)

        val ciccio1 = Request(
            "login","",Parameters("ciccio","1970","")
        )

        val ciccio2 = Request(
            "tvQueryWithImages","tvQueryWithImages",Parameters("","","")
        )

        var xxx  = SibillaModel(listOf(ciccio1,ciccio2))
        val apiService = RestApiService()
        apiService.addUser(xxx) {
            if (it != null) {
                val bodyxxx= it
             recyclerView.adapter = context?.let { Adapter(it, fetchListRetrofit(bodyxxx)) }
            } else {
                Log.d("sibilla","Error response to POST " + it)
            }

        }





        val apiInterface = ApiInterface.create().getMovies()
        //apiInterface.enqueue( Callback<List<Movie>>())


        apiInterface.enqueue( object : Callback<List<Model>>{


            override fun onResponse(call: Call<List<Model>>?, response: Response<List<Model>>?) {
            //   addDummyUser()
                if(response?.body() != null) {
                   // recyclerAdapter.setListItems(response.body()!!)

                   // -->  recyclerView.adapter = context?.let { Adapter(it, fetchListRetrofit(response.body()!!)) }
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

          _binding = FragmentThirdBinding.inflate(inflater, container, false)
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





    fun addDummyUser() {

        // val ciccioq = SibillaModel("1900-01-01","less_than_26","FD441XB")


        val ciccio1 = Request(
            "login","",Parameters("ciccio","1970","")
        )

        val ciccio2 = Request(
            "tvQueryWithImages","tvQueryWithImages",Parameters("","","")
        )


        var xxx  = SibillaModel(listOf(ciccio1,ciccio2))


      //  var request : List<Request>? = listOf(ciccio1, ciccio2)



             //   "login", Parameter("ciccio","diagrammsPersistence1976a")    ))]


       //     Request(("login", Parameter("ciccio","diagrammsPersistence1976a"),
        //    "sql,""todaytv",Parameter("","","select * from syb_tv_notPreferred") )

        //)

        val apiService = RestApiService()
        apiService.addUser(xxx) {
            if (it != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
               Log.d("sibilla","OK response to POST " + it)




            } else {
                Log.d("sibilla","Error response to POST " + it)
            }

        }
    }


    private fun fetchListRetrofit(body: SibillaResponse): ArrayList<Model> {
        val list = arrayListOf<Model>()

    var ll = body.response.get(0).values.size;
if (ll>0) {
    for (i in 0..(ll - 1)) {

        val model = Model(
            androidx.appcompat.R.drawable.abc_ic_arrow_drop_right_black_24dp,
            "Channel: " + body.response.get(0).values.get(i).get(0),
            "" + body.response.get(0).values.get(i).get(1),
            body.response.get(0).values.get(i).get(2),
            "name : $i"
        )
        list.add(model)
        //  Log.d("sibilla", "This is my messagedddd:" + nnn)

    }
} else {

    Toast.makeText(activity,"Riprova piu tardi",Toast.LENGTH_SHORT).show();

}

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