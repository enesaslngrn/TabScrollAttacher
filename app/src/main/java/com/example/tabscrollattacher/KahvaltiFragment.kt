package com.example.tabscrollattacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tabscrollattacher.databinding.FragmentKahvaltiBinding
import com.iammert.tabscrollattacherlib.TabScrollAttacher


class KahvaltiFragment : Fragment() {
    private lateinit var binding: FragmentKahvaltiBinding
    private val categoryData = CategoryData(
        categories = listOf("A","B","C"),
        categoryIndexOffsetList = listOf(0,40,80)
    )
    private val itemData = ItemData(
        itemList = (200..300).toList()
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKahvaltiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecyclerAdapter(itemData.itemList)
        binding.recyclerView.layoutManager = GridLayoutManager(context,3,
            GridLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter = adapter

        categoryData.categories.forEach { category ->
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(category))
        }

        TabScrollAttacher(binding.tabLayout,binding.recyclerView,categoryData.categoryIndexOffsetList){
            scrollSmoothly(5)
        }.attach()
    }
}