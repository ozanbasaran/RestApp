package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Menu;
import com.finartz.RestApp.model.Menu;
import com.finartz.RestApp.repository.MenuRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {
    private static final int InitStatus = 115 ;
    private static final int NewStatus= 120;
    @InjectMocks
    private MenuService menuService;

    @Mock
    private MenuRepository menuRepository;


    @Test
    public void whenFetchAll_thenReturnAllMenu() {
        Menu county1 = Menu.builder().id(1l).item_count(115).build();
        Menu county2 = Menu.builder().id(2l).item_count(120).build();
        List<Menu> commentList = Arrays.asList(county1, county2);

        Mockito.when(menuRepository.findAll()).thenReturn(commentList);

        List<Menu> fetchedList = menuService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnMenu() {
        Menu menu = Menu.builder().item_count(115).build();

        Mockito.when(menuRepository.getById(1L)).thenReturn(menu);

        Menu fetchedMenu = menuService.findById(1L);

        assertEquals(menu.getId(), fetchedMenu.getId());
    }

    @Test
    public void whenAddMenu_thenReturnSavedMenu() {
        Menu menu = Menu.builder().item_count(500).build();

        Mockito.doReturn(menu).when(menuRepository).save(menu);

        Menu returnedMenu = menuService.create(menu);

        assertEquals(menu.getItem_count(), returnedMenu.getItem_count());
    }

    @Test
    public void whenUpdateMenu_thenReturnUpdatedMenu(){
        Menu existMenu = Menu.builder().id(1L).item_count(InitStatus).build();
        Menu newMenu = Menu.builder().id(1L).item_count(NewStatus).build();
        Mockito.when(menuRepository.getById(1L)).thenReturn(existMenu);
        Mockito.when(menuRepository.save(newMenu)).thenReturn(newMenu);
        Menu updatedMenu = menuService.update(newMenu);
        Assertions.assertEquals(existMenu.getItem_count(), InitStatus);
        Assertions.assertNotEquals(existMenu.getItem_count(), NewStatus);
    }

}