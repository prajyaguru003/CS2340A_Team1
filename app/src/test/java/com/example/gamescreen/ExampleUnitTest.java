package com.example.gamescreen;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExampleUnitTest {

    @Test
    public void testConfigScreenSetHp() {
        ConfigScreen.setHp(75);
        assertEquals(75, ConfigScreen.gethp());
    }

}