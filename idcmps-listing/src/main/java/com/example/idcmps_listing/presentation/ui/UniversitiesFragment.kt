package com.example.idcmps_listing.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idcmps_listing.core.presentation.uimodel.BaseListUIModel
import com.example.idcmps_listing.databinding.FragmentUniversitiesListBinding
import com.example.idcmps_listing.presentation.uimodel.UniversityUIModel
import com.example.idcmps_listing.presentation.viewmodel.UniversitiesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversitiesFragment : Fragment() {

    private var binding: FragmentUniversitiesListBinding? = null
    private val mViewModel: UniversitiesListViewModel by viewModels()
    private val mAdapter by lazy {
        ListItemAdapter(
            ::clickSingleUniversity
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentUniversitiesListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUiViews()
        observeUiViews()
        mViewModel.requestUniversities()
    }

    private fun setUpUiViews() = binding?.apply {
        setupRecyclerView()
        layoutError.viewPartnersButton.setOnClickListener {
            mViewModel.requestUniversities()
        }
    }


    private fun setupRecyclerView() {
        binding?.rvUniversities?.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@UniversitiesFragment.requireContext())
        }
    }

    private fun observeUiViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mViewModel.listResource.collectLatest {
                        handleUiState(it)
                    }
                }
            }
        }

    }

    private fun handleUiState(state: BaseListUIModel<UniversityUIModel>) {
        mAdapter.submitList(state.data)
        binding?.apply {
            pbLoading.isVisible = state.loading
            layoutError.root.isVisible = state.error != null
        }
    }


    private fun clickSingleUniversity(uiModel: UniversityUIModel) {
        findNavController().navigate(UniversitiesFragmentDirections.actionDetailsFragment(uiModel.universityName))
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}