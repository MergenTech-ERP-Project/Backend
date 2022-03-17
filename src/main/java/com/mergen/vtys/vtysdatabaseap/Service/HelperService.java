package com.mergen.vtys.vtysdatabaseap.Service;



public interface HelperService<T> {

    T Create(T model);
    String Update(Long id, T model);
    String Delete(Long id);

}