package com.example.myapplication
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var navView: NavigationView

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ZeroFragment()
        replaceFragment(fragment)
        Log.d("sibilla","OshowFragment " + fragment)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)



        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
      //  val navView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }




    // Extension function to replace fragment
    fun AppCompatActivity.replaceFragment(fragment: Fragment){


        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_main,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("sibilla", "Sign out clicked!+********    " + item.itemId )
        drawerLayout.closeDrawer(GravityCompat.START)
        when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "nav_home", Toast.LENGTH_SHORT).show()
                Log.d("sibilla", "click menu nav_home")
                replaceFragment(FirstFragment())
                true
            }
            R.id.nav_gallery -> {
                Toast.makeText(this, "nav_gallery", Toast.LENGTH_SHORT).show()
                Log.d("sibilla", "click menu nav_gallery")
                replaceFragment(SecondFragment())
                true
            }
            R.id.nav_slideshow -> {
                Toast.makeText(this, "nav_slideshow", Toast.LENGTH_SHORT).show()
                Log.d("sibilla", "click menu nav_slideshow")
                replaceFragment(ThirdFragment())
                true
            }
            R.id.nav_FourthFragment -> {
                Toast.makeText(this, "nav_FourthFragment", Toast.LENGTH_SHORT).show()
                replaceFragment(FourthFragment())
                true
            }
            else -> {
                false
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

}