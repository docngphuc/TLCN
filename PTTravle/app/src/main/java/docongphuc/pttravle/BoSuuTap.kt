package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import docongphuc.pttravle.custom.AlbumAdapter
import docongphuc.pttravle.data.ListItemAlbum


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
    var listAlbum : ListView? = null
    lateinit var adapter : AlbumAdapter
    val listImage : ArrayList<ListItemAlbum> = ArrayList()
    val listURL : ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.frm_album, container, false)

        id_User = arguments.getString(KEY_ID_USER,"null")

        btnDownload = view.findViewById(R.id.btnDownload)
        imageDownload = view.findViewById(R.id.img_download)
        listAlbum = view.findViewById(R.id.list_album)

        LoadAlbum()
        adapter = AlbumAdapter(activity,listImage)
        listAlbum!!.adapter = adapter
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
        Glide.with(activity)
                .load(listURL[0])
                .asBitmap()
                .into(imageDownload)
    }

    private fun LoadAlbum() {
        database.child("Album").child(id_User).addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {}
            override fun onChildRemoved(p0: DataSnapshot?) {}

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val image = p0!!.value.toString()
                val l : ListItemAlbum = ListItemAlbum()
                l.setUrl(image)
                listURL.add(image)
                listImage.add(l)
            }
        })
    }

    // hien dong thong bao
    private fun ShortToast(messsage : String) {
        val length : Int = Toast.LENGTH_SHORT
        Toast.makeText(activity, messsage, length).show()
    }
}