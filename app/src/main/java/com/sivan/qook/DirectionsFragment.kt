package com.sivan.qook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sivan.qook.databinding.DirectionsItemBinding
import com.sivan.qook.databinding.FragmentDirectionsBinding
import com.sivan.qook.databinding.FragmentIngredientsBinding
import com.sivan.qook.model.FoodModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DirectionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DirectionsFragment(val foodItem : FoodModel) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding : FragmentDirectionsBinding
    lateinit var directionsAdapterAdapter: DirectionsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDirectionsBinding.inflate(inflater, container, false)
        directionsAdapterAdapter = DirectionsAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        directionsAdapterAdapter.submitIngredients(foodItem.foodDirections)
        Log.d("TAG", "onViewCreated: ${foodItem.foodDirections}")

        initIngredientsRecyclerView()

    }

    private fun initIngredientsRecyclerView() {
        binding.directonsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            adapter = directionsAdapterAdapter

        }
        DividerItemDecoration(
                context, // context
                LinearLayoutManager.VERTICAL
        ).apply {
            // add divider item decoration to recycler view
            // this will show divider line between items
            binding.directonsRecyclerView.addItemDecoration(this)
        }    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DirectionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DirectionsFragment(foodItem = FoodModel()).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}