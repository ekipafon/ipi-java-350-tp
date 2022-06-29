package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.repository.EmployeRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    @Test
    public void testFindLastMatriculeWhithoutEmploye(){
        //Given

        //When
        String matricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(matricule).isNull();
    }

    @Test
    public void testFindLastMatriculeWhithEmploye(){
        //Given
        Employe employe = new Employe("Petrillo", "Alexandre", "M12345", LocalDate.now(), 10000.0, 12, 25.2);

        //When
        employeRepository.save(employe);
        String matricule = employeRepository.findLastMatricule();

        //Then
        Assertions.assertThat(matricule).isNull();
    }
}