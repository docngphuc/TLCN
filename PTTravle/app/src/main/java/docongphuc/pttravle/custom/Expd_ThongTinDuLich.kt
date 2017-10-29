package docongphuc.pttravle.custom

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import docongphuc.pttravle.HOME.ThanhQuan.ThongTinChiTiet_DDDL
import docongphuc.pttravle.R
import docongphuc.pttravle.data.ThongTinComment_DL
import docongphuc.pttravle.data.ThongTinDiaDiem_DL
import java.util.*

class Expd_ThongTinDuLich constructor(context: Context, mHeaderGroup: ArrayList<ThongTinDiaDiem_DL>, mDataChild: HashMap<ThongTinDiaDiem_DL, ArrayList<ThongTinComment_DL>>) : BaseExpandableListAdapter(),ExpandableListView.OnGroupClickListener
{
    override fun onGroupClick(p0: ExpandableListView?, p1: View?, p2: Int, p3: Long): Boolean {
//        val intent = Intent(p1!!.getContext(), ThongTinChiTiet_DDDL::class.java)
//        p1.getContext().startActivity(intent)
        return true
    }


    private var context:Context?=context;
    private var mHeaderGroup:ArrayList<ThongTinDiaDiem_DL>?=mHeaderGroup
    private var mDataChild: HashMap<ThongTinDiaDiem_DL,ArrayList<ThongTinComment_DL>>?= mDataChild;
    override fun getGroup(groupPosition: Int): Any {
        return mHeaderGroup!!.get(groupPosition)

    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false;
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {

        var view:View?
        view=convertView
        if (convertView == null) {
            val inflater = this.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.row_thongtindulich, null)

        }

        val AnhDDDaiDien_DL=view!!.findViewById<CircleImageView>(R.id.AnhDaijDien_DL)
        val TenDD = view!!.findViewById<TextView>(R.id.TenDiaDiem_DL) as TextView
        val DiaChi = view.findViewById<TextView>(R.id.DiaChi_DL) as TextView
        val Anh = view.findViewById<ImageView>(R.id.Anh_DL)
        val BtnLike=view.findViewById<ImageButton>(R.id.Btn_Like)
        val LuocLike=view.findViewById<TextView>(R.id.SoLuotLike)
        val BtnComment=view.findViewById<ImageButton>(R.id.Btn_Comment)
        val Socomment=view.findViewById<TextView>(R.id.SoLuotLike)
        val danggia=view.findViewById<RatingBar>(R.id.DanhGia)
        TenDD.text=mHeaderGroup!!.get(groupPosition).TenDiaDiem.toString()
        DiaChi.text = mHeaderGroup!!.get(groupPosition).DiaChi
        //Anh.setImageBitmap(mHeaderGroup!!.get(groupPosition).BipMap)
        LuocLike.text=mHeaderGroup!!.get(groupPosition).LuocLike
        Socomment.text=mHeaderGroup!!.get(groupPosition).SoCmmt
        danggia.rating=mHeaderGroup!!.get(groupPosition).DanhGia
        // set su kien khi click vao so duong trong expendlbe listview
        Glide.with(context).load(mHeaderGroup!!.get(groupPosition).url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .error(R.drawable.wellcom0)
                .into(Anh)
        Glide.with(context).load(mHeaderGroup!!.get(groupPosition).url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
               .error(R.drawable.wellcom0)
                .into(AnhDDDaiDien_DL)
        BtnComment.setOnClickListener {
            if (isExpanded)
                (parent as ExpandableListView).collapseGroup(groupPosition)
            else
                (parent as ExpandableListView).expandGroup(groupPosition, true)
        }
        BtnLike.setOnClickListener() {
            val intent = Intent(view!!.getContext(), ThongTinChiTiet_DDDL::class.java)
            view!!.getContext().startActivity(intent)
        }
        return view;
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return mDataChild!!.get(mHeaderGroup!!.get(groupPosition))!!.size

    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return mDataChild!!.get(mHeaderGroup!!.get(groupPosition))!!.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong();
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {

        var view:View?;
        view=convertView
        if (view==null){
            val inflater = LayoutInflater.from(context)
            view = inflater!!.inflate(R.layout.row_comment, parent, false)
        }
        val tgCmmt=view!!.findViewById<TextView>(R.id.ThoiGianBinhLuan_DDDL)
        val UserName = view!!.findViewById<TextView>(R.id.UserName) as TextView
        val NoiDung = view.findViewById<TextView>(R.id.NoiDungCmmt)
        val Anh=view.findViewById<CircleImageView>(R.id.AnhDaidien_Cmmt)
        UserName.text=(getChild(groupPosition, childPosition) as ThongTinComment_DL).UserName.toString()
        NoiDung.text=(getChild(groupPosition, childPosition) as ThongTinComment_DL).Comment
        tgCmmt.text=(getChild(groupPosition, childPosition) as ThongTinComment_DL).ThoiGian
        Glide.with(context).load((getChild(groupPosition,childPosition)as ThongTinComment_DL).url)
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .into(Anh)
        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return mHeaderGroup!!.size
    }
}