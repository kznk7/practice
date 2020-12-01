package oit.is.room2.practice.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FruitMapper {
  @Select("SELECT ID, NAME,PRICE FROM FRUIT")
  ArrayList<Fruit> selectAllFruit();

}
