package space.alehandrozed.fishermanguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.item_layout.*

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        textViewTitle.text = intent.getStringExtra("title")
        textViewContent.text = intent.getStringExtra("content")
        imageViewContent.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }
}