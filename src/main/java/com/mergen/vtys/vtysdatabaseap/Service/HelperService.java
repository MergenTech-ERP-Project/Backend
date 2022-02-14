package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.User;

import java.util.Optional;

public interface HelperService<T> {
    String Create(T model);
    String Update(Long id, T model);
    String Delete(Long id);
}
