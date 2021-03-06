package docongphuc.pttravle.custom

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import docongphuc.pttravle.R
import docongphuc.pttravle.data.QuanHuyen

class PagerAdapter_Hinhanh: PagerAdapter {
    var context:Context
    var ArrayUrl:ArrayList<QuanHuyen>
    lateinit var inflator:LayoutInflater

    constructor(context: Context,ArrayUrl:ArrayList<QuanHuyen>)
    {
        this.context=context
        this.ArrayUrl=ArrayUrl
    }
    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view==`object` as RelativeLayout
    }

    override fun getCount(): Int {
       return ArrayUrl.size
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        var img:ImageView
        inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view=inflator.inflate(R.layout.hinhanh,container,false)
        img=view.findViewById(R.id.Anh_Pager_DL)
        Glide.with(context).load(ArrayUrl.get(position).TenQuanHuyen.toString())
                .centerCrop()
                .placeholder(R.drawable.loading_image)
                .into(img)
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container!!.removeView(`object` as RelativeLayout)
    }
}
