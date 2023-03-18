package com.hacybeyker.pokeinfo.utils

fun String.obtainIdByUrl(): Int {
    /*val splits = this.split("/")
    return splits[6].toInt()*/

    return this.split("/".toRegex()).dropLast(1).last().toInt()
}
