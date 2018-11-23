package li51d.i1819.pdm.isel.pt.footballapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_competitions.*
import li51d.i1819.pdm.isel.pt.footballapp.R
import li51d.i1819.pdm.isel.pt.footballapp.utils.HttpRequests
import li51d.i1819.pdm.isel.pt.footballapp.utils.viewModel
import li51d.i1819.pdm.isel.pt.footballapp.view.viewModel.CompetitionsActivityViewModel

class CompetitionsActivity : AppCompatActivity() {
    private val TAG: String = CompetitionsActivity::class.java.simpleName

    private lateinit var layoutMgr: RecyclerView.LayoutManager
    private lateinit var competitionsAdapter: CompetitionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competitions)

        val viewModel = this.viewModel<CompetitionsActivityViewModel>()

        layoutMgr = LinearLayoutManager(this)
        competitionsAdapter = CompetitionAdapter(this, viewModel.competitions)

        competitions.apply {
            setHasFixedSize(true)
            layoutManager = layoutMgr
            adapter = competitionsAdapter
        }

        competitionsAdapter.setOnItemClickListener {
            Log.i(TAG,"User clicked on competition $it")
        }
    }
}
