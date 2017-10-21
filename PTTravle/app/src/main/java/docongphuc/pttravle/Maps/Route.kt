package docongphuc.pttravle.Maps

import com.google.android.gms.maps.model.LatLng


/**
 * Created by Admin on 12/10/2017.
 */
class Route{
    var distance: Distance? = null
    var duration: Duration? = null
    var endAddress: String? = null
    var endLocation: LatLng? = null
    var startAddress: String? = null
    var startLocation: LatLng? = null

    var points: List<LatLng>? = null
}