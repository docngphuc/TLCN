package docongphuc.pttravle

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import com.google.firebase.database.*
import docongphuc.pttravle.custom.Lich_adapter
import docongphuc.pttravle.data.LichTrinh_data_day
import java.text.SimpleDateFormat
import java.util.*

class LichTrinh : Fragment() {

    val KEY_ID_USER = "ID_User"
    var id_User = ""

    val key : String = "$1$2$3$4$5$6$"
    val currentCalender = Calendar.getInstance(Locale.getDefault())
    val sdf : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy 'at' HH:mm")
    val sdf_date : SimpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
    val sdf_time : SimpleDateFormat = SimpleDateFormat("HH:mm")

    val database    : DatabaseReference

    init {
        database    = FirebaseDatabase.getInstance().reference
    }

    // khai bao cho lich
    lateinit var compactCalendar : CompactCalendarView
    lateinit var lvLich : ListView
    lateinit var adapter : Lich_adapter
    val list_lich : ArrayList<LichTrinh_data_day> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.frm_lichtrinh, container, false)

        id_User = arguments.getString(KEY_ID_USER,"null")

        lvLich  = view.findViewById(R.id.list_lichtrinh_day)
        compactCalendar  = view.findViewById(R.id.compactcalendar_view)
        compactCalendar.setLocale(TimeZone.getTimeZone("GMT+07:00"), Locale.ENGLISH)
        compactCalendar.setUseThreeLetterAbbreviation(true)
        compactCalendar.setFirstDayOfWeek(Calendar.MONDAY)

        // listview khi keo len cung co the cuon len
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lvLich.setNestedScrollingEnabled(true);
        }

        AddList()

        adapter = Lich_adapter(activity, list_lich)
        lvLich.adapter = adapter

        // define a listener to receive callbacks when certain events happen.
        compactCalendar.setListener(object : CompactCalendarView.CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date) {
                LayNgayNay(dateClicked)
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date) {
                ShortToast(firstDayOfNewMonth.toString())
            }
        })

        return view
    }

    private fun LayNgayNay(date: Date) {
        val events = compactCalendar.getEvents(date)
        val arr: MutableList<String> = mutableListOf("0")  // vi tri 0 : ""

        if (events != null) {
            list_lich.clear()
            for (booking in events) {
                TachEvent(arr,booking.data.toString())
            }
            //loadEvents_DayClick(arr)
            adapter.notifyDataSetChanged()
        }
    }

    // lay su kien khi lick vao ngay tren lich
