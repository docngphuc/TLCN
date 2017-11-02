package docongphuc.pttravle.HOME.ThanhQuan

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.Expd_ThongTinDuLich
import docongphuc.pttravle.data.ThongTinComment_DL
import docongphuc.pttravle.data.ThongTinDiaDiem_DL

class frm_hienthi_thongtin : Fragment() {
    //lateinit var adapter:Expd_ThongTinDuLich
    //private var ExpandbleLV: ExpandableListView?= null
    var Arraychild:ArrayList<ThongTinComment_DL>?= ArrayList();
    var HasMap:HashMap<ThongTinDiaDiem_DL,ArrayList<ThongTinComment_DL>>?= HashMap()
    var ArrayHeader : ArrayList<ThongTinDiaDiem_DL>?= ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_hienthi_thongtindulich,container,false)
        var ExpandbleLV=view.findViewById<ExpandableListView>(R.id.expd_thongtinDDDL)
//        Arraychild=ArrayList();
//        HasMap=HashMap()
//        ArrayHeader = ArrayList()
        var adapter=Expd_ThongTinDuLich(this.activity,ArrayHeader!!,HasMap!!)

        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich van thanh","122/2/3/4/3/4/nguyenhuucanh/p22","https://www.w3schools.com/css/img_fjords.jpg","123","123",3.4f))
        Arraychild!!.add(ThongTinComment_DL("nguak","rất đẹp b=và có cái gì đó trong rất thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công","http://www.daikynguyenvn.com/wp-content/uploads/2016/05/Nhung-chu-cho-dang-yeu-14-620x353.jpg","3 phút tước"))
        Arraychild!!.add(ThongTinComment_DL("Nguhghe","rất đaaaaaaaaaaaaaaaa thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công","https://i.ytimg.com/vi/ftxGKhNMCCE/maxresdefault.jpg","7 ngày trước"))
        HasMap!!.put(ArrayHeader!![0],Arraychild!!)
        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du Bình quới","122/2/3/4/3/4/nguyenhuucanh/p22","http://media.dulich24.com.vn/diemden/khu-du-lich-van-thanh-7140/khu-du-lich-van-thanh-1.jpg","123","123",3.4f))
        Arraychild!!.add(ThongTinComment_DL("nguak","rất đẹp b=và có cái gì đó trong rất thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công","https://lh3.googleusercontent.com/-sQdyWFwBwts/VqC4FJm4WeI/AAAAAAAAWJE/k3T0PtY5zyQ/s600-Ic42/h%2525C3%2525ACnh-%2525E1%2525BA%2525A3nh-ch%2525C3%2525B3-m%2525E1%2525BA%2525B7t-x%2525E1%2525BB%252587-d%2525E1%2525BB%252585-th%2525C6%2525B0%2525C6%2525A1ng-11.jpg"," 4 phút tước"))
        Arraychild!!.add(ThongTinComment_DL("Nguhghe","rất đaaaaaaaaaaaaaaaa thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công","http://cms.kienthuc.net.vn/uploaded/tuyetmai/2015_06_23/cng%20dong/cho/bo-anh-ngo-nghinh-50-sac-thai-cua-nhung-chu-cho-hinh-3.jpg","5 ngày tước"))
        //adapter=Expd_ThongTinDuLich(activity,ArrayHeader!!,HasMap!!)
        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich cửu chi","122/2/3/4/3/4/nguyenhuucanh/p22","https://www.w3schools.com/css/img_fjords.jpg","123","123",3.4f))
        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich van thanh","122/2/3/4/3/4/nguyenhuucanh/p22","https://www.w3schools.com/css/img_fjords.jpg","123","123",3.4f))
        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich van thanh","122/2/3/4/3/4/nguyenhuucanh/p22","https://www.w3schools.com/css/img_fjords.jpg","123","123",3.4f))
        ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich van thanh","122/2/3/4/3/4/nguyenhuucanh/p22","https://www.w3schools.com/css/img_fjords.jpg","123","123",3.4f))

        HasMap!!.put(ArrayHeader!![1],Arraychild!!)
        HasMap!!.put(ArrayHeader!![2],Arraychild!!)
        HasMap!!.put(ArrayHeader!![3],Arraychild!!)
        HasMap!!.put(ArrayHeader!![4],Arraychild!!)
        HasMap!!.put(ArrayHeader!![5],Arraychild!!)

        adapter.notifyDataSetChanged();
        ExpandbleLV!!.setAdapter(adapter)

//        ExpandbleLV.setOnGroupClickListener() { parent, v, groupPosition, id ->
//            // Toast.makeText(this.activity, groupPosition.toString(), Toast.LENGTH_SHORT).show();
//            val intent = Intent(this.activity, ThongTinChiTiet_DDDL::class.java)
//            startActivity(intent)
//            true
//        }
        return view
    }

//     fun click(){
//
//         ExpandbleLV!!.setOnGroupClickListener( { parent, v, groupPosition, id ->
//             parent.expandGroup(groupPosition)
//             Toast.makeText(activity, ArrayHeader!!.get(0).DiaChi, Toast.LENGTH_LONG).show()
//             false
//         })
//     }

//    inner class load constructor(var activity:Activity, var adapter:Expd_ThongTinDuLich):AsyncTask<String,Void,Bitmap>() {
//
//        override fun doInBackground(vararg p0: String?): Bitmap {
//
//            val url=URL(p0[0])
//            val inputstrem=url.openConnection().getInputStream()
//            val BitMap :Bitmap=BitmapFactory.decodeStream(inputstrem)
//            return BitMap;
//        }
//
//        override fun onPostExecute(result: Bitmap?) {
//            super.onPostExecute(result)
//            ArrayHeader!!.add(ThongTinDiaDiem_DL("khu du lich van thanh","122/2/3/4/3/4/nguyenhuucanh/p22",result!!,"123","123",3.4f))
//            Arraychild!!.add(ThongTinComment_DL("nguak","rất đẹp b=và có cái gì đó trong rất thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công"))
//            Arraychild!!.add(ThongTinComment_DL("Nguhghe","rất đaaaaaaaaaaaaaaaa thiên nhiên tôi nghĩ là lần này ming là nó sẽ thành công"))
//            HasMap!!.put(ArrayHeader!![0],Arraychild!!)
//            adapter=Expd_ThongTinDuLich(activity,ArrayHeader!!,HasMap!!)
//            adapter.notifyDataSetChanged();
//            ExpandbleLV!!.setAdapter(adapter)
//
//        }
//    }
}