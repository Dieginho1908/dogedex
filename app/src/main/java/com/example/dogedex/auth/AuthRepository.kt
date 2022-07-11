package com.example.dogedex.auth

import com.example.dogedex.model.User
import com.example.dogedex.api.ApiResponseStatus
import com.example.dogedex.api.DogsApi
import com.example.dogedex.api.dto.LoginDTO
import com.example.dogedex.api.dto.SignUpDTO
import com.example.dogedex.api.dto.UserDTOMapper
import com.example.dogedex.api.makeNetworkCall
import java.lang.Exception

class AuthRepository {


    suspend fun login(email: String, password: String): ApiResponseStatus<User> = makeNetworkCall {
        val loginDTO = LoginDTO(email, password)
        val loginApiResponse = DogsApi.retrofitService.login(loginDTO)

        if(!loginApiResponse.isSuccess) {
            throw Exception(loginApiResponse.message)
        }
        val userDTO = loginApiResponse.data.user
        val userDTOMapper = UserDTOMapper()
        userDTOMapper.fromDTOToUserDomain(userDTO)
    }
    suspend fun signUp(email: String, password: String, passwordConfirmation: String): ApiResponseStatus<User> = makeNetworkCall {
        val signUpDTO = SignUpDTO(email, password, passwordConfirmation)
        val signUpApiResponse = DogsApi.retrofitService.signUp(signUpDTO)

        if(!signUpApiResponse.isSuccess) {
            throw Exception(signUpApiResponse.message)
        }
        val userDTO = signUpApiResponse.data.user
        val userDTOMapper = UserDTOMapper()
        userDTOMapper.fromDTOToUserDomain(userDTO)
    }

}