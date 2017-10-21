package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.PagerAdapter_Hinhanh
import docongphuc.pttravle.data.QuanHuyen

/**
 * Created by Admin on 11/10/2017.
 */
class frm_thongtin_chitiet : Fragment() {
    var Arraychild:ArrayList<QuanHuyen>?= ArrayList();

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_thongtinchitiet_dddl,container,false)
        var viepager=view.findViewById<ViewPager>(R.id.ViewPager_Hinhanh_chitiet);
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        var adapter:PagerAdapter= PagerAdapter_Hinhanh(this.context,Arraychild!!)
        viepager.adapter=adapter
        return view;
    }
}