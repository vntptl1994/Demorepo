package com.qa.pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Test1Page extends TestBase {
   public Test1Page(){
       PageFactory.initElements(driver,this);
   }
   public String verifytitle(){
       return driver.getTitle();
   }



}
