package com.game.find_a_cat.service;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CatHidingServiceTest {

    CatHidingService catHide;
    CatPositionGenerateService catPos;

    @BeforeAll
    void setup() {
        catPos = mock(CatPositionGenerateService.class);
        when(catPos.generateIndexOfCat(anyInt()))
                .thenReturn(new int[]{1,1});

        catHide = new CatHidingService(catPos);
    }

    @Test
    @Order(1)
    void shouldIncreaseNTo6() {
        boolean status = catHide.checkResult(1,1);
        int n = catHide.getN();
        assertTrue(status);
        assertEquals(6, n);
    }

    @Test
    @Order(2)
    void shouldDecreaseNTo24() {
        boolean status = catHide.checkResult(1,1);
        int n = catHide.getN();
        assertTrue(status);
        assertEquals(24, n);
    }

    @Test
    @Order(3)
    void shouldIncreaseNTo144() {
        boolean status = catHide.checkResult(1,1);
        int n = catHide.getN();
        assertTrue(status);
        assertEquals(144, n);
    }
}