package com.example.bitjobapk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitjobapk.databinding.FragmentLoginBinding

class RecyclerFragment : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Events>
    lateinit var imageId : Array<Int>
    lateinit var timeId : Array<String>
    lateinit var titleId : Array<String>
    lateinit var nameId : Array<String>
    lateinit var descriptionId : Array<String>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_recycler)

        imageId = arrayOf(
            R.drawable.time
        )

        timeId = arrayOf(
            "12:00"
        )

        titleId = arrayOf(
            "Event"
        )

        nameId = arrayOf(
            "AliReza"
        )

        descriptionId = arrayOf(
            "Powered by bitok"
        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Events>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in imageId.indices){

            val events = Events(imageId[i],timeId[i],titleId[i],nameId[i],descriptionId[i])
            newArrayList.add(events)

        }

        newRecyclerView.adapter = MyAdapter(newArrayList)
    }

}