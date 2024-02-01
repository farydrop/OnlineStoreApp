package com.farydrop.domain.repository

import com.farydrop.domain.entity.PersonEntity
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.Subject

interface SignInRepository {

    fun updatePersonSubject():Subject<Unit>

    //fun getPersonItem(): Single<GetPersonItemState>

    fun signIn(): Single<GetPersonItemState>
}

sealed class GetPersonItemState{
    data class Success(val person: PersonEntity): GetPersonItemState()
    object PersonNotFoundError: GetPersonItemState()
    object PersonNotValidError: GetPersonItemState()

    data class Error(val error: Throwable) : GetPersonItemState()
}