package docongphuc.pttravle.HOME.ThanhQuan

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import docongphuc.pttravle.R
import docongphuc.pttravle.custom.PagerAdapter_Hinhanh
import docongphuc.pttravle.data.QuanHuyen
import java.util.*

// hiển thi thông tin chi tiwwts của từng địa điểm du lich

class frm_thongtin_chitiet : Fragment() {
    var Arraychild:ArrayList<QuanHuyen>?= ArrayList();
    private lateinit var mDateSetListenner:DatePickerDialog.OnDateSetListener
    private var ThemVaoLichTrinh:Button? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater!!.inflate(R.layout.frm_thongtinchitiet_dddl,container,false)
        var viepager=view.findViewById<ViewPager>(R.id.ViewPager_Hinhanh_chitiet);
         ThemVaoLichTrinh = view.findViewById<Button>(R.id.ThemVaoLichTrinh)
        addTimepicker()
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        Arraychild!!.add(QuanHuyen("https://tinyjpg.com/images/social/website.jpg"))
        var adapter:PagerAdapter= PagerAdapter_Hinhanh(this.context,Arraychild!!)
        viepager.adapter=adapter
        return view;
    }

    private fun addTimepicker() {
        ThemVaoLichTrinh!!.setOnClickListener({
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(activity,android.R.style.Theme_Holo_Light_Dialog, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                //lblDate.setText("" + dayOfMonth + " " + MONTHS[monthOfYear] + ", " + year)
            }, year, month, day)
            dpd.setTitle("Ngày bắt đầu")
            dpd.show()
        })

    }

}
