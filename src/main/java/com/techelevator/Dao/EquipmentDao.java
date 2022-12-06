package com.techelevator.Dao;

import com.techelevator.Models.Equipment;

import java.util.List;

public interface EquipmentDao {
    Equipment getEquipment(int eqId);
    List<Equipment> getAllEquipment();

}
