package com.go.shopping.data

data class AnswerDoneResult(
    val isDone: Boolean = false,
    val result: Boolean = false,
    var explain: String = "",
    var viewId: Int = 0
)
