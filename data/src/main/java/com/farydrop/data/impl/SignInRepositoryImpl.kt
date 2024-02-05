package com.farydrop.data.impl

import com.farydrop.data.dao.Person
import com.farydrop.data.dao.PersonDao
import com.farydrop.domain.entity.PersonEntity
import com.farydrop.domain.repository.SignInRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class SignInRepositoryImpl(private val personDao: PersonDao): SignInRepository {
    /*override fun signUp(
        person: Person
    ): Completable {
        return personDao.insert(person)
    }*/

    override fun signIn(email: String, phone: String): Completable {
        TODO("Not yet implemented")
    }

    override fun signOut(): Completable {
        TODO("Not yet implemented")
    }

    override fun isLoggedIn(): Single<Boolean> {
        TODO("Not yet implemented")
    }

    override fun updateAccountSettings(isAcceptMarketing: Boolean): Completable {
        TODO("Not yet implemented")
    }


}