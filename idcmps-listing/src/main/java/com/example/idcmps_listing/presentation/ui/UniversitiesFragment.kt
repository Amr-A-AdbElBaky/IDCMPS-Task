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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.idcmps_listing.core.presentation.uimodel.BaseListUIModel
import com.example.idcmps_listing.databinding.FragmentUniversitiesListBinding
import com.example.idcmps_listing.presentation.uimodel.ItemUIModel
import com.example.idcmps_listing.presentation.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversitiesFragment : Fragment() {

    private var binding: FragmentUniversitiesListBinding? = null
    private val mViewModel: ListViewModel by viewModels()
    private val mAdapter by lazy {
        ListItemAdapter(
            ::clickSingleLabTest
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
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.requestUniversities()
    }

    private fun setUpUiViews() = binding?.apply {
        setupRecyclerView()
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

    private fun handleUiState(state: BaseListUIModel<ItemUIModel>) {
        mAdapter.submitList(state.data)
        binding?.apply {
            pbLoading.isVisible = state.loading
            layoutError.root.isVisible = state.error!= null
        }
    }


    fun clickSingleLabTest(uiModel: ItemUIModel) {
//        if (viewModel.getLabDetailsFlag.not()) return
//        if (true) return // Need to remove when details is finished.
/*        val type = UiNormalLabTest.mapType("lab.interpretationStatus")
        mNavController.navigateToDeepLink(DeepLinkDestination.EntryMyLabsCategories)*/

        /*      goToScreen(
                  LabFragmentDirections.actionNavLabCategory(
                      null
             *//*         ParamLabDetailsModel(
                    testCode = "lab.testCode",
                    normalRange = "lab.normalReferenceRange",
                    testName = "lab.testName",
                    testType = type.ordinal,
                    testUnit = "lab.resultUnit",
                    testValue = "lab.resultValue",
                    resultReading = "lab.interpretation",
                    testDate = "lab.resultDate",
                    testNameEn = "lab.testNameEn",
                    isGraphable = *//**//*lab.isGraphable ?:*//**//* true,
                    requestedDate = "lab.requestDate",
                    interpretation = "lab.interpretation",
                    yAxisMin = *//**//*lab.graphInfo?.yMin*//**//*null,
                    yAxisMax = *//**//*lab.graphInfo?.yMax*//**//* null,
                )*//*
            )
        )*/
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}