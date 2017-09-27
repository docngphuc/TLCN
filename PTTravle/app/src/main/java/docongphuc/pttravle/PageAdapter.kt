package docongphuc.pttravle

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Admin on 26/9/2017.
 */
class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val tabTitles = arrayOf("Du Lịch", "Lễ Hội");
    var FrmItem: ArrayList<Fragment> = ArrayList();
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */

    override fun getItem(position: Int): Fragment {
        return FrmItem[position]
    }
    fun addfragment(frmitem:Fragment){
        FrmItem.add(frmitem);
    }
    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    override fun getCount(): Int {
        return FrmItem.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position];
    }
}
