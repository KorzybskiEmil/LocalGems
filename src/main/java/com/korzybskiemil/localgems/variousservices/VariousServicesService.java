package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.applicationuser.ApplicationUser;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserNotFoundException;
import com.korzybskiemil.localgems.applicationuser.ApplicationUserRepository;
import com.korzybskiemil.localgems.variousservices.dto.NewVariousServicesDto;
import com.korzybskiemil.localgems.variousservices.dto.VariousServicesDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VariousServicesService {

    private final VariousServicesRepository variousServicesRepository;
    private final ApplicationUserRepository applicationUserRepository;
    private final VariousServicesMapper variousServicesMapper;


    public VariousServicesService(VariousServicesRepository variousServicesRepository, ApplicationUserRepository applicationUserRepository, VariousServicesMapper variousServicesMapper) {
        this.variousServicesRepository = variousServicesRepository;
        this.applicationUserRepository = applicationUserRepository;
        this.variousServicesMapper = variousServicesMapper;
    }

    public VariousServicesDto saveNewVariousServices(NewVariousServicesDto newVariousServicesDto) {
        ApplicationUser applicationUser = applicationUserRepository.findById(newVariousServicesDto.userUUID())
                .orElseThrow(() -> getApplicationUserNotFoundException(newVariousServicesDto.userUUID()));

        VariousServices savedVariousServices = variousServicesRepository.save(variousServicesMapper.mapNewDtoToEntity(newVariousServicesDto, applicationUser));
        return variousServicesMapper.mapEntityToDto(savedVariousServices);
    }

    public List<VariousServicesDto> getAllVariousServices() {
        return variousServicesRepository.findAll().stream()
                .map(variousServicesMapper::mapEntityToDto)
                .toList();
    }

    public VariousServicesDto updateVariousServices(UUID id, @Valid NewVariousServicesDto updateVariousServices) {
        VariousServices variousServices = variousServicesRepository.findById(id)
                .orElseThrow(() -> getVariousServicesNotFoundException(id));

        variousServices.setServiceOptions(updateVariousServices.serviceOptions());
        variousServices.setPricePerHour(updateVariousServices.pricePerHour());
        variousServices.setDescription(updateVariousServices.description());

        VariousServices save = variousServicesRepository.save(variousServices);
        return variousServicesMapper.mapEntityToDto(save);
    }

    public void deleteVariousServices(UUID id) {
        variousServicesRepository.findById(id)
                .orElseThrow(() -> getVariousServicesNotFoundException(id));

        variousServicesRepository.deleteById(id);
    }

    private VariousServicesNotFoundException getVariousServicesNotFoundException(UUID id) {
        return new VariousServicesNotFoundException("Service with id: " + id + " does not exist");
    }

    private ApplicationUserNotFoundException getApplicationUserNotFoundException(UUID applicationUserId) {
        return new ApplicationUserNotFoundException("Application User with id: " + applicationUserId + " does not exist");
    }
}
