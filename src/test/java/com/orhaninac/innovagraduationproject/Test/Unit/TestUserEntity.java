package com.orhaninac.innovagraduationproject.Test.Unit;
import com.orhaninac.innovagraduationproject.business.abstracts.UserService;
import com.orhaninac.innovagraduationproject.business.concrates.UserManager;
import com.orhaninac.innovagraduationproject.business.requests.CreateUserRequest;
import com.orhaninac.innovagraduationproject.business.requests.UpdateUserRequest;
import com.orhaninac.innovagraduationproject.core.utilities.mapper.ModelMapperService;
import com.orhaninac.innovagraduationproject.dataAccess.CreditApplicationRepository;
import com.orhaninac.innovagraduationproject.dataAccess.UserRepository;
import com.orhaninac.innovagraduationproject.entities.User;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;


@SpringBootTest
public class TestUserEntity {

    UserRepository userRepository;
    //CREATE
    @Test
    void createTest(){
        User user = createUser();
        //given(userRepository.save(user)).willReturn(user);
        User user2 = userRepository.save(user);
        assertThat(user2).isNotNull();
        assertThat(user2.getName()).isNotNull().isEqualTo(user2.getName());
        assertThat(user2.getIdentityNumber()).isNotNull().isEqualTo(user2.getIdentityNumber());
    }


    //UPDATE
    @Test
   void updateTest(){
        User update=userRepository.findById(1).get();
        update.setName("değiştirdim");
        userRepository.save(update);
        assertNotEquals("eski yapı",update.getName());
    }

    //DELETE
    @Test
    void deleteTest(){
        userRepository.deleteById(2);
        AssertionsForClassTypes.assertThat(userRepository.existsById(1)).isFalse();
    }


    User createUser(){
        User user = new User();
        //user.setId(1);
        user.setName("Orhannklkj");
        user.setSurname("inaç");
        user.setIdentityNumber("12345");
        user.setSalary(5000);
        user.setPhoneNumber("5678");
        return user;
    }

}
