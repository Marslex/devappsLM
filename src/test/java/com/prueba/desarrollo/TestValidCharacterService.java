package com.prueba.desarrollo;

import com.prueba.desarrollo.pojo.model.ValidCharacter;
import com.prueba.desarrollo.pojo.repository.ValidCharacterRepository;
import com.prueba.desarrollo.service.ValidCharacterService;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestValidCharacterService {

    @Test
    public void testValidCharacterService(){
        ValidCharacterRepository validCharacterRepository = mock(ValidCharacterRepository.class);
        List<ValidCharacter> characters = initList();
        when(validCharacterRepository.findAll()).thenReturn(characters);

        ValidCharacterService validCharacterService = new ValidCharacterService(validCharacterRepository);

        List<ValidCharacter> charactersList = validCharacterService.getAll();
        assertNotNull(charactersList);
        assertTrue(!charactersList.isEmpty());
    }

    public static List<ValidCharacter> initList(){
        List<ValidCharacter> list = new ArrayList<>();
        ValidCharacter character1 = new ValidCharacter(Long.valueOf(1),"1");
        ValidCharacter character2 = new ValidCharacter(Long.valueOf(2),"2");
        ValidCharacter character3 = new ValidCharacter(Long.valueOf(3),"3");
        ValidCharacter character4 = new ValidCharacter(Long.valueOf(4),"4");
        ValidCharacter character5 = new ValidCharacter(Long.valueOf(5),"5");
        ValidCharacter character6 = new ValidCharacter(Long.valueOf(6),"6");
        ValidCharacter character7 = new ValidCharacter(Long.valueOf(7),"7");
        ValidCharacter character8 = new ValidCharacter(Long.valueOf(8),"8");
        ValidCharacter character9 = new ValidCharacter(Long.valueOf(9),".");
        list.add(character1);
        list.add(character2);
        list.add(character3);
        list.add(character4);
        list.add(character5);
        list.add(character6);
        list.add(character7);
        list.add(character8);
        list.add(character9);

        return list;
    }
}
