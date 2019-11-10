package com.pedrocoelho.learningspringframework.controllers;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.services.OwnerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerServiceImpl ownerService;

    @InjectMocks
    OwnerController ownerController;

    private MockMvc mockMvc;

    private Set<Owner> ownerSet;

    @BeforeEach
    void setUp() {
        Owner o1 = Owner.builder().id(333L).firstName("Leo").lastName("Salut").build();
        Owner o2 = Owner.builder().id(334L).firstName("Luka").lastName("Modric").build();
        Owner o3 = Owner.builder().id(335L).firstName("Leo").lastName("Fonseca").build();
        Owner o4 = Owner.builder().id(336L).firstName("Sandro").lastName("Modric").build();
        ownerSet = new HashSet<>(Arrays.asList(o1, o2, o3, o4));

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @AfterEach
    void tearDown() {
//        System.out.println(ownerSet);
    }

    @Test
    void getOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(ownerSet.size())));

        verify(ownerService,times(1)).findAll();
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("not_implemented"));

        verifyZeroInteractions(ownerService);
    }
}