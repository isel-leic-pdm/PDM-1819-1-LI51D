package li51d.i1819.pdm.isel.pt.cloudfirestoresample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

private val TAG = MainActivity::class.java.simpleName
private val BILLBOARD_MESSAGE = "MESSAGE"

class MainActivity : AppCompatActivity() {

    val billboardDocument: DocumentReference = FirebaseFirestore.getInstance().collection("billboard").document("message")
    //val billboardDocument: DocumentReference = FirebaseFirestore.getInstance().document("billboard/message")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billboardDocument.addSnapshotListener(this) { documentSnapshot, firebaseFirestoreException ->
            updateBillboardMessage(documentSnapshot)
        }
    }

    fun saveBillboardMessage(view: View) {
        if (newBillboardMessage.text.isBlank()) {
            return
        }
        val message = mapOf(
            BILLBOARD_MESSAGE to newBillboardMessage.text.toString()
        )

        billboardDocument.set(message).addOnSuccessListener {
            Log.i(TAG, "New billboard document has been saved")
        }.addOnFailureListener {
            Log.w(TAG, "New billboard document NOT saved", it)
        }
    }

    fun fetchBillboardMessage(view: View) {
        billboardDocument.get().addOnSuccessListener {
            updateBillboardMessage(it)
        }.addOnFailureListener {
            Log.w(TAG, "New billboard document NOT saved", it)
        }
    }

    private fun updateBillboardMessage(documentSnapshot: DocumentSnapshot?) {
        if (documentSnapshot != null && documentSnapshot.exists())
            billboardMessage.text = documentSnapshot.getString(BILLBOARD_MESSAGE)
    }
}
