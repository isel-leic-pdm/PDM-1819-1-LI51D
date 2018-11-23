package li51d.i1819.pdm.isel.pt.roomwordsample.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import li51d.i1819.pdm.isel.pt.roomwordsample.R
import li51d.i1819.pdm.isel.pt.roomwordsample.repository.dataAccess.database.Word
import li51d.i1819.pdm.isel.pt.roomwordsample.utils.viewModel
import li51d.i1819.pdm.isel.pt.roomwordsample.view.adapters.WordListAdapter
import li51d.i1819.pdm.isel.pt.roomwordsample.view.viewModel.WordListViewModel


const val newWordActivityRequestCode = 1

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: WordListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener(::launchNewWordActivity)

        viewModel = this.viewModel()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(this, viewModel.allWords)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val word = Word(it.getStringExtra(NewWordActivity.EXTRA_REPLY))
                viewModel.insert(word)
            }
        } else {
            Toast.makeText(this,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }

    fun launchNewWordActivity(view: View) {
        val intent = Intent(this@MainActivity, NewWordActivity::class.java)
        startActivityForResult(intent, newWordActivityRequestCode)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
