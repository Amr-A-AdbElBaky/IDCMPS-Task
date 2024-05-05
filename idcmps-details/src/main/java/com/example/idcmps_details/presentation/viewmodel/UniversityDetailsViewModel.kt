package com.example.idcmps_details.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idcmps_details.domain.entity.UniversityDetailsEntity
import com.example.idcmps_details.domain.interactors.GetUniversityDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UniversityDetailsViewModel @Inject constructor(
    private val getUniversityDetailsUseCase: GetUniversityDetailsUseCase
): ViewModel() {

    
    private val _detailsResource : MutableStateFlow<UniversityDetailsEntity> = MutableStateFlow(UniversityDetailsEntity())
    val detailsResource = _detailsResource.asStateFlow()

     fun requestUniversityDetails(universityName: String) {
         getUniversityDetailsUseCase.invoke(universityName)
             .onEach { _detailsResource.emit(it) }
             .flowOn(Dispatchers.IO)
             .launchIn(viewModelScope)
     }
    

}