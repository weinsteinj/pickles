package com.techelevator.model;

import java.util.Objects;

public class PetByUserDTO {
    private int userId;

    public PetByUserDTO(){}

    public PetByUserDTO(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetByUserDTO that = (PetByUserDTO) o;
        return userId == that.userId;
    }


}
