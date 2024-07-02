package com.example.tabscrollattacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabscrollattacher.databinding.FragmentDondurmaBinding
import com.iammert.tabscrollattacherlib.TabScrollAttacher


class DondurmaFragment : Fragment() {
    private lateinit var binding: FragmentDondurmaBinding
    private val categoryData = CategoryData(
        categories = listOf("1-20","20-50","50-100"),
        categoryIndexOffsetList = listOf(0,20,50)
    )
    private val itemData = ItemData(
        itemList = (1..100).toList()
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDondurmaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerAdapter(itemData.itemList)
        binding.recyclerView.layoutManager = GridLayoutManager(context,2,
            GridLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = adapter

        categoryData.categories.forEach { category ->
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(category))
        }

        TabScrollAttacher(binding.tabLayout,binding.recyclerView,categoryData.categoryIndexOffsetList){
            scrollSmoothly(5)
        }.attach()
    }
}