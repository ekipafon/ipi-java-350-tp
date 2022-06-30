package com.ipiecoles.java.java350.service;

import com.ipiecoles.java.java350.exception.EmployeException;
import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.model.NiveauEtude;
import com.ipiecoles.java.java350.model.Poste;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.ldap.ManageReferralControl;

import static com.ipiecoles.java.java350.model.NiveauEtude.CAP;
import static com.ipiecoles.java.java350.model.Poste.MANAGER;

@SpringBootTest
public class EmployeServiceTest {
    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    EmployeService employeService;

    public void testEmbaucheEmploye() throws EmployeException {
        //Given

        //When
        employeService.embaucheEmploye("JeanGui", "MARC", MANAGER, CAP, 12.0);

        //Then
        Employe employe1 = employeRepository.findByMatricule("M00001");
        Assertions.assertThat(employe1).isNull();
    }

    public void testCalculPerformanceCommercial(String matricule, Long caTraite, Long objectifCa) throws EmployeException {
        //Given

        //When
        employeService.calculPerformanceCommercial(matricule, caTraite, objectifCa);

        //Then
        Employe employe1 = employeRepository.findByPerformance(12);

        Assertions.assertThat(employe1).isNull();
    }

}
