package com.raghav.jetstar.data.sources

import com.raghav.jetstar.data.model.MovieResponseDto
import com.raghav.jetstar.data.sources.remote.MovieService
import com.raghav.jetstar.util.Constants
import com.raghav.jetstar.util.Resource
import com.raghav.jetstar.util.safeApiCallHandler
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url

class MovieServiceImpl(
    private val client: HttpClient
) : MovieService {
    override suspend fun getTrending(): Resource<MovieResponseDto> =
        safeApiCallHandler {
            client
                .get {
                    url {
                        url(Constants.ENDPOINT_TRENDING)
                    }
                }
        }

    override suspend fun getPopular(): Resource<MovieResponseDto> =
        safeApiCallHandler {
            client
                .get {
                    url {
                        url(Constants.ENDPOINT_POPULAR)
                    }
                }
        }

    override suspend fun getTopRated(): Resource<MovieResponseDto> =
        safeApiCallHandler {
            client
                .get {
                    url {
                        url(Constants.ENDPOINT_TOP_RATED)
                    }
                }
        }

    override suspend fun getNowPlaying(): Resource<MovieResponseDto> = safeApiCallHandler {
        client
            .get {
                url {
                    url(Constants.ENDPOINT_NOW_PLAYING)
                }
            }
    }
}
