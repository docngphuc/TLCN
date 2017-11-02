package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File





class BoSuuTap : Fragment(){

    // Firebase
    val database : DatabaseReference
    val storageref : StorageReference
    init {
        database    = FirebaseDatabase.getInstance().reference
        storageref = FirebaseStorage.getInstance().reference
    }

    val KEY_ID_USER = "ID_User"
    var id_User : String = "null"

    var btnDownload : Button? = null
    var imageDownload : ImageView? = null

    val listImage : ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.frm_album, container, false)

        id_User = arguments.getString(KEY_ID_USER,"null")

        btnDownload = view.findViewById(R.id.btnDownload)
        imageDownload = view.findViewById(R.id.img_download)

        LoadAlbum()

        // Download hinh
        btnDownload!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (id_User != "null"){
                    ShowImage()
                }
                else{
                    ShortToast("Chưa đăng nhập")
                }
            }
        })

        return view
    }

    private fun ShowImage() {
        val localFile : File = File.createTempFile(listImage[0],"png")
        storageref.getFile(localFile)
                .addOnSuccessListener({
//                    Glide.with(activity)
//                            .using(FirebaseImageLoader())
//                            .load(storageref.downloadUrl)
//                            .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                            .into(mImageQuestion)
                })
                .addOnFailureListener({
                })
    }

    private fun LoadAlbum() {
        database.child("Album").child(id_User).addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {}
            override fun onChildRemoved(p0: DataSnapshot?) {}

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val image = p0!!.value.toString()
                listImage.add(image)
            }
        })
    }

    // hien dong thong bao
    private fun ShortToast(messsage : String) {
        val length : Int = Toast.LENGTH_SHORT
        Toast.makeText(activity, messsage, length).show()
    }
}