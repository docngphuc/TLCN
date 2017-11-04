package docongphuc.pttravle.HOME.ThanhQuan.LeHoi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ExpandableListView
import android.widget.ListView
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.Lv_TTLeHoi
import docongphuc.pttravle.data.ThongTinComment_DL
import docongphuc.pttravle.data.ThongTinDiaDiem_LH

/**
 * Created by Admin on 5/10/2017.
 */
class frm_hienthi_thongtin_LH :Fragment(){
    var arayList_TTLeHoi:ArrayList<ThongTinDiaDiem_LH> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_henthi_thongtinlehoi,container,false)
       val Lv_thongtinlehoi=view.findViewById<ListView>(R.id.LV_ThongTinLeHoi)
      arayList_TTLeHoi.add(ThongTinDiaDiem_LH("Lễ Hội bà chúa Đảo","123/121 phướng bình tiền giang","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpwmVQFAHFpUhJ7Xi-lIGFXMTQhe3T8hMU1KuUMNTRVItvORJD",123133432,232123414,12,23,3.5f))
       var adapter= Lv_TTLeHoi(this.activity,arayList_TTLeHoi)
        adapter.notifyDataSetChanged()
        Lv_thongtinlehoi.adapter=adapter
        return view
    }


}