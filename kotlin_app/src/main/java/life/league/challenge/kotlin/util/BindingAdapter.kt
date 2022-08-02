package life.league.challenge.kotlin.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun ImageView.setImage(url: String) {
    Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(this)
}