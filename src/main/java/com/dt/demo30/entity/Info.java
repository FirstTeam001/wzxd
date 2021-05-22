package com.dt.demo30.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Info implements Serializable {

  private int id;
  private String name;
  private int age;

}
