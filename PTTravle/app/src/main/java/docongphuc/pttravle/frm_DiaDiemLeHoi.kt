package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class frm_DiaDiemLeHoi : Fragment(){
        var lat:Double=0.7
        var b:Double=0.0

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
           val view =inflater!!.inflate(R.layout.frm_diadiemlehoi,container,false);

        return view;
    }
}