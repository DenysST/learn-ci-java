package com.ds.forlearnci;

import com.ds.forlearnci.models.User;
import com.ds.forlearnci.repositories.UserRepository;
import com.ds.forlearnci.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers() {
        when(repository.findAll()).thenReturn(List.of(new User(), new User()));

        List<User> users = userService.getUsers();

        assertEquals(2, users.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testCreateUser() {
        User testUser = new User();
        testUser.setFirstName("John");

        when(repository.save(any(User.class))).thenReturn(testUser);

        User createdUser = userService.createUser(testUser);

        assertEquals("John", createdUser.getFirstName());
        assertNotNull(createdUser.getNickName());

        verify(repository, times(1)).save(any(User.class));
    }
}

