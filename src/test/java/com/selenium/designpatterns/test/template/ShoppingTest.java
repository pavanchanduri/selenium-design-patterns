package com.selenium.designpatterns.test.template;

import com.selenium.designpatterns.template.AmazonShopping;
import com.selenium.designpatterns.template.EBayShopping;
import com.selenium.designpatterns.template.ShoppingTemplate;
import com.selenium.designpatterns.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lombok.NonNull;

public class ShoppingTest extends BaseTest {

    /**
     * Test the shopping functionality of different platforms.
     * @param shoppingTemplate
     */
    @Test(dataProvider = "getData")
    public void shoppingTest(@NonNull final ShoppingTemplate shoppingTemplate){
        shoppingTemplate.shop();
    }

    /**
     * Data provider for shoppingTest.
     * @return array of ShoppingTemplate
     */
    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new AmazonShopping(driver, "samsung 4k"),
                new EBayShopping(driver, "samsung 4k")
        };
    }
}
