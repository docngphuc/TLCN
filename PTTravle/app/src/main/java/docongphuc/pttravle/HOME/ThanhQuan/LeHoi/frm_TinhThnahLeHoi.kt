package docongphuc.pttravle.HOME.ThanhQuan.LeHoi

import android.annotation.SuppressLint
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ExpandableListView
import android.widget.Spinner
import docongphuc.pttravle.R
import docongphuc.pttravle.connect.ConnectDatabase
import docongphuc.pttravle.custom.ExpdLisstView
import docongphuc.pttravle.data.QuanHuyen
import docongphuc.pttravle.data.TinhThanhPho

/**
 * Created by Admin on 23/10/2017.
 */
class frm_TinhThnahLeHoi :Fragment() {
    private var ExpandbleLV1: ExpandableListView?=null
    private var khuvuc: Spinner?=null
    private val DATABASENAME:String="TinhThanhPho.sqlite"
    private var database: SQLiteDatabase?=null;
    private var KhuVuc:Int=1;
    private var Arraychild:ArrayList<QuanHuyen>?= ArrayList();
    private var HasMap:HashMap<TinhThanhPho,ArrayList<QuanHuyen>>?= HashMap()
    private var ArrayHeader : ArrayList<TinhThanhPho>?= ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater!!.inflate(R.layout.frm_tinhthanh_dulich,container,false)

        ExpandbleLV1=view.findViewById<ExpandableListView>(R.id.expd_tinhthanh_dulich)
        khuvuc =view.findViewById<Spinner>(R.id.Sp_KhuVuc)
        addheader(KhuVuc)

        // HasMap!!.put(ArrayHeader!![0],Arraychild!!)

        ExpandbleLV1!!.setOnGroupClickListener { parent, v, groupPosition, id ->

//             Toast.makeText(this.activity, groupPosition.toString(), Toast.LENGTH_SHORT).show();
////            val intent = Intent(this.activity, ThongTinChiTiet_DDDL::class.java)
////            startActivity(intent)
            true
        }
        val adapterKhuVuc: ArrayAdapter<String> = ArrayAdapter(this.activity, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.KhuVuc))
        adapterKhuVuc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        khuvuc!!.adapter=adapterKhuVuc
        doikhuvuc()
        return view
    }
    private fun doikhuvuc() {
        khuvuc!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                when (p2) {
                    0 ->{
                        KhuVuc=1;
                        addheader(KhuVuc)
                    }

                    1 ->{
                        KhuVuc=2;
                        addheader(KhuVuc)
                    }
                    2 ->{
                        KhuVuc=3;
                        addheader(KhuVuc)
                    }
                    3 -> {
                        KhuVuc=4;
                        addheader(KhuVuc)
                    }
                    4 ->{
                        KhuVuc=5;
                        addheader(KhuVuc)
                    }
                    5 -> {
                        KhuVuc=6;
                        addheader(KhuVuc)
                    }
                    6 ->{
                        KhuVuc=7;
                        addheader(KhuVuc)
                    }


                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    @SuppressLint("Recycle")
    private fun addheader(idkhuvuc:Int){
        database = ConnectDatabase().initDatabase(this.activity,DATABASENAME);
        var cursor : Cursor = database!!.rawQuery("SELECT * FROM Tinh_TP where Tinh_TP.Vung="+idkhuvuc,null)
        ArrayHeader!!.clear();
        for (i in 0 until cursor.count){
            cursor.moveToPosition(i)
            Arraychild= ArrayList()
            Arraychild=addchild(cursor.getInt(0))
            ArrayHeader!!.add(TinhThanhPho(cursor.getString(1),Arraychild!!.size))
            HasMap!!.put(ArrayHeader!![i],Arraychild!!)
            var adapter= ExpdLisstView(this.activity,ArrayHeader!!,HasMap!!)
            adapter.notifyDataSetChanged();
            ExpandbleLV1!!.setAdapter(adapter)


        }

    }

    @SuppressLint("Recycle")
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