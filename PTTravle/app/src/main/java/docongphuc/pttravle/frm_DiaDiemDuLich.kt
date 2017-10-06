package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import docongphuc.pttravle.HOME.ThanhQuan.frm_hienthi_thongtin
import docongphuc.pttravle.HOME.ThanhQuan.frm_theloai
import docongphuc.pttravle.HOME.ThanhQuan.frm_tinhthanh
import kotlinx.android.synthetic.main.frm_diadiemdulich.*

/**
 * Created by Admin on 26/9/2017.
 */
class frm_DiaDiemDuLich : Fragment(){

    private var BtnTheLoai: Button?=null
    private var BtnTinhThanh: Button?=null;
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view =inflater!!.inflate(R.layout.frm_diadiemdulich,container,false);
        BtnTheLoai=view.findViewById(R.id.btntheloai)
        BtnTinhThanh=view.findViewById(R.id.btntinhthanh)
        val fragmentManager =this.activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content_dulich, frm_hienthi_thongtin()).commit()
        adfragment();
        return view;
    }

    private fun adfragment() {
        BtnTinhThanh!!.setOnClickListener({
            btntinhthanh.setTextColor(resources.getColor(R.color.red))
            btntheloai.setTextColor(resources.getColor(R.color.black))
            val fragmentManager =this.activity.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content_dulich, frm_tinhthanh()).commit()
        })
        BtnTheLoai!!.setOnClickListener({
            btntheloai.setTextColor(resources.getColor(R.color.red))
            btntinhthanh.setTextColor(resources.getColor(R.color.black))
            val fragmentManager =this.activity.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content_dulich, frm_theloai()).commit()
        })
    }
}