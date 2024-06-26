package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.auth.config.SpringSecurityConfig;
import com.korzybskiemil.localgems.work.dto.NewWorkDto;
import com.korzybskiemil.localgems.work.dto.WorkDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/work")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping
    @RolesAllowed(SpringSecurityConfig.USER)
    public WorkDto createNewWork(@Valid @RequestBody NewWorkDto newWorkDto) {
        return workService.savedNewWorkDto(newWorkDto);
    }

    @GetMapping
    public List<WorkDto> getWork() {
        return workService.getAllWork();
    }

    @PutMapping("/{id}")
    public WorkDto updateWork(@PathVariable UUID id, @Valid @RequestBody NewWorkDto updateWork) {
        return workService.updateWork(id, updateWork);
    }

    @DeleteMapping("/{id}")
    public void deleteWork(@PathVariable UUID id) {
        workService.deleteWork(id);
    }
}
