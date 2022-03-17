package com.lubin.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lubin.chat.LogInFragment
import com.lubin.chat.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun backBT(view: View){
        var back=binding.idBack.toString()
        Intent(this,LogInFragment::class.java).apply {
            putExtra("Your Anchor name",back)
            startActivity(this)
        } //當按下searchBT按鈕,intent物件轉換至首頁(MainActivity)
    }
    fun setPictureBT(view: View){

    }
    fun submitBT(view: View){

    }
}