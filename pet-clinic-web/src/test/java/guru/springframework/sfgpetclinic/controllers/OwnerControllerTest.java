package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @Mock
    private Model model;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<Owner>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(this.ownerService.findAll()).thenReturn(owners);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", Matchers.hasSize(2)));//this line verifies the qty of elements from the this.owners. See 'when' above.

//        The lines below test the functionalities as the lines above (except the method isOk()).
//        String listOwners = this.controller.listOwners(this.model);
//        assertEquals("owners/index", listOwners);
//        verify(this.service).findAll();
//        assertEquals(2, this.service.findAll().size());
    }

    @Test
    void listOwnersIndexPath() throws Exception {
        when(this.ownerService.findAll()).thenReturn(owners);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", Matchers.hasSize(2)));//this line verifies the qty of elements from the this.owners. See 'when' above.

    }

    @Test
    void findOwners() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notimplemented"));

        verifyNoInteractions(this.ownerService);
    }


    @Test
    void showOwner() throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);

        when(this.ownerService.findById(anyLong())).thenReturn(owner);

        ModelAndView modelAndView = this.ownerController.showOwner(anyLong());
        Owner owner1 = (Owner) modelAndView.getModelMap().getAttribute("owner");

        this.mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));

        assertNotNull(owner1);
    }

}
