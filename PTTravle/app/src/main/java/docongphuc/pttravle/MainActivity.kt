package docongphuc.pttravle

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val KEY_ID_USER = "ID_User"
    val list_ID_User : ArrayList<String> = ArrayList()
    var id_USER = ""

    val database    : DatabaseReference

    init {
        database    = FirebaseDatabase.getInstance().reference
    }

    //private var drawerLayout: DrawerLayout? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null
    //private  var manager = supportFragmentManager;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Lay_ID_User()

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        //drawerLayout = findViewById<DrawerLayout>(R.id.drawer);
        drawer!!.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        navigationView = findViewById<NavigationView>(R.id.navigation);
        initNavigationDrawer();
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content, Home()).commit()
        //drawer!!.closeDrawer(GravityCompat.START)

    }

    private fun Lay_ID_User() {
        database.child("Users").addChildEventListener(object : ChildEventListener {

            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                list_ID_User.add(p0.key)
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                list_ID_User.add(p0.key)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    override fun onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
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
                    //frm_DiaDiemLeHoi.a=1.100010
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, Home()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.lichtrinh -> {
                    id_USER = list_ID_User[1]

                    val bundle : Bundle = Bundle()
                    bundle.putString(KEY_ID_USER, id_USER)

                    val lichTrinh = LichTrinh()
                    lichTrinh.arguments = bundle

                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, lichTrinh).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.trangcanhan -> {
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, TrangCaNhan()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.thongtin -> {
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, TaiKhoan()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.dangxuat -> {
                    menuItem.title="Đăng Nhập"
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
