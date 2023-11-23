package com.hagos.database.di

import android.content.Context
import androidx.room.Room
import com.hagos.database.Dao
import com.hagos.database.NavDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NavDataBase =
        Room.databaseBuilder(context, NavDataBase::class.java, "nav_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDao(database: NavDataBase): Dao = database.dao()

}