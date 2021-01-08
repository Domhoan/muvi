package com.example.muvi.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.muvi.base.RxViewModel
import com.example.muvi.data.model.Movie
import com.example.muvi.data.repository.MovieRepository
import com.example.muvi.utils.GenreUtil
import com.example.muvi.utils.TimeUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class UpComingViewModel(
    private val movieRepository: MovieRepository
) : RxViewModel() {

    private var page = 0

    private val _movie = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>>
        get() = _movie

    init {
        getUpComingMovie()
    }

    fun getUpComingMovie() {
        movieRepository.getUpComingMovie(TimeUtil.getCurrentDate(),++page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    it.map { oneMovie ->
                        val newReleaseDate = TimeUtil.getDateToShow(oneMovie.releaseDate)
                        val newGenre = GenreUtil.getGenreOfMovie(oneMovie.genreIds)
                        oneMovie.releaseDate = newReleaseDate
                        oneMovie.video = newGenre
                        if (oneMovie.background == null){
                            oneMovie.background = oneMovie.poster
                        }
                    }
                    if (page == 1){
                        _movie.value = it as MutableList<Movie>
                    }
                    else _movie.value?.addAll(it)
                },
                {
                    error.value = it.message
                    page--
                }
            )
            .addTo(disposables)
    }
}
