package di

import api.ApiConst
import api.CurrencyApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import interceptor.HeaderInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

private val headers: Map<String, String> =
    mapOf("apiKey" to ApiConst.API_KEY)

private val logger = HttpLoggingInterceptor()
    .apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
private val headerInterceptor = HeaderInterceptor(headers)

private val jsonConvertorFactory = Json.asConverterFactory(MediaType.get(ApiConst.CONTENT_TYPE))

@Module
@InstallIn(SingletonComponent::class)
object CoreNetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().addNetworkInterceptor(logger)
            .addNetworkInterceptor(headerInterceptor).build()

    @Singleton
    @Provides
    fun provideCurrencyApi(
        client: OkHttpClient,
    ): CurrencyApi =
        Retrofit.Builder()
            .client(client)
            .baseUrl(ApiConst.BASE_URL)
            .addConverterFactory(jsonConvertorFactory)
            .build()
            .create(CurrencyApi::class.java)
}