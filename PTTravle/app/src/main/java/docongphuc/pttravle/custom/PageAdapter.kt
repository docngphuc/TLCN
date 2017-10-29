package docongphuc.pttravle.custom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

open class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val tabTitles = arrayOf("Du Lịch", "Lễ Hội");
    private  var FrmItem: ArrayList<Fragment> = ArrayList();
    //var FrmTitle:ArrayList<String> = ArrayList();
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */

    override fun getItem(position: Int): Fragment {
        return FrmItem[position];
    }


    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    override fun getCount(): Int {
        return FrmItem.size
    }
    fun addfragment(frmitem:Fragment){

        FrmItem.add(frmitem);
    }
    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position];
    }
}
