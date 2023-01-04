package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.UserMDto;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserM;
import com.mergen.vtys.vtysdatabaseap.Repository.UserMRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@AllArgsConstructor
class UserMServiceImplTest {


    @Mock
    UserMRepository userMRepository;
    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    UserMServiceImpl underTest;

    @Test
    @DisplayName("Test List Users Service")
    void getUserMLists() {

        // given
        UserM expected = new UserM();
        expected.setId(25L);
        expected.setUsername("TestUser");
        expected.setEmail("testuser@gmail.com");
        expected.setCellphone("555555555");
        expected.setTitle("Engineer");

        UserM userM = modelMapper.map(expected,UserM.class);

        // no customer with this identificationNumber
        when(userMRepository.findById(any())).
                thenReturn(Optional.empty());

        // mocking save method
        when(userMRepository.save(any())).thenReturn(expected);

        // when
        UserMDto actual = underTest.Create( modelMapper.map(userMRepository.save(userM), UserMDto.class));

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual),
                () -> assertEquals(expected.getId(), actual.getId()),
                () -> assertEquals(expected.getUsername(), actual.getUsername())
        );
    }

    @Test
    void getUserMById() {
    }

    @Test
    void getUserMByName() {
    }

    @Test
    void getUserMNameAndPassword() {
    }

    @Test
    void getUserMEmailAndPassword() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}