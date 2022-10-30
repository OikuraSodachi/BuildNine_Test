package com.todokanai.buildnine.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.todokanai.buildnine.R
import com.todokanai.buildnine.adapter.DirectoryRecyclerAdapter
import com.todokanai.buildnine.adapter.TrackRecyclerAdapter
import com.todokanai.buildnine.databinding.FragmentDirectoryBinding
import com.todokanai.buildnine.databinding.FragmentTrackBinding
import com.todokanai.buildnine.room.RoomHelper
import com.todokanai.buildnine.service.ForegroundPlayService
import com.todokanai.buildnine.tool.TrackTool

class DirectoryFragment : Fragment() {

    lateinit var helper : RoomHelper
    lateinit var binding: FragmentDirectoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val adapter = DirectoryRecyclerAdapter()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_directory, container, false)
        binding.directoryRecyclerView.adapter = adapter
        binding.directoryRecyclerView.layoutManager = LinearLayoutManager(context)
        val ct : Context = requireContext()
        helper = Room.databaseBuilder(ct, RoomHelper::class.java,"room_db")
            .allowMainThreadQueries()
            .build()
        adapter.mDirectoryList.addAll(helper.roomPathDao().getAll())
        // Inflate the layout for this fragment
        binding.swipe.setOnRefreshListener {
            adapter.notifyDataSetChanged()
            binding.swipe.isRefreshing = false          //------swipe 해서 목록 새로고침
        }

        return binding.root
    }
}