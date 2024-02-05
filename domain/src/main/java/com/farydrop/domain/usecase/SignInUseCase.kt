package com.farydrop.domain.usecase

import com.farydrop.domain.entity.PersonEntity
import com.farydrop.domain.entity.SignInActionEntity
import io.reactivex.rxjava3.core.Observable

interface SignInUseCase {

    //fun setFirstNameState(person: PersonEntity): Observable<String>
    //fun setLastNameState(person: PersonEntity): Observable<String>
    //fun setPhoneNumberState(person: PersonEntity): Observable<String>
    fun pressSignInState(
        action: SignInActionEntity,
        inputFirstName: String?,
        inputLastName: String?,
        inputPhoneNumber: String?
    ): Observable<SignInActionState>

    fun signIn(person:PersonEntity)
}

sealed class SignInActionState{
    object Start: SignInActionState()
    object Success: SignInActionState()
    object EmptyFirstNameError: SignInActionState()
    object EmptyLastNameError: SignInActionState()
    object EmptyPhoneNumberError: SignInActionState()
    object PersonNotFoundError: SignInActionState()

    data class Error(val error: Throwable) : SignInActionState()
}