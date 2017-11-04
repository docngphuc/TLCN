package docongphuc.pttravle.HOME.ThanhQuan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import docongphuc.pttravle.R
import android.graphics.drawable.ColorDrawable
import android.widget.ArrayAdapter
import android.widget.ListView


class ThongTinComment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thong_tin_comment)
        var actionBar : ActionBar? = getSupportActionBar()
        actionBar!!.hide()
        var Lv=findViewById<ListView>(R.id.LV_TTComment)
        Lv.adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.theloai))
    }
}
