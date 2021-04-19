package com.zero.mycommunity.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoImpl implements AlphaDao {
    @Override
    public String  select() {
        return "select hiberate!";
    }
}
