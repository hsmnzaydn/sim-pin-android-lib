package com.hsmnzaydn.smsconfirmationview

internal fun String.digits(): String = filter { char -> char.isDigit() }