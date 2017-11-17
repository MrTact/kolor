package com.andreapivetta.kolor

fun <E> MutableList<E>.append(element: E): MutableList<E> {
    this.add(element)
    return this
}














