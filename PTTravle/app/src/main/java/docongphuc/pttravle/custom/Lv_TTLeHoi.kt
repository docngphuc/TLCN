package docongphuc.pttravle.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import docongphuc.pttravle.R
import docongphuc.pttravle.data.ThongTinDiaDiem_LH
import java.text.SimpleDateFormat

/**
 * Created by Admin on 2/11/2017.
 */
class Lv_TTLeHoi (var context: Context,var arayList_TTLH:ArrayList<ThongTinDiaDiem_LH> ) : BaseAdapter() {
    class viewHolder(row : View){

        var anhdaidien: ImageView
        var tenDD: TextView
        var diachi: TextView
        var btn_like: ImageButton
        var danhgia: RatingBar
        var soluoclike: TextView
        var btn_comment: ImageButton
        var soComment: TextView
        var anh: ImageView
        var NgayBD:TextView
        var NgayKT:TextView
        init {
            anhdaidien=row.findViewById(R.id.AnhDaiDien_LH)
            tenDD=row.findViewById(R.id.TenDiaDiem_LH)
            diachi=row.findViewById(R.id.DiaChi_LH)
            anh=row.findViewById(R.id.Anh_LH)
            NgayBD=row.findViewById(R.id.NgayBatDau_LeHoi)
            NgayKT=row.findViewById(R.id.NgayKetThuc_LeHoi)
            btn_like=row.findViewById(R.id.Btn_Like_LH)
            danhgia=row.findViewById(R.id.DanhGia_LH)
            soluoclike = row.findViewById(R.id.SoLuotLike_LH)
            soComment=row.findViewById(R.id.SoComment_LH)
            btn_comment=row.findViewById(R.id.Btn_Comment_LH)
        }

    }
    override fun getView(position: Int, convertview: View?, p2: ViewGroup?): View {
        val view: View?
        val viewholder: Lv_TTLeHoi.viewHolder
        if (convertview == null) {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.row_thongtin_lehoi, null)
            viewholder = Lv_TTLeHoi.viewHolder(view)
            view.tag = viewholder
        } else {
            view = convertview
            viewholder = convertview.tag as viewHolder
        }
        viewholder.tenDD.text=arayList_TTLH.get(position).TenDiaDiem
        viewholder.diachi.text = arayList_TTLH.get(position).DiaChi
        Glide.with(context).load(arayList_TTLH!!.get(position).url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.wellcom0)
                .into(viewholder.anh)
        Glide.with(context).load(arayList_TTLH!!.get(position).url)
                .centerCrop()
                .error(R.drawable.wellcom0)
                .into(viewholder.anhdaidien)
        val sdf_date_bd : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        val sdf_date_bd1 : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
        var ngaybd =sdf_date_bd.format(arayList_TTLH.get(position).NgayBacDau)
        val ngaykt=sdf_date_bd1.format(arayList_TTLH.get(position).NgayKetThuc)
        viewholder.NgayKT.text=ngaykt.toString()
        viewholder.NgayBD.text=ngaybd.toString()
        viewholder.soluoclike.text=arayList_TTLH.get(position).LuocLike.toString()
        viewholder.danhgia.rating=arayList_TTLH.get(position).DanhGia
        viewholder.soluoclike.text = arayList_TTLH.get(position).SoCmmt.toString()
        return view as View
    }

    override fun getItem(p0: Int): Any {
        return arayList_TTLH.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arayList_TTLH.size
    }


}