package com.example.bitjobapk.ui.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitjobapk.MainActivity
import com.example.bitjobapk.R
import com.example.bitjobapk.data.ChipViewModel
import com.example.bitjobapk.data.Event
import com.example.bitjobapk.databinding.FragmentEventListBinding
import com.plcoding.retrofitcrashcourse.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

class EventListFragment : Fragment() {

    private lateinit var binding: FragmentEventListBinding

    //    private var dataList = mutableListOf<Event>()
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

        rvAdapter = MyAdapter()
        binding.recyclerview.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

//            setHasFixedSize(true)
            adapter = rvAdapter
        }


        binding.recyclerview2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val data = ArrayList<ChipViewModel>()
        for (i in 1..7) {
            data.add(ChipViewModel(R.drawable.ic_launcher_background, "Category " + i))
        }
        val adapter = ChipAdapter(data)
        binding.recyclerview2.adapter = adapter


        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getEvents()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    rvAdapter.submitList(it)
                }
            } else {
                Log.e(TAG, "Response not successful")
            }
            binding.progressBar.isVisible = false
        }


    }
}