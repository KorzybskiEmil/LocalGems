package com.korzybskiemil.localgems.variousservices;

import com.korzybskiemil.localgems.variousservices.dto.NewVariousServicesDto;
import com.korzybskiemil.localgems.variousservices.dto.VariousServicesDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VariousServicesService {

    private final VariousServicesRepository variousServicesRepository;
    private final VariousServicesMapper variousServicesMapper;


    public VariousServicesService(VariousServicesRepository variousServicesRepository, VariousServicesMapper variousServicesMapper) {
        this.variousServicesRepository = variousServicesRepository;
        this.variousServicesMapper = variousServicesMapper;
    }

    public VariousServicesDto saveNewVariousServices(NewVariousServicesDto newVariousServicesDto) {
        VariousServices savedVariousServices = variousServicesRepository.save(variousServicesMapper.mapNewDtoToEntity(newVariousServicesDto));
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
}
