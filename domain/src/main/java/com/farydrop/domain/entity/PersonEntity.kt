package com.farydrop.domain.entity

data class PersonEntity(
    var id: Int = UNDEFINED_ID,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
){
    companion object{
        const val UNDEFINED_ID = 0
    }
}
