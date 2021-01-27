package com.example.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.article.data.repository.GameRepository
import com.example.game.data.entity.Top
import com.example.game.data.retrofit.ApiFactory
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    val popularGameLiveData = MutableLiveData<MutableList<Top>>()

    fun getPopularGame() {
        viewModelScope.launch {
            val repository: GameRepository = GameRepository(ApiFactory.gameApi)
            var popularGame = repository.getPosts()
            popularGameLiveData.postValue(popularGame)
        }
    }
}