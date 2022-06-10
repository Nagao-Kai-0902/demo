package com.example.demo.model;

import javax.validation.GroupSequence;

@GroupSequence({ ValidGroup.class, ValidGroup2.class,ValidGroup3.class,ValidGroup4.class})
public interface GroupOrder {

}
