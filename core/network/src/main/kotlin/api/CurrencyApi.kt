package api

import dto.ExchangeResponseDto
import retrofit2.http.GET


interface CurrencyApi {
    @GET("latest")
    suspend fun getRates(): ExchangeResponseDto
}