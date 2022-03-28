package space.alehandrozed.fishermanguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()


        list.add(ListItem(R.drawable.nalim, "Щука", "Хищник"))
        list.add(ListItem(R.drawable.nalim, "Налим", "Спит на дне"))
        list.add(ListItem(R.drawable.caras, "Карась", "Ловится на червя"))
        list.add(ListItem(R.drawable.som, "Сом", "Ест лягушек"))
        list.add(ListItem(R.drawable.som, "Сом", "Ест лягушек"))
        list.add(ListItem(R.drawable.caras, "Карась", "Ловится на червя"))
        list.add(ListItem(R.drawable.som, "Сом", "Ест лягушек"))
        list.add(ListItem(R.drawable.som, "Сом", "Ест лягушек"))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fish -> Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show()
            R.id.na -> Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
            R.id.sna -> Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
            R.id.history -> Toast.makeText(this, "Id history", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}