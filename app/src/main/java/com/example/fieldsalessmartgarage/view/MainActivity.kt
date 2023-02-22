package com.example.fieldsalessmartgarage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.fieldsalessmartgarage.CheckinFragment
import com.example.fieldsalessmartgarage.HomeFragment
import com.example.fieldsalessmartgarage.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolBar:androidx.appcompat.widget.Toolbar
    private lateinit var drawer:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolBar = findViewById(R.id.toolbarMainActivity)
        toolBar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolBar)
      //  supportActionBar!!.setLogo(R.drawable.pdf)

        drawer = findViewById(R.id.drawerLayout)
        val toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolBar,R.string.navigation_drawer_open,R.string.navigation_drawer_close,
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        val navigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navigation.setOnItemReselectedListener {
        when(it.itemId) {
            R.id.home -> setFragment(HomeFragment())
        }
        }
        if (savedInstanceState == null) navigation.selectedItemId = R.id.home // For by default loading of home fragment through bottom navigation


      //  val fragment = CheckinFragment()
       // setFragment(fragment)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuItem = menu?.findItem(R.id.profileImageMenu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun setFragment(fragment:Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()

    }
}