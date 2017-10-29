package docongphuc.pttravle

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import docongphuc.pttravle.Maps.getLatlng

class frm_DiaDiemLeHoi : Fragment(){
        var lat:Double=0.7
        var b:Double=0.0



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
           val view =inflater!!.inflate(R.layout.frm_diadiemlehoi,container,false);




//        val DIRECTION_URL_API = "https://maps.googleapis.com/maps/api/geocode/json?address="
//        val GOOGLE_API_KEY = "AIzaSyC3AXK8d8k3yM7GzZGV7JDwR36vF0kyNm4"
//        var URL:String = "https://maps.googleapis.com/maps/api/geocode/json?address=117/134/7%20ph%C6%B0%E1%BB%9Dng%2022%20qu%E1%BA%ADn%20b%C3%ACnh%20th%E1%BA%A1nh&key=AIzaSyC3AXK8d8k3yM7GzZGV7JDwR36vF0kyNm4"
//        var req: RequestQueue = Volley.newRequestQueue(this.activity)
//        var Arr  = JsonArrayRequest(Request.Method.GET,URL,null,
//                Response.Listener<JSONArray> (){
//                    response ->
//                    Toast.makeText(this.activity,"ok", Toast.LENGTH_LONG).show()
//                }, Response.ErrorListener {
//            error ->
//            Toast.makeText(this.activity,error.toString(), Toast.LENGTH_LONG).show()
//
//        })
//        req.add(Arr)
        return view;
    }



}