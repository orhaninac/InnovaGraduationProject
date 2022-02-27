package com.orhaninac.innovagraduationproject.business.concrates;

import com.orhaninac.innovagraduationproject.business.abstracts.CreditApplicationService;
import com.orhaninac.innovagraduationproject.business.dtos.ListCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.dtos.CreateCreditApplicationDto;
import com.orhaninac.innovagraduationproject.business.requests.MakeApplicationRequest;
import com.orhaninac.innovagraduationproject.core.utilities.mapper.ModelMapperService;
import com.orhaninac.innovagraduationproject.dataAccess.CreditApplicationRepository;
import com.orhaninac.innovagraduationproject.dataAccess.UserRepository;
import com.orhaninac.innovagraduationproject.entities.CreditApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CreditApplicationManager implements CreditApplicationService {

    private ModelMapperService modelMapperService;
    private CreditApplicationRepository creditApplicationRepository;
    private UserRepository userRepository;

    public CreditApplicationManager(ModelMapperService modelMapperService, CreditApplicationRepository creditApplicationRepository, UserRepository userRepository) {
        this.modelMapperService = modelMapperService;
        this.creditApplicationRepository = creditApplicationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ListCreditApplicationDto> getAll() {
        return null;
    }

    @Override
    public void add(CreateCreditApplicationDto createCreditApplicationRequest) {
        CreditApplication creditApplication = modelMapperService.forRequest().map(createCreditApplicationRequest, CreditApplication.class);

        try {
            creditApplicationRepository.save(creditApplication);
            log.info("başvuru veri tabanına kaydedildi", creditApplication.getId());
        }catch (Exception e){
            log.error("Başvuru kaydedilirken hata oluştu");
        }
    }


    @Override
    public ListCreditApplicationDto getById(int id) {
        return null;
    }


    @Override
    public String calculateCreditScore(MakeApplicationRequest makeApplicationRequest) {
        double salary=userRepository.getByIdentityNumber(makeApplicationRequest.getIdentityNumber()).getSalary();

        CreateCreditApplicationDto creditApplication=new CreateCreditApplicationDto();
        creditApplication.setCreditScore(makeApplicationRequest.getCreditScore());
        creditApplication.setUserID(userRepository.getByIdentityNumber(makeApplicationRequest.getIdentityNumber()).getId());
        double creditLimit=0;
        String creditStatus="";
        String sonuc="";
        if(makeApplicationRequest.getCreditScore()<500){
            sonuc= "REDDEDİLDİ";
            creditApplication.setCreditStatus("RED");
            creditApplication.setCreditLimit(0);
        }
        else if(makeApplicationRequest.getCreditScore()>=500){
            if(salary<5000){
                sonuc=  "ONAYLANDI (LİMİT : 10.000  TL)";
                creditApplication.setCreditStatus("ONAY");
                creditApplication.setCreditLimit(10000);
            }
            else if(salary>=5000){
                sonuc=  "ONAYLANDI (LİMİT : 20.000  TL)";
                creditApplication.setCreditStatus("ONAY");
                creditApplication.setCreditLimit(20000);
            }
        }
        else if(makeApplicationRequest.getCreditScore()>1000){
            sonuc=  "ONAYLANDI (LİMİT : "+ (salary*4)+"TL)";
            creditApplication.setCreditStatus("ONAY");
            creditApplication.setCreditLimit(salary*4);
        }
        this.add(creditApplication);
        return sonuc;
    }
}
