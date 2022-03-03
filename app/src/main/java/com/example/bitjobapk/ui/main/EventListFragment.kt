package com.example.bitjobapk.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitjobapk.data.Event
import com.example.bitjobapk.databinding.FragmentEventListBinding

class EventListFragment : Fragment() {
    private lateinit var binding: FragmentEventListBinding

//    private lateinit var newRecyclerView: RecyclerView
    private lateinit var dataList: MutableList<Event>
//    lateinit var imageId : Array<Int>
//    lateinit var timeId : Array<String>
//    lateinit var titleId : Array<String>
//    lateinit var nameId : Array<String>
//    lateinit var descriptionId : Array<String>

    private lateinit var rvAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        imageId = arrayOf(
//            R.drawable.time
//        )
//
//        timeId = arrayOf(
//            "12:00"
//        )
//
//        titleId = arrayOf(
//            "Event"
//        )
//
//        nameId = arrayOf(
//            "AliReza"
//        )
//
//        descriptionId = arrayOf(
//            "Powered by bitok"
//        )

//        newRecyclerView =
//        newRecyclerView.layoutManager = LinearLayoutManager(this)
//        newRecyclerView.setHasFixedSize(true)

        dataList = mutableListOf(
            Event(0,"0","test1","qwerty","lorem ipsum"),
            Event(0,"0","test1","qwerty","lorem ipsum"),
            Event(0,"0","test1","qwerty","lorem ipsum"),
            Event(0,"0","test1","qwerty","lorem ipsum"),
            Event(0,"0","test1","qwerty","lorem ipsum"),
            Event(0,"0","test1","qwerty","lorem ipsum"),
        )
        rvAdapter = MyAdapter(dataList)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = rvAdapter
        }
//        getUserdata()

    }

//    private fun getUserdata() {
//        for(i in imageId.indices){
//
//            val events = Event(imageId[i],timeId[i],titleId[i],nameId[i],descriptionId[i])
//            newArrayList.add(events)
//
//        }
//        newRecyclerView.adapter = MyAdapter(newArrayList)
//    }


}
