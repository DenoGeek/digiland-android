package neverest.ke.co.digiland.widget

import android.widget.TextView
import android.graphics.Typeface
import android.os.Build
import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import neverest.ke.co.digiland.R


/**
 * Created by USER on 11/10/2017.
 */
class FontTextView : TextView {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)

    }

    constructor(context: Context) : super(context) {
        init(null)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.FontTextView)
            val fontName = a.getString(R.styleable.FontTextView_font_face)

            try {
                if (fontName != null) {
                    val myTypeface = Typeface.createFromAsset(context.assets, "fonts/" + fontName!!)
                    typeface = myTypeface
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("Font", e.message)
            }

            a.recycle()
        }
    }
}