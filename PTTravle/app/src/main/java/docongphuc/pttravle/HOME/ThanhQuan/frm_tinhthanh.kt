package docongphuc.pttravle.HOME.ThanhQuan

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import docongphuc.pttravle.R
import docongphuc.pttravle.connect.ConnectDatabase
import docongphuc.pttravle.custom.ExpdLisstView
import docongphuc.pttravle.data.QuanHuyen
import docongphuc.pttravle.data.TinhThanhPho

/**
 * Created by Admin on 29/9/2017.
 */
class frm_tinhthanh :android.support.v4.app.Fragment() {
    private val DATABASENAME:String="TinhThanhPho.sqlite"
   private var database: SQLiteDatabase?=null;
    var KhuVuc:Int=1;
    var Arraychild:ArrayList<QuanHuyen>?= ArrayList();
    var HasMap:HashMap<TinhThanhPho,ArrayList<QuanHuyen>>?= HashMap()
    var ArrayHeader : ArrayList<TinhThanhPho>?= ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view=inflater!!.inflate(R.layout.frm_tinhthanh_dulich,container,false)
        var ExpandbleLV=view.findViewById<ExpandableListView>(R.id.expd_tinhthanh_dulich)
        addheader(KhuVuc)
       // HasMap!!.put(ArrayHeader!![0],Arraychild!!)
        var adapter= ExpdLisstView(this.context,ArrayHeader!!,HasMap!!)
        adapter.notifyDataSetChanged();
        ExpandbleLV!!.setAdapter(adapter)
        ExpandbleLV.setOnGroupClickListener { parent, v, groupPosition, id ->
           // Toast.makeText(this.activity, groupPosition.toString(), Toast.LENGTH_SHORT).show();
            val intent = Intent(this.activity, ThongTinChiTiet_DDDL::class.java)
            startActivity(intent)
            true
        }
        return view;
    }

      fun addheader(idkhuvuc:Int){
          database = ConnectDatabase().initDatabase(this.activity,DATABASENAME);
          var cursor : Cursor = database!!.rawQuery("SELECT * FROM Tinh_TP where Tinh_TP.Vung="+idkhuvuc,null)
          ArrayHeader!!.clear();
          for (i in 0 until cursor.count){
              cursor.moveToPosition(i)
              Arraychild= ArrayList()
              Arraychild=addchild(cursor.getInt(0))
              ArrayHeader!!.add(TinhThanhPho(cursor.getString(1),Arraychild!!.size))
              HasMap!!.put(ArrayHeader!![i],Arraychild!!)

          }

     }

    private fun addchild(idtinh:Int):ArrayList<QuanHuyen> {
        database = ConnectDatabase().initDatabase(this.activity,DATABASENAME);
        var cursor : Cursor = database!!.rawQuery("SELECT * FROM Huyen where Huyen.Tinh="+idtinh,null)
        Arraychild!!.clear()
        for (i in 0 until cursor.count)
        {
            cursor.moveToPosition(i)
            Arraychild!!.add(QuanHuyen(cursor.getString(1)))
        }
        return Arraychild!!
    }
}