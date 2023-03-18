package com.moviemain.model.remote

import com.moviemain.core.common.Constants.DETAILS
import com.moviemain.core.common.Constants.NOW_PLAYING
import com.moviemain.core.common.Constants.POPULAR
import com.moviemain.core.common.Constants.SEARCH
import com.moviemain.core.common.Constants.SIMILAR
import com.moviemain.core.common.Constants.TOP_RATED
import com.moviemain.core.common.Constants.UPCOMING
import com.moviemain.core.common.Constants.VIDEOS
import com.moviemain.model.data.Details
import com.moviemain.model.data.MovieList
import com.moviemain.model.data.SimilarList
import com.moviemain.model.data.VideosList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieList

    @GET(TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieList

    @GET(NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): MovieList

    @GET(UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Response<MovieList>

    @GET(SEARCH)
    suspend fun getMovieByName(
        @Query(value = "") movieSearched: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): MovieList?

    @GET(DETAILS)
    suspend fun getHomepage(
        @Path(value = "movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): Details

    @GET(VIDEOS)
    suspend fun getTrailerMovie(
        @Path(value = "movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): VideosList

    @GET(SIMILAR)
    suspend fun getSimilarMovie(
        @Path(value = "movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
    ): SimilarList
}