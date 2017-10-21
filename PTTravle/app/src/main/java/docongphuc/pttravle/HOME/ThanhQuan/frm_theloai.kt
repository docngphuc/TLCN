package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import docongphuc.pttravle.Maps.getLatlng
import docongphuc.pttravle.R

/**
 * Created by Admin on 29/9/2017.
 */
class frm_theloai :Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_theloai_dulich,container,false)
        var Lv = view.findViewById<ListView>(R.id.lv_theloai_dulich)
        Lv.adapter= ArrayAdapter(this.context,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.theloai))

        return view;
    }
}