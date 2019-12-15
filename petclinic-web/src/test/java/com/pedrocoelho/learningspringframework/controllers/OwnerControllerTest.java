package com.pedrocoelho.learningspringframework.controllers;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.services.OwnerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerServiceImpl ownerService;

    @InjectMocks
    OwnerController ownerController;

    private MockMvc mockMvc;

    private Set<Owner> ownerSet;
    private Owner o1;
    private Owner o2;
    private Owner o3;
    private Owner o4;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        o1 = Owner.builder().id(333L).firstName("Leo").lastName("Salut").build();
        o2 = Owner.builder().id(334L).firstName("Luka").lastName("Modric").build();
        o3 = Owner.builder().id(335L).firstName("Leo").lastName("Fonseca").build();
        o4 = Owner.builder().id(336L).firstName("Sandro").lastName("Modric").build();
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

        verify(ownerService, times(1)).findAll();
    }

    @Test
    void findOwnersByFirsNameReturnMany() throws Exception {
        Set<Owner> owners = new HashSet<>(Arrays.asList(o1, o3));
        when(ownerService.findAllByFirstName(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners/find?firstName=Leo"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"));
//                .andExpect(model().attribute("owners", hasSize(owners.size())));

        assertEquals(owners.size(), 2);

        verify(ownerService, times(1)).findAllByFirstName(anyString());
    }

    @Test
    void findOwnersByFirsNameReturnOne() throws Exception {
        Set<Owner> owners = new HashSet<>(Collections.singletonList(Owner.builder().id(222L).firstName("Test").lastName("Owner").build()));
        when(ownerService.findAllByFirstName(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners/find?firstName=Luka"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(owners.size())));

        verify(ownerService, times(1)).findAllByFirstName(anyString());
    }

    @Test
    void findOwnersByFirsNameReturnZero() throws Exception {
        Set<Owner> owners = Collections.emptySet();
        when(ownerService.findAllByFirstName(anyString())).thenReturn(owners);

        mockMvc.perform(get("/owners/find?firstName=Sven"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(owners.size())));

        verify(ownerService, times(1)).findAllByFirstName(anyString());
    }
}