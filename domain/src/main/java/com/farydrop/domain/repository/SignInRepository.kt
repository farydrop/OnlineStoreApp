package com.farydrop.domain.repository

import com.farydrop.domain.entity.PersonEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.Subject

interface SignInRepository {

    //fun signUp(person: PersonEntity): Completable

    fun signIn(email: String, phone: String): Completable

    fun signOut(): Completable

    fun isLoggedIn(): Single<Boolean>

    fun updateAccountSettings(isAcceptMarketing: Boolean): Completable

    //fun updatePersonSubject():Subject<Unit>

    //fun getPersonItem(): Single<GetPersonItemState>

    //fun signIn(): Single<GetPersonItemState>
}

sealed class GetPersonItemState{
    data class Success(val person: PersonEntity): GetPersonItemState()
    object PersonNotFoundError: GetPersonItemState()
    object PersonNotValidError: GetPersonItemState()

    data class Error(val error: Throwable) : GetPersonItemState()
}