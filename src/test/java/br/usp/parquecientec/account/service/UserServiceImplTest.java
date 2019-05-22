package br.usp.parquecientec.account.service;

import br.usp.parquecientec.account.model.User;
import br.usp.parquecientec.account.repository.UserRepository;
import br.usp.parquecientec.account.util.UserValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(value = {SpringExtension.class, MockitoExtension.class})
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl service;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserValidation userValidation;

    @Test
    @DisplayName("Return null if user not found")
    void returnNullIfUserIdnotFound() throws Exception {
        int userCode = 10;
        User user = new User();
        User update = service.update(userCode, user);
        assertNull(update);
    }

    @Test
    @DisplayName("Thowe exception when User name is null")
    void returnAnObjectIfUserIdExist() throws Exception {
        int userCode = 1;
        User user = new User();

        Optional<User> userOptional = Optional.of(new User());
        when(userRepository.findById(anyInt())).thenReturn(userOptional);
        doThrow(Exception.class).when(userValidation).validate(any());

        assertThrows(Exception.class, () -> service.update(userCode, user));

    }

    @Test
    @DisplayName("Return updatad user with success when user is valid")
    void returnsAnObjectIfUserIdExist() throws Exception {
        int userCode = 1;
        User user = mockValidUser();

        Optional<User> userOptional = Optional.of(new User());
        when(userRepository.findById(anyInt())).thenReturn(userOptional);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        service.update(userCode, user);

        verify(userRepository, times(1)).save(captor.capture());

        User value = captor.getValue();

        assertEquals(user, value);
        assertEquals(Integer.valueOf(1), value.getCode());
    }

    private User mockValidUser() {
        User user = new User();
        user.setFirstName("Nathalia");
        user.setLastName("Pitombeira");
        user.setEmail("nah.manso@gmail.com");
        user.setPhone("11 94442-8742");
        user.setBusinessRole("ADMIN");
        user.setDocumentCode("29.609.617-9");
        user.setDocumentType("RG");
        return user;
    }
}