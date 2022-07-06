package com.roshka.spring.spring;

import com.roshka.spring.spring.model.Reaccion;
import com.roshka.spring.spring.service.ReaccionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReaccionServiceTest {

    @Autowired
    private ReaccionService reaccionService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Reaccion> reacciones = reaccionService.list();

        Assert.assertEquals(reacciones.size(), 2);
    }
}