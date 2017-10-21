package docongphuc.pttravle.HOME.ThanhQuan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import docongphuc.pttravle.Maps.MapsActivity
import docongphuc.pttravle.R

class ThongTinChiTiet_DDDL : AppCompatActivity() {
    var btn_ThongTin:Button?=null
    var btn_QuanAn:Button?=null
    var btn_NoiO:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thong_tin_chi_tiet__dddl)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        btn_ThongTin=findViewById<Button>(R.id.btn_ThongTinCT)
         btn_QuanAn=findViewById<Button>(R.id.btn_QuanAn)
         btn_NoiO=findViewById<Button>(R.id.btn_NoiO)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.TTCT_DDDL, frm_thongtin_chitiet()).commit()
        adfragment()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater!!.inflate(R.menu.buttonactionbar,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        when (id) {
            R.id.map -> {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
            android.R.id.home ->{
                finish()
            }

        }

        return true
    }
    private fun adfragment() {
        btn_QuanAn!!.setOnClickListener({
            val fragmentManager =supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.TTCT_DDDL, frm_ThongTinQuanAn()).commit()
        })
        btn_ThongTin!!.setOnClickListener({
            val fragmentManager =supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.TTCT_DDDL, frm_thongtin_chitiet()).commit()
        })
        btn_NoiO!!.setOnClickListener({
            val fragmentManager =supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.TTCT_DDDL, frm_ThongTinNoiO()).commit()
        })
    }
}
