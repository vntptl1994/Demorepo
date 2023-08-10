package com.qa.tests;

import com.qa.Base.TestBase;
import com.qa.pages.Test1Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1PageTest extends TestBase {
    Test1Page test1Page;
    public Test1PageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
      init();
      test1Page=new Test1Page();
    }
    @Test
    public void gettitle(){
        test1Page.verifytitle();
        Assert.assertEquals("Google",driver.getTitle());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
