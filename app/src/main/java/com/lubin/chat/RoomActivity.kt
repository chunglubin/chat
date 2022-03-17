package com.lubin.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lubin.chat.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}