package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.VacationRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.expression.spel.ast.OpAnd;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface VacationRequestService extends HelperService<VacationRequest>{
    List<VacationRequest> getVacationRequestList();
    Optional<VacationRequest> getVacationRequestById(Long id);
    String EarnedVacationDays(Long id) throws ParseException;
    String GetDate_of_Start(@Param("id") Long id);
}
