package com.mergen.vtys.vtysdatabaseap.Service.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Service.TitleService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "title")
@Slf4j
public class TitleController {

    private final TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Title>> getTitleList(){
        List<Title> titleList = titleService.getTitleList();
        log.info("All Title Returned - {}",titleList);
        return ResponseEntity.ok(titleList);
    }
    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Optional<Title>> getTitleByID(@PathVariable Long id) {
        Optional<Title> status = titleService.getTitleByID(id);
        log.info("Title Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Title> createTitle(@RequestBody Title title) {
        Title status = titleService.Create(title);
        log.info("title Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(title);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateTitle(@PathVariable Long id, @RequestBody Title title ){
        String status = titleService.Update(id,title);
        log.info("Title Updated Status - {}",status);
        return ResponseEntity.ok(title.getTitle_name() + " updated!");
    }
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteTitle(@PathVariable() Long id) {
        String status =titleService.Delete(id);
        log.info("Title Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th Department deleted!");
    }
}
