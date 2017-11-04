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
import docongphuc.pttravle.data.ThongTinDiaDiem_DL

/**
 * Created by Admin on 2/11/2017.
 */
class Lv_TTDuLich(var context:Context,var arrayList:ArrayList<ThongTinDiaDiem_DL>) : BaseAdapter() {
    class viewHolder(row :View){

        var anhdaidien: ImageView
        var tenDD: TextView
        var diachi: TextView
        var btn_like: ImageButton
        var danhgia: RatingBar
        var soluoclike: TextView
        var btn_comment:ImageButton
        var soComment:TextView
        var anh:ImageView
        init {
            anhdaidien=row.findViewById(R.id.AnhDaijDien_DL)
            tenDD=row.findViewById(R.id.TenDiaDiem_DL)
            diachi=row.findViewById(R.id.DiaChi_DL)
            anh=row.findViewById(R.id.Anh_DL)
            btn_like=row.findViewById(R.id.Btn_Like)
            danhgia=row.findViewById(R.id.DanhGia)
            soluoclike = row.findViewById(R.id.SoLuotLike)
            soComment=row.findViewById(R.id.SoComment)
            btn_comment=row.findViewById(R.id.Btn_Comment)
            }

    }
    override fun getView(position: Int, convertview: View?, p2: ViewGroup?): View {
        var view:View?
        var viewHolder: Lv_TTDuLich.viewHolder
        if (convertview==null)
        {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view=layoutInflater.inflate(R.layout.row_thongtindulich, null)
            viewHolder= Lv_TTDuLich.viewHolder(view)
            view.tag=viewHolder
        }
        else{
            view=convertview
            viewHolder= convertview.tag as viewHolder
        }
        viewHolder.tenDD.text=arrayList.get(position).TenDiaDiem
        viewHolder.diachi.text = arrayList.get(position).DiaChi
        Glide.with(context).load(arrayList!!.get(position).url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.wellcom0)
                .into(viewHolder.anh)
        Glide.with(context).load(arrayList!!.get(position).url)
                .centerCrop()
                .error(R.drawable.wellcom0)
                .into(viewHolder.anhdaidien)
        viewHolder.soluoclike.text=arrayList.get(position).LuocLike.toString()
        viewHolder.danhgia.rating=arrayList.get(position).DanhGia
        viewHolder.soluoclike.text = arrayList.get(position).SoCmmt.toString()
        return view as View
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}