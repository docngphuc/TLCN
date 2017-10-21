package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.Adapter_LVQuanAn
import docongphuc.pttravle.data.QuanHuyen
import docongphuc.pttravle.data.ThongTinQuanAN_DL

/**
 * Created by Admin on 16/10/2017.
 */
class frm_ThongTinNoiO: Fragment() {
    var listanhquanan:ArrayList<QuanHuyen> = ArrayList()
    var listQuanAn:ArrayList<ThongTinQuanAN_DL> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_thong_tin_quan_an,container,false)
        val lvquanan=view.findViewById<ListView>(R.id.LV_ThongTinQuanAn)
        listanhquanan.add(QuanHuyen("http://im.rediff.com/getahead/2016/oct/26lodi.jpg"))
        listanhquanan.add(QuanHuyen("https://www.soelden.com/urlaub/images/SD/WI/headerbilder/aktivitaeten_header_restaurant,method=scale,prop=data,id=1200-510.jpg"))
        listanhquanan.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        listanhquanan.add(QuanHuyen("http://www.stanleyhotel.com/uploads/9/8/6/9/98696462/published/20111115-cascades001v2_3.jpeg?1492712982"))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        listQuanAn.add(ThongTinQuanAN_DL("https://www.scandichotels.com/imagevault/publishedmedia/qn6infvg30381stkubky/scandic-sundsvall-city-restaurant-verket-10.jpg","quan an Chu j","b",listanhquanan,11,123,3.5f))
        val adapter = Adapter_LVQuanAn(this.activity,listQuanAn)
        adapter.notifyDataSetChanged()
        lvquanan.adapter=adapter
//        lvquanan.setOnItemClickListener { adapterView, view, i, l ->
//            Toast.makeText(this.activity,"méo toast" , Toast.LENGTH_SHORT).show();
//        }
        return view
    }
}