//    private fun loadEvents_DayClick(arr: MutableList<String>) {
//
//        val temp = arr.size-1
//        for (i in 0..(temp/4-1)){
//
//            val mangLich = LichTrinh_data_day()
//            val dateBD = java.sql.Date(arr[i*4+2].toLong())
//            val dateKT = java.sql.Date(arr[i*4+3].toLong())
//            val timeBD = java.sql.Time(arr[i*4+2].toLong())
//            val timeKT = java.sql.Time(arr[i*4+3].toLong())
//
//            mangLich.ten     = arr[i*4+1]
//            mangLich.ngayBD  = sdf_date.format(dateBD)
//            mangLich.gioBD   = sdf_time.format(timeBD)
//            mangLich.ngayKT  = sdf_date.format(dateKT)
//            mangLich.gioKT   = sdf_time.format(timeKT)
//            mangLich.note    = arr[i*4+4]
//
//            list_lich.add(mangLich)
//        }
//    }

    // tach chuoi event truyen vao
    private fun TachEvent(arr: MutableList<String>, event_data : String) {
        val substr : List<String> = event_data.split(key)
        for (j in 0..(substr.size-1)){
            arr.add(substr[j])
        }
    }

    // lay du lieu tren firebase va them list
    private fun AddList() {
        database.child("Users").child(id_User).child("lich").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                val id_lich_change = p0!!.key
                val lich = p0.getValue(LichTrinh_data_day::class.java)
                val list = lich!!
                val events_truoc = getEvents(lich.time_BD, lich.time_KT,lich.ten,lich.note)
                val events_sau = getEvents(list.time_BD, list.time_KT,list.ten,list.note)

                list_lich[id_lich_change.toInt()] = lich
                adapter.notifyDataSetChanged()

                compactCalendar.removeEvents(events_truoc)
                compactCalendar.addEvents(events_sau)
            }

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val lich = p0!!.getValue(LichTrinh_data_day::class.java)
                list_lich.add(lich!!)
                adapter.notifyDataSetChanged()

                val events = getEvents(lich.time_BD, lich.time_KT,lich.ten,lich.note)
                compactCalendar.addEvents(events)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {}
        })
    }

    // goi event de truyen vao lich
    private fun getEvents(timeInMillisBD: Long, timeInMillisKT: Long, ten: String, note: String): List<Event> {

        // doi tu mili giay sang date
        val dateBD = java.sql.Date(timeInMillisBD)
        val dateKT = java.sql.Date(timeInMillisKT)

        // lay lai thong tin ngay bat dau va ngay ket thuc
        val date1 : Date = sdf.parse(dateBD.toString() + " at " + "23:59")
        val date2 : Date = sdf.parse(dateKT.toString() + " at " + "0:0")

        // chuoi ngay dau tien va cuoi cung cua su kien
        val string1 = ten +key+ timeInMillisBD +key+ date1.time +key+ note
        val string2 = ten +key+ date2.time +key+ timeInMillisKT +key+ note

        // tinh so ngay trong event
        val noDay = (timeInMillisKT - timeInMillisBD) / (24 * 3600 * 1000)

        // phan thuc hien so sanh
        if (noDay.toInt() == 0) {

            // chi co mot ngay
            val string : String = ten +key+ timeInMillisBD +key+ timeInMillisKT +key+ note
            return Arrays.asList(Event(Color.RED, timeInMillisBD, string))
        }
        else {
            if (noDay.toInt() == 1) {

                //co 2 ngay
                return Arrays.asList(
                        Event(Color.BLUE, timeInMillisBD, string1),
                        Event(Color.BLUE, timeInMillisKT, string2))
            }
            else {

                val event = Event(Color.GREEN, timeInMillisBD, string1)
                val mutableList : MutableList<Event> = mutableListOf(event)  // event dau tien

                // thoi gian bat dau va ket thuc cua 1 ngay trong 1 su kien nhieu ngay : bat dau luc 0h va ket thuc luc 23:59
                var date_time_BD : Date
                var date_time_KT : Date

                // lay ngay de co the tang len 1 ngay, tao vong lap
                var d : Date
                val c = Calendar.getInstance()
                c.time = dateBD

                // lay chuoi vao mang
                for (i in 1..(noDay-1)){
                    c.add(Calendar.DATE, 1)
                    d = c.time

                    // doi tu mili giay sang date
                    val date = java.sql.Date(d.time)

                    // thoi gian bat dau va ket thuc cua 1 ngay trong 1 su kien nhieu ngay : bat dau luc 0h va ket thuc luc 23:59
                    date_time_BD = sdf.parse(sdf_date.format(date).toString() + " at " + "0:0")
                    date_time_KT = sdf.parse(sdf_date.format(date).toString() + " at " + "23:59")

                    // chuoi ngay dau tien va cuoi cung cua su kien
                    val string_date_time = ten +key+ date_time_BD.time +key+ date_time_KT.time +key+ note
                    mutableList.add(Event(Color.GREEN, date_time_BD.time, string_date_time))
                }

                // lay chuoi ngay cuoi cung
                mutableList.add(Event(Color.GREEN, timeInMillisKT, string2))

                val list : List<Event> = mutableList
                return list
            }
        }
    }


    // hien dong thong bao
    private fun ShortToast(messsage : String) {
        val length : Int = Toast.LENGTH_SHORT
        Toast.makeText(activity, messsage, length).show()
    }
}