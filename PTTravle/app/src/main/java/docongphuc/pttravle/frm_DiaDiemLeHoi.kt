package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import docongphuc.pttravle.HOME.ThanhQuan.LeHoi.frm_TinhThnahLeHoi
import docongphuc.pttravle.HOME.ThanhQuan.LeHoi.frm_hienthi_thongtin_LH
import docongphuc.pttravle.Maps.getLatlng
import docongphuc.pttravle.connect.checkInternet

class frm_DiaDiemLeHoi : Fragment(){
    private var flat: Int = 0;
    var lat: Double = 0.7
    var b: Double = 0.0
    private var btn_tinhthnah: Button? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.frm_diadiemlehoi, container, false);
        btn_tinhthnah = view.findViewById<Button>(R.id.BTN_tinhThanh_LH)
        val fragmentManager = this.activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content_lehoi, frm_hienthi_thongtin_LH()).commit()
        var chekinternet=checkInternet()

        if (chekinternet.checkConnection(this.context) == true) {
            chontinhthanh()
            val fragmentManager = this.activity.supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content_lehoi, frm_hienthi_thongtin_LH()).commit()
        } else {
            Toast.makeText(this.activity, "kiểm tra lại internet của bạn", Toast.LENGTH_SHORT).show()
        }

        return view;
    }


    private fun chontinhthanh() {

        btn_tinhthnah!!.setOnClickListener {
            if (flat==0) {
                flat=1;
                val fragmentManager = this.activity.supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.content_lehoi, frm_TinhThnahLeHoi()).commit()
            }
            else{
                flat=0;
                val fragmentManager =this.activity.supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.content_lehoi, frm_hienthi_thongtin_LH()).commit()
            }

        }
    }
}