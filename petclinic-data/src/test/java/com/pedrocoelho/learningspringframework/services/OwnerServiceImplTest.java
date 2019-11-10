package com.pedrocoelho.learningspringframework.services;

import com.pedrocoelho.learningspringframework.model.Owner;
import com.pedrocoelho.learningspringframework.repositories.OwnerRepository;
import com.pedrocoelho.learningspringframework.repositories.PetRepository;
import com.pedrocoelho.learningspringframework.repositories.PetTypeRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceImpl ownerService;


    private final Long ID = 333L;
    private final String FIRST_NAME = "Leo";
    private final String LAST_NAME = "Smith";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ID).firstName(FIRST_NAME).lastName(LAST_NAME).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(334L).firstName("Rúben").lastName("Cabrito").build());
        ownerSet.add(Owner.builder().id(335L).firstName("Cristiana").lastName("Cabrito").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerService.findAll();

        assertAll(
                () -> assertEquals(owners.size(), 2),
                () -> assertEquals(owners.size(), ownerSet.size()),
                () -> assertEquals(new ArrayList<>(owners).get(0), new ArrayList<>(ownerSet).get(0)),
                () -> assertEquals(new ArrayList<>(owners).get(1), new ArrayList<>(ownerSet).get(1)),
                () -> assertEquals(owners, ownerSet)
        );

        verify(ownerRepository, times(1)).findAll();

    }

    @Test
    void findAllByFirstName() {
        Owner o1 = Owner.builder().id(777L).firstName(FIRST_NAME).lastName("Pan").build();

        when(ownerRepository.findAllByFirstName(FIRST_NAME)).thenReturn(new HashSet<>(Arrays.asList(returnOwner, o1)));

        Set<Owner> owners = ownerService.findAllByFirstName(FIRST_NAME);

        assertAll(
                () -> assertNotNull(owners),
                () -> assertEquals(new ArrayList<>(owners).get(0).getFirstName(), FIRST_NAME),
                () -> assertEquals(new ArrayList<>(owners).get(1).getFirstName(), FIRST_NAME)
        );

        verify(ownerRepository, times(1)).findAllByFirstName(any());
    }

    @Test
    void findAllByLastName() {
        Owner o2 = Owner.builder().id(778L).firstName("Peter").lastName(LAST_NAME).build();

        when(ownerRepository.findAllByLastName(LAST_NAME)).thenReturn(new HashSet<>(Arrays.asList(returnOwner, o2)));

        Set<Owner> owners = ownerService.findAllByLastName(LAST_NAME);

        assertAll(
                () -> assertNotNull(owners),
                () -> assertEquals(new ArrayList<>(owners).get(0).getLastName(), LAST_NAME),
                () -> assertEquals(new ArrayList<>(owners).get(1).getLastName(), LAST_NAME)
        );


        verify(ownerRepository, times(1)).findAllByLastName(any());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.ofNullable(returnOwner));
        Owner owner = ownerService.findById(ID);
        assertEquals(owner, returnOwner);
        verify(ownerRepository, times(1)).findById(any());
    }

    @Test
    void findByFirstName() {
        when(ownerRepository.findByFirstName(FIRST_NAME)).thenReturn(Optional.ofNullable(returnOwner));
        Owner owner = ownerService.findByFirstName(FIRST_NAME);
        assertAll(
                () -> assertNotNull(owner),
                () -> assertEquals(owner.getFirstName(), FIRST_NAME)
        );
        verify(ownerRepository, times(1)).findByFirstName(any());

        when(ownerRepository.findByFirstName(any())).thenReturn(Optional.empty());
        Owner ownerNull = ownerService.findByFirstName("Luka");
        assertNull(ownerNull);
        verify(ownerRepository, times(2)).findByFirstName(any());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(Optional.ofNullable(returnOwner));
        Owner owner = ownerService.findByLastName(LAST_NAME);
        assertAll("owner",
                () -> assertNotNull(owner),
                () -> assertEquals(owner.getLastName(), LAST_NAME)
        );
        verify(ownerRepository, times(1)).findByLastName(any());

        when(ownerRepository.findByLastName("Modric")).thenReturn(Optional.empty());
        Owner nullOwner = ownerService.findByLastName("Modric");
        assertNull(nullOwner);
        verify(ownerRepository, times(2)).findByLastName(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerService.save(returnOwner);

        assertAll(
                () -> assertNotNull(savedOwner),
                () -> assertEquals(savedOwner.getId(), returnOwner.getId())
        );

        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void saveAll() {
        List<Owner> returnOwners = new ArrayList<>(
                Arrays.asList(
                        returnOwner,
                        Owner.builder().id(777L).firstName("Peter").lastName("Pan").build()
                )
        );

        when(ownerRepository.saveAll(any())).thenReturn(returnOwners);

        Set<Owner> owners = ownerService.saveAll(returnOwners);

        assertAll(
                () -> assertEquals(owners.size(), returnOwners.size()),
                () -> assertNotNull(owners)
        );

        verify(ownerRepository, times(1)).saveAll(any());
    }

    @Test
    void delete() {
        when(ownerRepository.findByFirstName(FIRST_NAME)).thenReturn(Optional.empty());
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(Optional.empty());
        when(ownerRepository.findById(ID)).thenReturn(Optional.empty());

        ownerService.delete(returnOwner);

        assertNull(ownerService.findByFirstName(FIRST_NAME));
        assertTrue(ownerService.findAllByFirstName(FIRST_NAME).isEmpty());
        assertNull(ownerService.findByLastName(LAST_NAME));
        assertTrue(ownerService.findAllByLastName(LAST_NAME).isEmpty());
        assertNull(ownerService.findById(ID));

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        when(ownerRepository.findByFirstName(FIRST_NAME)).thenReturn(Optional.empty());
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(Optional.empty());
        when(ownerRepository.findById(ID)).thenReturn(Optional.empty());

        ownerService.deleteById(ID);

        assertNull(ownerService.findByFirstName(FIRST_NAME));
        assertTrue(ownerService.findAllByFirstName(FIRST_NAME).isEmpty());
        assertNull(ownerService.findByLastName(LAST_NAME));
        assertTrue(ownerService.findAllByLastName(LAST_NAME).isEmpty());
        assertNull(ownerService.findById(ID));

        verify(ownerRepository, times(1)).deleteById(any());
    }
}