package com.farydrop.data

import com.farydrop.data.database.PersonDao
import com.farydrop.domain.repository.GetPersonItemState
import com.farydrop.domain.repository.SignInRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject

class SignInRepositoryImpl(private val personDao: PersonDao): SignInRepository {

    private val updatePersonsSubject = BehaviorSubject.createDefault(Unit)

    override fun updatePersonSubject(): Subject<Unit> = updatePersonsSubject

    override fun signIn(): Single<GetPersonItemState> {
        TODO("Not yet implemented")
    }
}