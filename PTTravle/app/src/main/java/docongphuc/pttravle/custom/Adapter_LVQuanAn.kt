package docongphuc.pttravle.custom

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import docongphuc.pttravle.R
import docongphuc.pttravle.data.ThongTinQuanAN_DL

class Adapter_LVQuanAn constructor(var context:Context, var ArrList:ArrayList<ThongTinQuanAN_DL>): BaseAdapter() {
    class ViewHolder(row: View){
        var anhdaidien:ImageView
        var tenquan:TextView
        var diachi:TextView
        var viewpager:ViewPager
        var btn_like:ImageButton
        var danhgia:RatingBar
        var soluoclike:TextView
        init {
            anhdaidien=row.findViewById(R.id.AnhDaiDien_QuanAn)
            tenquan=row.findViewById(R.id.TenQuanAN)
            diachi=row.findViewById(R.id.DiaChi_QuanAn)
            viewpager=row.findViewById(R.id.ViewPager_Hinhanh_QuanAn)
            btn_like=row.findViewById(R.id.Btn_Like_QuanAn)
            danhgia=row.findViewById(R.id.DanhGia_QuanAn)
            soluoclike = row.findViewById(R.id.SoLuotLike_QuanAn)
        }
    }
    override fun getView(position: Int, convertview: View?, p2: ViewGroup?): View {
        var view:View?
        var viewholder:ViewHolder
        if (convertview==null)
        {
            var layoutInflater:LayoutInflater= LayoutInflater.from(context)
            view=layoutInflater.inflate(R.layout.row_thong_tin_quan_an, null)
            viewholder= ViewHolder(view)
            view.tag=viewholder
        }
        else{
            view=convertview
            viewholder= convertview.tag as ViewHolder
        }
        viewholder.tenquan.text=ArrList.get(position).TenQuan
        viewholder.diachi.text = ArrList.get(position).DiaChi
        Glide.with(context).load(ArrList!!.get(position).Url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.wellcom0)
                .into(viewholder.anhdaidien)
        viewholder.soluoclike.text=ArrList.get(position).LuocLike.toString()
        viewholder.danhgia.rating=ArrList.get(position).DanhGia
        val adapter: PagerAdapter = PagerAdapter_Hinhanh(this.context,ArrList.get(position).ListAnh)
        viewholder.viewpager.adapter=adapter
        return view as View
    }

    override fun getItem(position: Int): Any {
        return ArrList.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return ArrList.size
    }
}