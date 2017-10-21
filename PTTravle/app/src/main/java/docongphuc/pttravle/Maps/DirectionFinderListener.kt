package docongphuc.pttravle.Maps

/**
 * Created by Admin on 12/10/2017.
 */
interface DirectionFinderListener {
    fun onDirectionFinderStart()
    fun onDirectionFinderSuccess(route: List<Route>)
}