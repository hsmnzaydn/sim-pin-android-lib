@file:Suppress("unused")

package com.hsmnzaydn.smsconfirmationview

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("enteredCode")
fun setEnteredCode(view: SmsConfirmationView, code: String?) {
    val viewCode = view.enteredCode
    if (viewCode.isEmpty() && code.isNullOrEmpty()) return
    if (viewCode == code) return

    view.enteredCode = code.orEmpty()
}

@InverseBindingAdapter(attribute = "enteredCode")
fun getEnteredCode(view: SmsConfirmationView): String = view.enteredCode

@BindingAdapter(
    "onChangeListener",
    "enteredCodeAttrChanged",
    requireAll = false
)
fun setListener(
    view: SmsConfirmationView,
    listener: SmsConfirmationView.OnChangeListener?,
    attrListener: InverseBindingListener?
) {
    if (attrListener == null) {
        view.onChangeListener = listener
    } else {
        view.onChangeListener = SmsConfirmationView.OnChangeListener { code, isComplete, isFail ->
            listener?.onCodeChange(code, isComplete,isFail)
            attrListener.onChange()
        }
    }
}