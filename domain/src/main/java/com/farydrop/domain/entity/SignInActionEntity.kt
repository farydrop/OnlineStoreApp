package com.farydrop.domain.entity

sealed class SignInActionEntity {
    abstract val valid: ValidEntity
    data class SignIn(override val valid: ValidEntity): SignInActionEntity()
}