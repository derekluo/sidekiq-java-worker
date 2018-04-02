package com.zouyyu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.validator.ValidateWith;

import java.net.URI;
import java.net.URL;

/**
 * @author YuZou
 * @date 31/03/2018
 */
public class UtilTest {

    @Test
    public void testURI(){
        URI uri = URI.create("xx:/sss?#");
        System.out.println(uri);
        Assert.assertNotNull(uri);
    }

    @Test
    public void testSpilt(){
        Assert.assertEquals(2, "/a".split("/").length);
        Assert.assertEquals("", "/a".split("/")[0]);
    }
}
