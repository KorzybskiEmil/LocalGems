package com.korzybskiemil.localgems.applicationuser;

import com.korzybskiemil.localgems.applicationuser.dto.ApplicationUserDto;
import com.korzybskiemil.localgems.applicationuser.dto.NewApplicationUserDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping
    public List<ApplicationUserDto> getAllApplicationUsers() {
        return applicationUserService.getAllApplicationUsers();
    }

    @GetMapping("/{id}")
    public ApplicationUserDto getOneById(@PathVariable UUID id) {
        return applicationUserService.getOneById(id);
    }

    @PostMapping
    public ApplicationUserDto createNewApplicationUser(@Valid @RequestBody NewApplicationUserDto newApplicationUserDto) {
        return applicationUserService.saveNewApplicationUser(newApplicationUserDto);
    }

    @PutMapping("/{id}")
    public ApplicationUserDto updateApplicationUser(@PathVariable UUID id, @Valid @RequestBody NewApplicationUserDto updateApplicationUserDto) {
        return applicationUserService.updateApplicationUser(id, updateApplicationUserDto);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicationUser(@PathVariable UUID id) {
        applicationUserService.deleteApplicationUser(id);
    }
}
