package com.mergen.vtys.vtysdatabaseap.Service;



public interface HelperService<T> {
    T Create(T model);
    T Update(Long id, T model);
    String Delete(Long id);

}
