package com.farydrop.domain.interactors

import com.farydrop.domain.entity.Optional
import com.farydrop.domain.entity.PersonEntity
import com.farydrop.domain.entity.SignInActionEntity
import com.farydrop.domain.repository.SignInRepository
import com.farydrop.domain.usecase.SignInActionState
import com.farydrop.domain.usecase.SignInUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class SignInInteractor(private val signInRepository: SignInRepository): SignInUseCase {

    private fun getHabitNameValid(name: String?): Single<Optional<String>> =
        Single.fromCallable {
            Optional(name.takeIf { !it.isNullOrBlank() })
            //name.takeIf { !it.isNullOrBlank() }?.let { Optional.of(it) }?: Optional.empty()
        }

    override fun pressSignInState(
        action: SignInActionEntity,
        inputFirstName: String?,
        inputLastName: String?,
        inputPhoneNumber: String?
    ): Observable<SignInActionState> {
        TODO("Not yet implemented")
    }

    override fun signIn(personEntity: PersonEntity) {

        //signInRepository.signUp(personEntity)
    }

    private fun isValidCyrillic(text: String): Boolean {
        val cyrillicPattern = "^[А-Яа-яЁё\\s]+$"
        return text.matches(cyrillicPattern.toRegex())
    }


}