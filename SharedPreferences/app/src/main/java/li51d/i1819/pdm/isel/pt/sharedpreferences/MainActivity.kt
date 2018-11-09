package li51d.i1819.pdm.isel.pt.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val USER_NAME = "user"

class MainActivity : AppCompatActivity() {

    val SP_NAME = MainActivity::class.java.`package`.name + "MY_SP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val preferences = getPreferences(Context.MODE_PRIVATE)
        val preferences = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        currentUser.text = preferences.getString(USER_NAME, "<none>")

        btnSave.setOnClickListener {
            with(preferences.edit()) {
                putString(li51d.i1819.pdm.isel.pt.sharedpreferences.USER_NAME, username.text.toString())
                apply()
            }

            currentUser.text = preferences.getString(USER_NAME, "<none>")
        }
    }
}
