package br.com.frcnetto.commoncomponents

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DocumentTextInputLayout : TextInputLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var _editText: TextInputEditText? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initializeEditText()
    }

    private fun initializeEditText() {
        _editText = TextInputEditText(context)
        _editText?.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
        addView(_editText)
    }
}