package com.example.drunkapp.di

import com.example.drunkapp.data.DataSourceImpl
import com.example.drunkapp.domain.DataSourceRepo
import com.example.drunkapp.domain.Repo
import com.example.drunkapp.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class  ActivityModule{
    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl) : Repo

    @Binds
    abstract fun bindDataSourceImpl(dataSourceImpl: DataSourceImpl) : DataSourceRepo
}