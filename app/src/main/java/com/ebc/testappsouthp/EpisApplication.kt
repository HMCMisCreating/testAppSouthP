package com.ebc.testappsouthp

import android.app.Application
import com.ebc.testappsouthp.data.EpisContainer
import com.ebc.testappsouthp.data.DefaultEpisContainer

class EpisodesApplication: Application() {
    lateinit var container: EpisContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultEpisContainer()
    }
}