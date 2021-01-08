package com.example.muvi.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("vote_average")
    var rate: Float,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var poster: String?,
    @SerializedName("backdrop_path")
    var background: String?,
    @SerializedName("release_date")
    var releaseDate: String,
    @Ignore
    @SerializedName("runtime")
    var runtime: Int?,
    @Ignore
    @SerializedName("video")
    var video : String?,
    @Ignore
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    @Ignore
    @SerializedName("genres")
    var genres: List<Genre>?,
    @Ignore
    @SerializedName("production_companies")
    var productionCompanies: List<Company>?
) : GeneralEntity {

    constructor(
        id: Int,
        title: String,
        rate: Float,
        description: String,
        poster: String?,
        background: String?,
        releaseDate: String
    ) : this(
        id,
        title,
        rate,
        description,
        poster,
        background,
        releaseDate,
        null,
        null,
        listOf(),
        listOf(),
        listOf()
    )

    constructor(movie: Movie) : this(
        id = movie.id,
        title = movie.title,
        rate = movie.rate,
        description = movie.description,
        poster = movie.poster,
        background = movie.background,
        releaseDate = movie.releaseDate,
        runtime = movie.runtime,
        video = movie.video,
        genreIds = movie.genreIds,
        genres = movie.genres,
        productionCompanies = movie.productionCompanies
    )

    override fun areItemsTheSame(newItem: GeneralEntity): Boolean =
        newItem is Movie && this.id == newItem.id

    override fun areContentsTheSame(newItem: GeneralEntity): Boolean =
        newItem is Movie && this == newItem

    fun haveContent() : Boolean{
        if(this.background.isNullOrEmpty() || this.poster.isNullOrEmpty()) return false
        else return true
    }
}
