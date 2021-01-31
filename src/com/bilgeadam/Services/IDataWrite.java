package com.bilgeadam.Services;

import java.util.List;

interface IDataWrite<T> {

    List<T> findAll();
    void save(T data);


}
