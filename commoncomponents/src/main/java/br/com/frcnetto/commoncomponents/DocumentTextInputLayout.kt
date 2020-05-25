package br.com.frcnetto.commoncomponents

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class DocumentTextInputLayout : TextInputLayout {

    private var _documentType: Int? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setupAttributes(attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setupAttributes(attrs)
    }

    companion object {
        private const val CPF_TYPE = 1
        private const val CNPJ_TYPE = 2
    }

    private var _editText: TextInputEditText? = null

    private fun setupAttributes(attrs: AttributeSet?) {
        val attributeArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.DocumentTextInputLayout, 0, 0)
        try {
            _documentType = attributeArray.getInteger(R.styleable.DocumentTextInputLayout_documentType, -1)
        } finally {
            attributeArray.recycle()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initializeInputLayout()
        initializeEditText()
    }

    private fun initializeInputLayout() {
        hint = when (_documentType) {
            CPF_TYPE -> "CPF"
            CNPJ_TYPE -> "CNPJ"
            CPF_TYPE + CNPJ_TYPE -> "CPF/CNPJ"
            else -> null
        }
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