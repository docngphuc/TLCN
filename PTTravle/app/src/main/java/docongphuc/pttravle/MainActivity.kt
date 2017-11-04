package docongphuc.pttravle

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DangNhap.GiaoTiep_DangNhap_MainActivity {


    val KEY_ID_USER = "ID_User"
    var id_USER = ""
    var ten = ""
    var ten_email = ""
    var hinhDaiDien = ""

    val database    : DatabaseReference
    init {
        database    = FirebaseDatabase.getInstance().reference
    }

    override fun truyenUser(uid: String, name: String, email: String, photoUrl: String) {
        id_USER = uid
        ten = name
        ten_email = email
        hinhDaiDien = photoUrl
    }

    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer!!.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        navigationView = findViewById<NavigationView>(R.id.navigation);
        initNavigationDrawer()

        // mac dinh mo trang Home
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content, Home()).commit()

    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun initNavigationDrawer() {
        navigationView!!.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            when (id) {
                R.id.home -> {
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, Home()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.lichtrinh -> {
                    val bundle : Bundle = Bundle()
                    bundle.putString(KEY_ID_USER, id_USER)

                    val lichTrinh = LichTrinh()
                    lichTrinh.arguments = bundle

                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, lichTrinh).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.album -> {

                    val bundle : Bundle = Bundle()
                    bundle.putString(KEY_ID_USER, id_USER)

                    val boSuuTap = BoSuuTap()
                    boSuuTap.arguments = bundle

                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, boSuuTap).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.thongtin -> {
                    val bundle : Bundle = Bundle()
                    bundle.putString(KEY_ID_USER, id_USER)

                    val taiKhoan = TaiKhoan()
                    taiKhoan.arguments = bundle

                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, taiKhoan).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.dangNhapTK -> {
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, DangNhap()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
        actionBarDrawerToggle!!.syncState()
    }


    // hien dong thong bao
    private fun ShortToast(messsage : String) {
        val length : Int = Toast.LENGTH_SHORT
        Toast.makeText(this, messsage, length).show()
    }
}
