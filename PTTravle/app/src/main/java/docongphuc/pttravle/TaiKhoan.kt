package docongphuc.pttravle

import android.app.Activity.RESULT_OK
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.OnProgressListener
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.*

class TaiKhoan :Fragment(){

    // Firebase
    val database : DatabaseReference
    val storageref : StorageReference
    init {
        database    = FirebaseDatabase.getInstance().reference
        storageref = FirebaseStorage.getInstance().reference
    }

    val PICK_IMAGE_REQUEST : Int = 71

    var filePath : Uri? = null
    var btnSelect : Button? = null
    var btnUpload : Button? = null
    var image : ImageView? = null

    val KEY_ID_USER = "ID_User"
    var id_User : String = "null"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_add_image,container,false)

        id_User = arguments.getString(KEY_ID_USER,"null")

        btnSelect = view.findViewById(R.id.btnSelect)
        btnUpload = view.findViewById(R.id.btnUpload)
        image = view.findViewById(R.id.img_selected)

        // chon hinh
        btnSelect!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                ChooseImage()
            }
        })

        // dang hinh len firebase
        btnUpload!!.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (id_User != "null"){
                    UploadImage()
                }
                else{
                    ShortToast("Chưa đăng nhập")
                }
            }
        })


        return view
    }

    private fun UploadImage() {
        if (filePath != null){
            val id_random = UUID.randomUUID().toString()
            val dialog: ProgressDialog = ProgressDialog(activity)
            dialog.setTitle("Uploading...")
            dialog.show()

            //val ref : StorageReference = storageref.child("image/" + id_random)
            val ref : StorageReference = storageref.child(id_User + "/image_" + id_random + ".png")
            ref.putFile(filePath!!)
                    .addOnSuccessListener (OnSuccessListener {taskSnapshot ->
                        dialog.dismiss()
                        UploadImageAlbum(taskSnapshot.downloadUrl.toString(), id_User)
                    })
                    .addOnFailureListener(OnFailureListener {
                        dialog.dismiss()
                        ShortToast("Fail")
                    })
                    .addOnProgressListener(OnProgressListener {taskSnapshot ->
                        val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount
                        dialog.setMessage("Loading " + progress + " %")
                    })
        }
    }

    private fun UploadImageAlbum(imageURL: String, id_User: String?) {
        database.child("Album").child(id_User).push().setValue(imageURL)
        ShortToast("Success")
    }

    private fun ChooseImage() {
        val intent : Intent =  Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent,"select picture"),PICK_IMAGE_REQUEST)
//        startActivity(Intent.createChooser(intent,"select picture"))

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!!.data != null){

            filePath = data.data
            image!!.setImageBitmap(null)
            try {
                val bm = BitmapFactory.decodeStream(this.context.contentResolver.openInputStream(filePath))
                image!!.setImageBitmap(bm)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    // hien dong thong bao
    private fun ShortToast(messsage : String) {
        val length : Int = Toast.LENGTH_SHORT
        Toast.makeText(activity, messsage, length).show()
    }
}