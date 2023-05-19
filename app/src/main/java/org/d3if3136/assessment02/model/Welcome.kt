package org.d3if3136.assessment02.model

import org.d3if3136.assessment02.db.UserEntity

fun UserEntity.welcome(): HasilInput {
    val lanjut = nama
    return HasilInput(lanjut)
}