package docongphuc.pttravle.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import docongphuc.pttravle.R
import docongphuc.pttravle.data.ListItemAlbum

class AlbumAdapter(var context : Context, var mang : ArrayList<ListItemAlbum>) : BaseAdapter() {

    class viewHolder (row : View){
        var image : ImageView

        init {
            image = row.findViewById(R.id.img_album)
        }
    }

    override fun getView(position: Int, convertview: View?, parent: ViewGroup?): View {
        val view : View?
        val viewholder : viewHolder

        if (convertview == null){
            val layoutinflater : LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.row_album, parent,false)
            viewholder = viewHolder(view!!)
            view.tag = viewholder

        }
        else{
            view = convertview
            viewholder = convertview.tag as viewHolder
        }

        val l: ListItemAlbum = getItem(position) as ListItemAlbum
        if (viewholder.image != null) {
            ImageDownloaderTask(viewholder.image).execute(l.getUrl())
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return mang.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mang.size
    }
}