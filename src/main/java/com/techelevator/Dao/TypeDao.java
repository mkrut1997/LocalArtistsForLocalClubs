package com.techelevator.Dao;

import com.techelevator.Models.Type;

import java.util.List;

public interface TypeDao {
    Type getType(int typeId);
    List<Type> getAllTypes();
}
