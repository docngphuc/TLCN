package docongphuc.pttravle

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import docongphuc.pttravle.HOME.ThanhQuan.frm_hienthi_thongtin
import docongphuc.pttravle.HOME.ThanhQuan.frm_theloai
import docongphuc.pttravle.HOME.ThanhQuan.frm_tinhthanh
import docongphuc.pttravle.Maps.getLatlng
import kotlinx.android.synthetic.main.frm_diadiemdulich.*

class frm_DiaDiemDuLich : Fragment(){
    companion object{
        @JvmStatic
        var a:Double=0.9
    }
    var stchinhanh:getLatlng? = getLatlng()

    private var BtnTheLoai: Button?=null
    private var BtnTinhThanh: Button?=null;
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view =inflater!!.inflate(R.layout.frm_diadiemdulich,container,false);
        BtnTheLoai=view.findViewById<Button>(R.id.btntheloai)
        BtnTinhThanh=view.findViewById<Button>(R.id.btntinhthanh)
        val fragmentManager =this.activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content_dulich, frm_hienthi_thongtin()).commit()
        adfragment()

        stchinhanh= getLatlng()
        stchinhanh!!.execute("117/143/7 nguy huu canh")

        return view;
    }

    private fun adfragment() {
        BtnTinhThanh!!.setOnClickListener({
            Toast.makeText(this.activity,a.toString(), Toast.LENGTH_LONG).show()
            btntinhthanh.setTextColor(Color.RED)
            btntheloai.setTextColor(Color.BLACK)
            val fragmentManager =this.activity.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content_dulich, frm_tinhthanh()).commit()
        })
        BtnTheLoai!!.setOnClickListener({
            btntheloai.setTextColor(Color.RED)
            btntinhthanh.setTextColor(Color.BLACK)
            val fragmentManager =this.activity.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content_dulich, frm_theloai()).commit()
        })
    }
}