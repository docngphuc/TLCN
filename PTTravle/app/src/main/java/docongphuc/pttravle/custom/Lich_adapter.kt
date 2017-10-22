package docongphuc.pttravle.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import docongphuc.pttravle.R
import docongphuc.pttravle.data.LichTrinh_data_event

class Lich_adapter(var context : Context, var mang : ArrayList<LichTrinh_data_event>) : BaseAdapter() {

    class viewHolder (row : View){
        var txtten : TextView
        var txtgioKT : TextView
        var txtgioBD : TextView
        var txtnote : TextView

        init {
            txtten = row.findViewById(R.id.txt_lichtrinh_day_tile)
            txtnote = row.findViewById(R.id.txt_lichtrinh_day_note)
            txtgioKT = row.findViewById(R.id.txt_lichtrinh_day_timeKT)
            txtgioBD = row.findViewById(R.id.txt_lichtrinh_day_timeBD)
        }
    }

    override fun getView(position: Int, convertview: View?, parent: ViewGroup?): View {
        val view : View?
        val viewholder : viewHolder

        if (convertview == null){
            val layoutinflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.row_lichtrinh_list_day, parent,false)
            viewholder = viewHolder(view!!)
            view.tag = viewholder
        }
        else{
            view = convertview
            viewholder = convertview.tag as viewHolder
        }

        val lich : LichTrinh_data_event = getItem(position) as LichTrinh_data_event

        viewholder.txtten.text = lich.ten
        viewholder.txtnote.text = lich.note
        viewholder.txtgioKT.text = lich.time_KT.toString()
        viewholder.txtgioBD.text = lich.time_BD.toString()

        return view as View
    }

    override fun getItem(p0: Int): Any {
        return mang.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mang.size
    }
}