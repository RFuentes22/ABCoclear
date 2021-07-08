package com.coclearapp.pdm_project.Models

import java.io.Serializable

data class Item<out A, out B, out C, out D, out E,out F>(
    val icon: A,
    val answer: B,
    val opc1: C,
    val opc2: D,
    val opc3: E,
    val sound: F
) : Serializable {

    override fun toString(): String = "($icon, $answer, $opc1, $opc2, $opc3,$sound)"
}

/**
 * Converts this Item into a list.
 */
fun <T> Item<T, T, T, T, T, T>.toList(): List<T> = listOf(icon, answer, opc1, opc2, opc3, sound)

