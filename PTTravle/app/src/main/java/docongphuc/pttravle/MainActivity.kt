package docongphuc.pttravle

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private var drawerLayout: DrawerLayout? = null
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null
    //private  var manager = supportFragmentManager;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        //drawerLayout = findViewById<DrawerLayout>(R.id.drawer);
        drawer!!.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        navigationView = findViewById<NavigationView>(R.id.navigation);
        initNavigationDrawer();
        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content, Home()).commit()
        drawer!!.closeDrawer(GravityCompat.START)

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
                    var fragmentManager = supportFragmentManager
                    var transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, Home()).commit()
                    drawer!!.closeDrawer(GravityCompat.START)
                }
                R.id.lichtrinh -> {
                    val fragmentManager = supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.content, LichTrinh()).commit()
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



}
