package docongphuc.pttravle


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Admin on 24/9/2017.
 */
 class Home : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
       val view =inflater!!.inflate(R.layout.frm_home,container,false);
       var pageradapter:PageAdapter= PageAdapter(this.activity.supportFragmentManager);
        pageradapter.addfragment(frm_DiaDiemDuLich());
        pageradapter.addfragment(frm_DiaDiemLeHoi());
        val pager = view.findViewById<ViewPager>(R.id.viewpager);
        pager.adapter = pageradapter;
        return view;
//

    }
}