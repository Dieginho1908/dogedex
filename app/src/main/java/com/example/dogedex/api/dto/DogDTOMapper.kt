package com.example.dogedex.api.dto

import com.example.dogedex.model.Dog

class DogDTOMapper {
    private fun fromDTOToDogDomain(dogDTO: DogDTO): Dog = Dog(
        dogDTO.id,
        dogDTO.index,
        dogDTO.name,
        dogDTO.type,
        dogDTO.heightFemale,
        dogDTO.heightMale,
        dogDTO.imageUrl,
        dogDTO.lifeExpectancy,
        dogDTO.temperament,
        dogDTO.weightFemale,
        dogDTO.weightMale,
    )

    fun fromDogDTOListToDogDomailList(dogDTOList: List<DogDTO>): List<Dog> = dogDTOList.map {
        fromDTOToDogDomain(it)
    }
}

