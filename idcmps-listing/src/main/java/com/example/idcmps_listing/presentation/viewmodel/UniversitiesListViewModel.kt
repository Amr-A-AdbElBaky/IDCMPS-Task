package com.example.idcmps_listing.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idcmps_listing.core.presentation.uimodel.BaseListUIModel
import com.example.idcmps_listing.domain.interactors.GetUniversitiesUseCase
import com.example.idcmps_listing.presentation.uimodel.UniversityUIModel
import com.example.idcmps_listing.presentation.uimodel.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class UniversitiesListViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
): ViewModel() {

    
    private val _listResource : MutableStateFlow<BaseListUIModel<UniversityUIModel>> = MutableStateFlow(BaseListUIModel(data = listOf()))
    val listResource = _listResource.asStateFlow()

     fun requestUniversities() = getUniversitiesUseCase.invoke()
        .onStart { _listResource.emit(_listResource.value.copy(loading = true , error = null)) }
        .map { it.map { it.toUI()  }}
        .onEach { _listResource.emit(_listResource.value.copy(data = it, loading = false)) }
        .catch {_listResource.emit(_listResource.value.copy(error = it, loading = false)) }
        .flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)
    

}