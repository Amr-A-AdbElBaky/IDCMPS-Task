package com.example.idcmps_listing.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.idcmps_listing.databinding.ItemListBinding
import com.example.idcmps_listing.presentation.uimodel.UniversityUIModel

class ListItemAdapter(
    private val clickTest: (mainLab: UniversityUIModel) -> Unit,
): ListAdapter<UniversityUIModel, ListItemAdapter.NormalTestViewHolder>(LabDiffCallback()) {
    
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
            item: UniversityUIModel,
        ) = binding.run {
            with(item){
                tvUniversityName.text = universityName
                tvUniversityState.text = universityState
            }
            this.root.setOnClickListener { clickTest.invoke(item) }
        }
    }
    
    class LabDiffCallback : DiffUtil.ItemCallback<UniversityUIModel>() {
        override fun areItemsTheSame(oldItem: UniversityUIModel, newItem: UniversityUIModel) =
            oldItem.universityName == newItem.universityName
        override fun areContentsTheSame(oldItem: UniversityUIModel, newItem: UniversityUIModel) =
            oldItem.universityName == newItem.universityName
    }
}