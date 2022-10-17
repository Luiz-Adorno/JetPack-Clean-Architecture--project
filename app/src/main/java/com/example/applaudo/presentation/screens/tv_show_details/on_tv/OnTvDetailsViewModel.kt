package com.example.applaudo.presentation.screens.tv_show_details.on_tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applaudo.data.local.db.OnTvTvShowCache
import com.example.applaudo.data.local.db.PopularTvShowCache
import com.example.applaudo.domain.use_cases.TvShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnTvDetailsViewModel @Inject constructor(
    private val tvShowUseCase: TvShowUseCase
) : ViewModel() {
    private val _selectedMovie: MutableStateFlow<OnTvTvShowCache?> = MutableStateFlow(null)
    val selectedMovie: StateFlow<OnTvTvShowCache?> = _selectedMovie

    fun getTvShowDetails(movieID: Int) {
        viewModelScope.launch {
            tvShowUseCase.getOnTvTvShowsFromDbUseCase.invoke(movieID = movieID).collect {
                _selectedMovie.value = it
            }
        }
    }
}