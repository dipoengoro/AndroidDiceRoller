package id.dipoengoro.diceroller

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val _result = MutableLiveData<Int>()
    val result: LiveData<Int> = _result

    fun randomIt() {
        _result.value = Random.nextInt(6) + 1
    }

    companion object {
        @BindingAdapter("imgSrc")
        @JvmStatic
        fun provideImage(view: ImageView, result: Int) =
            view.setImageResource(
                when (result) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    6 -> R.drawable.dice_6
                    else -> R.drawable.empty_dice
                }
            )
    }
}