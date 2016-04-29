package com.example.junitsimple;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by evin on 4/28/16.
 */
public class RetrofitUnitTest {
    @Test
    public void repositories_checkNumbers() throws Exception {
        assertNotNull(RetrofitMagic.getRepositories("Evin1-"));
    }
}
