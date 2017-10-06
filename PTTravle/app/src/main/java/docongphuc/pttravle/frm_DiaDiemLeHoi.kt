package docongphuc.pttravle

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import docongphuc.pttravle.connect.ConnectDatabase

/**
 * Created by Admin on 26/9/2017.
 */
class frm_DiaDiemLeHoi : Fragment(){
    val DATABASENAME:String="TinhThanhPho.sqlite"
    var database: SQLiteDatabase?=null;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
           val view =inflater!!.inflate(R.layout.frm_diadiemlehoi,container,false);
         database =ConnectDatabase().initDatabase(this.activity,DATABASENAME);
        var cursor :Cursor= database!!.rawQuery("SELECT * FROM VUNG",null)
        cursor.moveToFirst()
        Toast.makeText(this.activity, cursor.getString(1), Toast.LENGTH_SHORT).show();
        return view;
    }
}