package com.farydrop.domain.interactors

import com.farydrop.domain.entity.PersonEntity
import com.farydrop.domain.entity.SignInActionEntity
import com.farydrop.domain.repository.SignInRepository
import com.farydrop.domain.usecase.SignInActionState
import com.farydrop.domain.usecase.SignInUseCase
import io.reactivex.rxjava3.core.Observable

class SignInInteractor(private val signInRepository: SignInRepository): SignInUseCase {

    override fun pressSignInState(
        action: SignInActionEntity,
        inputFirstName: String?,
        inputLastName: String?,
        inputPhoneNumber: String?
    ): Observable<SignInActionState> {
        TODO("Not yet implemented")
    }
}