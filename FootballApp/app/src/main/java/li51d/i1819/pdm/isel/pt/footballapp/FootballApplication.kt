package li51d.i1819.pdm.isel.pt.footballapp

import android.app.Application
import android.util.Log
import li51d.i1819.pdm.isel.pt.footballapp.repository.dataAccess.footballData.FootballDataApiMock
import li51d.i1819.pdm.isel.pt.footballapp.utils.HttpRequests

class FootballApplication: Application() {
    val TAG: String = FootballApplication::class.java.simpleName;

    public lateinit var footballDataRepository: FootballDataRepository
        private set

    override fun onCreate() {
        super.onCreate()

        Log.i(TAG, "onCreate application")
        HttpRequests.init(this)


        footballDataRepository = FootballDataRepository(FootballDataApiMock())
    }
}