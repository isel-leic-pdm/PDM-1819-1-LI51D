package li51d.i1819.pdm.isel.pt.usingvolley

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import li51d.i1819.pdm.isel.pt.usingvolley.data.HttpRequests
import li51d.i1819.pdm.isel.pt.usingvolley.data.HttpRequests.get

const val URL = "http://api.football-data.org/v2/competitions"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HttpRequests.init(this)
        getLeagues.setOnClickListener {
            get(URL) {
                    str -> leaguesText.text = str
            }
        }
    }

}
