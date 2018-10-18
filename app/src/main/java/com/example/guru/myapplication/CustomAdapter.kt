package net.simplifiedcoding.recyclerviewexample
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.*
import com.example.guru.myapplication.Detail
import com.example.guru.myapplication.Model.MahasiswaModel
import com.example.guru.myapplication.R
import kotlinx.android.synthetic.main.adapter_details.view.*


/**
 * Created by Belal on 6/19/2017.
 */
class CustomAdapter(val userList: ArrayList<MahasiswaModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_details, parent, false)
        return ViewHolder(v)
    }
    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }
    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }
    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: MahasiswaModel) {
            //println("gambarku : "+"http://image.tmdb.org/t/p/w185" + user.poster_path)
            itemView.tvjudul.text="name : "+user.name
            //itemView.tvdesc.text="visi dan misi : "+user.nim
            itemView.release_date.text="alamat : "+user.nim
//            Glide.with(itemView)
//                    .load("https://image.tmdb.org/t/p/w185" + user.poster_path)
//                    .into(itemView.ivcover)
            itemView.btdetail.setOnClickListener(View.OnClickListener {
                val intent = Intent(itemView.context, Detail::class.java)
                intent.putExtra("title",user.name)
                intent.putExtra("deskripsi",user.url)
                intent.putExtra("date",user.gettanggal())
                itemView.context.startActivity(intent)
            })



            itemView.btshare.setOnClickListener(View.OnClickListener {
                val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here")
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, user.name)
                itemView.getContext().startActivity(Intent.createChooser(sharingIntent, "share"))

            })
        }
    }
}