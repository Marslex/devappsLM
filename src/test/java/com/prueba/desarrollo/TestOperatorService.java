package com.prueba.desarrollo;

import com.prueba.desarrollo.pojo.model.Operator;
import com.prueba.desarrollo.pojo.repository.OperatorRepository;
import com.prueba.desarrollo.service.OperatorService;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestOperatorService {

    @Test
    public void testOperatorService(){
        OperatorRepository operatorRepository = mock(OperatorRepository.class);
        List<Operator> operators = initList();
        when(operatorRepository.findAll()).thenReturn(operators);

        OperatorService operatorService = new OperatorService(operatorRepository);

        List<Operator> operatorList = operatorService.getAll();
        assertNotNull(operatorList);
        assertTrue(!operatorList.isEmpty());
    }

    public static List<Operator> initList(){
        List<Operator> list = new ArrayList<>();
        Operator operator1 = new Operator("+",1);
        Operator operator2 = new Operator("+",1);
        Operator operator3 = new Operator("*",2);
        Operator operator4 = new Operator("/",2);

        list.add(operator1);
        list.add(operator2);
        list.add(operator3);
        list.add(operator4);

        return list;
    }
}
