package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import org.springframework.ui.Model;

public interface HelperService<T> {
    T Create(T model);
    String Update(Long id, T model);
    String Delete(Long id);
}
