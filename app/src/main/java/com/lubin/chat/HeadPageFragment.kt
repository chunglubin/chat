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
import okhttp3.*
import okio.ByteString
import java.net.URL
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HeadPageFragment : Fragment() {

    private var _binding: FragmentHeadpageBinding?= null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //lateinit var websocket:WebSocket
    //private val TAG=FragmentHeadpageBinding::class.java.simpleName
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHeadpageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val client= OkHttpClient.Builder().readTimeout(3, TimeUnit.SECONDS).build()//source來源端
        val reqeust= Request.Builder().url("wss://lott-dev.lottcube.asia/ws/chat/chat:app_test?nickname=Lubin").build()//destination目的端
        websocket=client.newWebSocket(reqeust, object : WebSocketListener() {
            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosed(webSocket, code, reason)
                Log.d(TAG, ":onClosed")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                Log.d(TAG, ":onClosing")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Log.d(TAG, ":onFailure")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                Log.d(TAG, ":onMessage $text")
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                super.onMessage(webSocket, bytes)
                Log.d(TAG, ":onMessage ${bytes.hex()}")
            }

            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                Log.d(TAG, ":onOpen")
                webSocket.send("Hello, my name is lubinflower.")
            }
        })
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
        */
        /*thread {
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
        }*/
        binding.idPerson.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    /*inner class ChatRoomAdapter:RecyclerView.Adapter<ChatRoomViewHolder>(){
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
            return rooms.size//回傳陣列長度
        }
    }
    inner class ChatRoomViewHolder(view: View):RecyclerView.ViewHolder(view){//recycler回收的人
        val room_host=view.findViewById<TextView>(R.id.id_hostname)
        val room_title=view.findViewById<TextView>(R.id.id_chatroom_title)
        val streamer_headphoto=view.findViewById<ImageView>(R.id.streamer_photo)
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}