package com.lubin.chat

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.lubin.chat.databinding.FragmentHeadpageBinding
import com.lubin.chatapp.SearchActivity
import java.net.URL
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HeadPageFragment : Fragment() {
    private lateinit var adapter: ChatRoomAdapter
    private var _binding: FragmentHeadpageBinding?= null
    val chatRoom_person= listOf<ChatRoom>(
        ChatRoom("20220321","apple","welcome"),
        ChatRoom("20220321","banana","welcome"),
        ChatRoom("20220321","cherry","welcome"),
        ChatRoom("20220321","orange","welcome"),
    )
    val rooms= mutableListOf<Lightyear>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val TAG=FragmentHeadpageBinding::class.java.simpleName
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHeadpageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.idSearch.setOnClickListener {
            val intent=Intent(context,SearchActivity::class.java)
            startActivity(intent)
        }
        binding.idPerson.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager=GridLayoutManager(requireContext(),2)
        adapter=ChatRoomAdapter()
        binding.recycler.adapter=adapter
        thread {
            val json=URL("https://api.jsonserve.com/XEY0wX").readText()
            val msg=Gson().fromJson(json,default_message::class.java)
            Log.d(TAG, "msg:${msg.body.text}");//test msg
        }
        thread {
            val json=URL("https://api.jsonserve.com/INXDEh").readText()
            val chatRooms=Gson().fromJson(json,ChatRoomsProgram::class.java)
            Log.d(TAG, "rooms:${chatRooms.result.lightyear_list.size}")
            rooms.clear()
            rooms.addAll(chatRooms.result.lightyear_list)//fill list with new coming data
            activity?.runOnUiThread {
                adapter.notifyDataSetChanged()
            }
        }

    }
    inner class ChatRoomAdapter:RecyclerView.Adapter<ChatRoomViewHolder>(){
        val rooms= mutableListOf<Lightyear>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
            val view=layoutInflater.inflate(R.layout.row_chatroom,parent,false)
            return ChatRoomViewHolder(view)
        }

        override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
            val lightyear=rooms[position]
            holder.room_host.setText(lightyear.stream_title)
            holder.room_title.setText(lightyear.nickname)
            Glide.with(this@HeadPageFragment)
                .load(lightyear.head_photo)
                .into(holder.streamer_headphoto)
        }

        override fun getItemCount(): Int {
            return chatRoom_person.size
        }
    }
    inner class ChatRoomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val room_host=view.findViewById<TextView>(R.id.id_hostname)
        val room_title=view.findViewById<TextView>(R.id.id_chatroom_title)
        val streamer_headphoto=view.findViewById<ImageView>(R.id.streamer_photo)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}