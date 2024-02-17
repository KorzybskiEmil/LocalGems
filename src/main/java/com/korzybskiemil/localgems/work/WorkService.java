package com.korzybskiemil.localgems.work;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.work.dto.NewWorkDto;
import com.korzybskiemil.localgems.work.dto.WorkDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkService {

    private final WorkRepository workRepository;
    private final ApplicationUserRepository applicationUserRepository;

    private final WorkMapper workMapper;

    public WorkService(WorkRepository workRepository, ApplicationUserRepository applicationUserRepository, WorkMapper workMapper) {
        this.workRepository = workRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.workMapper = workMapper;
    }

    public WorkDto savedNewWorkDto(NewWorkDto newWorkDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(newWorkDto.userUUID())
                .orElseThrow(() -> getApplicationUserNotFoundException(newWorkDto.userUUID()));

        Work savedWork = workRepository.save(workMapper.mapNewDtoToEntity(newWorkDto, applicationUser));
        return workMapper.mapEntityToDto(savedWork);
    }

    public List<WorkDto> getAllWork() {
        return workRepository.findAll().stream()
                .map(workMapper::mapEntityToDto)
                .toList();
    }

    public WorkDto updateWork(UUID id, @Valid NewWorkDto updateWork) {
        Work work = workRepository.findById(id)
                .orElseThrow(() -> getWorkNotFoundException(id));

        work.setEmploymentType(updateWork.employmentType());
        work.setWorkingHours(updateWork.workingHours());
        work.setExperienceRequired(updateWork.experienceRequired());
        work.setPlaceOfWork(updateWork.placeOfWork());
        work.setCityWhereIsWork(updateWork.cityWhereIsWork());
        work.setDescription(updateWork.description());

        Work save = workRepository.save(work);
        return workMapper.mapEntityToDto(save);
    }

    public void deleteWork(UUID id) {
        workRepository.findById(id)
                .orElseThrow(() -> getWorkNotFoundException(id));

        workRepository.deleteById(id);
    }

    private WorkNotFoundException getWorkNotFoundException(UUID id) {
        return new WorkNotFoundException("Job with id: " + id + " does not exist");
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID applicationUserId) {
        return new ApplicationUserNotFoundException("Application User with id: " + applicationUserId + " does not exist");
    }

}
