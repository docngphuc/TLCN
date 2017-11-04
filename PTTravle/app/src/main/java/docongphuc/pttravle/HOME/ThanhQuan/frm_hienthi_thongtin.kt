package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ListView
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.Lv_TTDuLich
import docongphuc.pttravle.data.ThongTinComment_DL
import docongphuc.pttravle.data.ThongTinDiaDiem_DL

class frm_hienthi_thongtin : Fragment() {
    var arrList_ThongTinDL:ArrayList<ThongTinDiaDiem_DL> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_hienthi_thongtindulich,container,false)
        val Lv_ThongTin =view.findViewById<ListView>(R.id.LV_ThongTinDuLich)
        arrList_ThongTinDL.add(ThongTinDiaDiem_DL("Khu Du Lich Văn Thánh","17/2/nguyễn Hữu Cảnh","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGSnTazJGLpvj5WVFq4WlVl_pghlpGAMbEk5A62R8u25-Fv9CzXw",11,1,2.5f))
        var adapter = Lv_TTDuLich(this.activity, arrList_ThongTinDL)
        adapter.notifyDataSetChanged()
        Lv_ThongTin.adapter=adapter
        return view
    }

}
