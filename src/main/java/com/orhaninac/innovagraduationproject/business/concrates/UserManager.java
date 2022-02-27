package com.orhaninac.innovagraduationproject.business.concrates;

import com.orhaninac.innovagraduationproject.business.abstracts.UserService;
import com.orhaninac.innovagraduationproject.business.dtos.ListCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.dtos.ListUserDto;
import com.orhaninac.innovagraduationproject.business.requests.CreateUserRequest;
import com.orhaninac.innovagraduationproject.business.requests.UpdateUserRequest;
import com.orhaninac.innovagraduationproject.core.utilities.mapper.ModelMapperService;
import com.orhaninac.innovagraduationproject.dataAccess.CreditApplicationRepository;
import com.orhaninac.innovagraduationproject.dataAccess.UserRepository;
import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import com.orhaninac.innovagraduationproject.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserManager implements UserService {
    private ModelMapperService modelMapperService;
    private UserRepository userRepository;
    private CreditApplicationRepository creditApplicationRepository;

    @Autowired
    public UserManager(UserRepository userRepository, CreditApplicationRepository creditApplicationRepository,ModelMapperService modelMapperService) {
        this.modelMapperService = modelMapperService;
        this.userRepository = userRepository;
        this.creditApplicationRepository = creditApplicationRepository;
    }

    @Override
    public List<ListUserDto> getAll() {
        return null;
    }

    @Override
    public User add(CreateUserRequest createUserRequest) {
        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        try {
            userRepository.save(user);
            log.info("Kullanıcı kaydedildi", user.getName());
        }catch (Exception e){
            log.error("Kullanıcı kaydı sırasında hata oluştu");
        }

        return user;
    }
    @Override
    public ListUserDto getById(int id) {
        return null;
    }

    @Override
    public User update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        try {
            this.userRepository.save(user);
            log.info("Kullanıcı güncellendi", user.getName());
        }catch (Exception e){
            log.error("Kullanıcı güncelenirken hata oluştu");
        }
        return user;
    }

    @Override
    public void delete(int id) {
        try {
            userRepository.deleteById(id);
            log.info("Kullanıcı silindi");
        }catch (Exception e){
            log.error("Kullanıcı silinirken hata oluştu");
        }
    }

    @Override
    public List<ListCreditApplicationDto> applications(String identityNumber) {
         int id =userRepository.getByIdentityNumber(identityNumber).getId();

        List<CreditApplication> result = this.creditApplicationRepository.getByUserId(id);
        List<ListCreditApplicationDto> response = result.stream()
                .map(creditApplication -> this.modelMapperService.forDto().map(creditApplication, ListCreditApplicationDto.class))
                .collect(Collectors.toList());
        return response;
    }
}
