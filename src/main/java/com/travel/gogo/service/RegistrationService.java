package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.RegistrationConverted;
import com.travel.gogo.entity.Registrations;
import com.travel.gogo.repository.RegistrationRepository;
import com.travel.gogo.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public void addRegistration(RegistrationRequest registrationRequest) {
        Registrations registration = RegistrationConverted.convertRegistrationRequest(registrationRequest);
        registration.setCreatedTime(LocalDateTime.now());
        registrationRepository.save(registration);
    }

    public boolean editRegistration(RegistrationRequest registrationRequest) {
        if (registrationRequest.getId() == null) {
            return false;
        }
        int id = registrationRequest.getId();

        Registrations registration = registrationRepository.findById(id).orElse(null);
        if (registration == null) {
            return false;
        }
        registration.setPostId(registrationRequest.getPostId());
        registration.setName(registrationRequest.getName());
        registration.setPhone(registrationRequest.getPhone());
        registration.setStatus(registrationRequest.getStatus());
        try {
            registrationRepository.save(registration);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Registrations getById(int id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public List<Registrations> getAll() {
        return
                StreamSupport.stream(registrationRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
    }

    public List<Registrations> getPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        return registrationRepository.findAll(pageable);
    }

    public boolean deleteById(int id) {

        Registrations registration = registrationRepository.findById(id).orElse(null);
        if (registration == null) {
            return false;
        }
        registration.setStatus(Status.BLOCK);
        try {
            registrationRepository.save(registration);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Registrations> getRegistrationWithOutSendMail() {
        return registrationRepository.findAllBySendMailIsFalseOrSendMailIsNull();
    }

    public void updateSendMail(List<Registrations> registrations) {
        registrations.forEach( registration -> {
            registration.setSendMail(Boolean.TRUE);
        });
        registrationRepository.saveAll(registrations);
    }
}
