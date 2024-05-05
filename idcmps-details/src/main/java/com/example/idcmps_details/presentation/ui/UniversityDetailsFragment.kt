package com.example.idcmps_details.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.idcmps_details.databinding.FragmentUniversityDetailsBinding
import com.example.idcmps_details.domain.entity.UniversityDetailsEntity
import com.example.idcmps_details.presentation.viewmodel.UniversityDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversityDetailsFragment : Fragment() {

    private var binding: FragmentUniversityDetailsBinding? = null
    private val mViewModel: UniversityDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentUniversityDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiViews()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.requestUniversityDetails(
            arguments?.getString("universityName") ?: ""
        )
    }

    private fun observeUiViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    mViewModel.detailsResource.collectLatest {
                        showUi(it)
                    }
                }
            }
        }

    }

    private fun showUi(details: UniversityDetailsEntity) {
        binding?.apply {
            with(details) {
                tvUniversityName.text = name
                tvUniversityState.text = stateProvince
                tvCountry.text = country
                tvCode.text = code
                tvWebsite.text = webPage
            }
        }
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}