package com.github.ergegananputra_jetpack_compose_project_structure_example.di

import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.constants.API_HOST
import com.github.ergegananputra_jetpack_compose_project_structure_example.data.remote.WebContentCollaborationApiService
import com.github.ergegananputra_jetpack_compose_project_structure_example.data.repository.DashboardRepositoryImpl
import com.github.ergegananputra_jetpack_compose_project_structure_example.data.repository.DetailRepositoryImpl
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.entities.local.Kajian
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DahsboardRepository
import com.github.ergegananputra_jetpack_compose_project_structure_example.domain.repository.DetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideWCCApi(client: OkHttpClient): WebContentCollaborationApiService {
        return Retrofit.Builder()
            .baseUrl(API_HOST)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebContentCollaborationApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDashboardRepository(
        api: WebContentCollaborationApiService,
        realm: Realm
    ): DahsboardRepository {
        return DashboardRepositoryImpl(api, realm)
    }

    @Provides
    @Singleton
    fun realmConfig(): RealmConfiguration =
        RealmConfiguration.Builder(
            schema = setOf(
                Kajian::class
            ),
        )
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()


    @Provides
    @Singleton
    fun provideRealm(configuration: RealmConfiguration): Realm = Realm.open(configuration)

    @Provides
    @Singleton
    fun provideDetailRepository(
        realm: Realm
    ): DetailRepository {
        return DetailRepositoryImpl(realm)
    }



}