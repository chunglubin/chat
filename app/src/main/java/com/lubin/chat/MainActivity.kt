package com.lubin.chat

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.lubin.chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG= MainActivity::class.java.simpleName
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_logout->{
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onStart() {//當activity產生後(未顯示在手機畫面上),呼叫onStart()
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {//當activity顯示在手機上後,呼叫OnResume()
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onRestart() {//切換activity情境,由user使用點擊此ＡＰＰ後執行onRestart()
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {//當user按下返回鍵結束activity,呼叫onPause()
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {//當activity從螢幕上消失，呼叫onStop()
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {//完全結束,呼叫onDestroy()
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}