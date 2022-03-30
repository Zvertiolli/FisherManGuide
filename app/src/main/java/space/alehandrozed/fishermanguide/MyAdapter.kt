package space.alehandrozed.fishermanguide

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var listArrayR: ArrayList<ListItem>, var contextR: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val imageContent = view.findViewById<ImageView>(R.id.imageContent)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            val text = listItem.contentText.substring(0, 10) + "..."
            tvContent.text = text
            imageContent.setImageResource(listItem.imageId)
            itemView.setOnClickListener() {
                Toast.makeText(context, "Pressed : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", listItem.titleText)
                    putExtra("content", listItem.contentText)
                    putExtra("image", listItem.imageId)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}