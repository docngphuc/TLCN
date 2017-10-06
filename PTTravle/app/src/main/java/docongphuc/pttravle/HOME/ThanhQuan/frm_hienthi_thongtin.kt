package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import docongphuc.pttravle.R

/**
 * Created by Admin on 29/9/2017.
 */
class frm_hienthi_thongtin : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_hienthi_thongtindulich,container,false)
        return view;
    }
}