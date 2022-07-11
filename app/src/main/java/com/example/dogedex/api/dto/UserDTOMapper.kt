package com.example.dogedex.api.dto

import com.example.dogedex.model.User

class UserDTOMapper {
    fun fromDTOToUserDomain(userDto: UserDTO): User = User(
        id = userDto.id,
        email = userDto.email,
        authenticationToken = userDto.authenticationToken
    )
}