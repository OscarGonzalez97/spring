package com.roshka.spring.spring;

import com.roshka.spring.spring.controller.ReaccionControllerRest;
import com.roshka.spring.spring.model.Reaccion;
import com.roshka.spring.spring.service.ReaccionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReaccionControllerRestTest {

    private MockMvc mockMvc;

    @Mock
    private ReaccionService reaccionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ReaccionControllerRest controller = new ReaccionControllerRest(reaccionService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testListReacciones() throws Exception {
        Reaccion reaccion1 = new Reaccion();
        reaccion1.setId(1L);
        reaccion1.setTipo("Me gusta");
        reaccion1.setIcono("icono1");

        Reaccion reaccion2 = new Reaccion();
        reaccion2.setId(2L);
        reaccion2.setTipo("Me encanta");
        reaccion2.setIcono("icono2");

        List<Reaccion> reacciones = Arrays.asList(reaccion1, reaccion2);

        when(reaccionService.list()).thenReturn(reacciones);

        mockMvc.perform(get("/list-rest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].tipo").value("Me gusta"))
                .andExpect(jsonPath("$[0].icono").value("icono1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].tipo").value("Me encanta"))
                .andExpect(jsonPath("$[1].icono").value("icono2"));

        verify(reaccionService, times(1)).list();
        verifyNoMoreInteractions(reaccionService);
    }

    @Test
    public void testCreateReaccion() throws Exception {
        Reaccion reaccion = new Reaccion();
        reaccion.setId(1L);
        reaccion.setTipo("Me gusta");
        reaccion.setIcono("icono1");

        when(reaccionService.save(any(Reaccion.class))).thenReturn(reaccion);

        mockMvc.perform(post("/create-rest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"tipo\":\"Me gusta\",\"icono\":\"icono1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.tipo").value("Me gusta"))
                .andExpect(jsonPath("$.icono").value("icono1"));

        verify(reaccionService, times(1)).save(any(Reaccion.class));
        verifyNoMoreInteractions(reaccionService);
    }
}

