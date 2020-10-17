package com.sivan.qook.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sivan.qook.databinding.FragmentHomeBinding
import com.sivan.qook.model.FoodModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    lateinit var foodAdapter : FoodMainListAdapter
    lateinit var foodList : List<FoodModel>
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        foodAdapter = FoodMainListAdapter(context)

        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        initRecyclerView()


        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "onViewCreated: View created")
        homeViewModel.getData()?.observe(viewLifecycleOwner, {
            Log.d("TAG", "getData: Foodlist live data ${it[0].foodName}")

            foodAdapter.submitList(it)

            foodAdapter.notifyDataSetChanged()
            for(item in it) {
                Log.d("TAG", "onCreateView: ${item.foodName}")

            }

        })
    }

    private fun initRecyclerView() {
        binding.mainListRecyclerView.apply {

            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = foodAdapter
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}