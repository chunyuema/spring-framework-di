package com.chunyue.pets;

//@Profile("cat")
//@Service
public class CatPetService implements PetService {
    @Override
    public String getPetType(){
        return "Cats are the best!";
    }
}
