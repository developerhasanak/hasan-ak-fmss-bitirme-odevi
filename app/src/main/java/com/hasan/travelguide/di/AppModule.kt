package com.hasan.travelguide.di


import com.hasan.travelguide.data.remote.TravelAPI
import com.hasan.travelguide.data.repository.TravelRepository
import com.hasan.travelguide.domain.repository.TravelGuideRepositoryInterface
import com.hasan.travelguide.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrotifAPI() : TravelAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(TravelAPI::class.java)
    }

    @Singleton
    @Provides
     fun injectRepository(api: TravelAPI) = TravelRepository(api) as TravelGuideRepositoryInterface


}