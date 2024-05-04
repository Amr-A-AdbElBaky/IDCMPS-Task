package com.example.idcmps_listing.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.idcmps_listing.databinding.ItemListBinding
import com.example.idcmps_listing.presentation.uimodel.ItemUIModel

class ListItemAdapter(
    private val clickTest: (mainLab: ItemUIModel) -> Unit,
): ListAdapter<ItemUIModel, ListItemAdapter.NormalTestViewHolder>(LabDiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalTestViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        
        return NormalTestViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: NormalTestViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class NormalTestViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: ItemUIModel,
        ) = binding.run {
            with(item){
                tvUniversityName.text = universityName
                tvUniversityState.text = universityState
            }
            this.root.setOnClickListener { clickTest.invoke(item) }
        }
    }
    
    class LabDiffCallback : DiffUtil.ItemCallback<ItemUIModel>() {
        override fun areItemsTheSame(oldItem: ItemUIModel, newItem: ItemUIModel) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ItemUIModel, newItem: ItemUIModel) =
            oldItem.id == newItem.id
    }
}