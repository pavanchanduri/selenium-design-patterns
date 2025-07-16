package com.udemy.seleniumdesign.test.template;

import com.udemy.seleniumdesign.template.AmazonShopping;
import com.udemy.seleniumdesign.template.EBayShopping;
import com.udemy.seleniumdesign.template.ShoppingTemplate;
import com.udemy.seleniumdesign.test.BaseTest;
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
