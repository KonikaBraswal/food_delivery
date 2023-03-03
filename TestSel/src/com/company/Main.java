package com.company;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

   static WebDriver driver;
    public static void main(String[] args)throws Exception {

        // write your code here
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://127.0.0.1:5500/login.html");
        driver.manage().window().maximize();
        Main obj=new Main();
//      obj.TestLink();
        obj.TestLogin();
//        obj.TestAbout();
//        obj.TestService();
//        obj.TestContact();
//      driver.close();
//        obj.TestOffers();
        obj.TestInstagram();
//      obj.TestValidAddressField();
//      obj.TestCancelledAddress();
//      obj.TestEmptyAddressField();
//      obj.TestEmptyCart();
//      obj.TestAddToCart();
//      obj.TestCartRedirect();
//      obj.TestIncreasingCartItem();
//      obj.TestDecreasingCartItemNZ();
//      obj.TestDecreasingCartItemNZ2();
//      obj.TestDecrementToZ();
//      obj.TestHuntSouth();
//      obj.TestHuntChinese();
//      obj.TestHuntVeg();
//      obj.TestHuntPaneer();
//      obj.TestHuntChicken();
//      obj.TestHuntBiryani();

          driver.quit();

    }
    public void TestLink(){
        if(driver.getTitle() != null && driver.getTitle().contains("Login Page")){
            System.out.println("Web page is opened");
        }
        else{
            System.out.println("Web page could not open.");
        }
    }
    public void TestLogin()throws Exception {
        try {
            Thread.sleep(1000);
            driver.findElement(By.id("name")).sendKeys("Amisha123");
            driver.findElement(By.id("pass")).sendKeys("123ams");
            Thread.sleep(2000);
            driver.findElement(By.id("sub")).click();

            if (driver.getTitle().contains("Food Website")) {
                System.out.println("Login redirect test success");
            } else {
                System.out.println("Login redirect failed");
            }
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());

        }
    }
    public void TestEmptyCart() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                Thread.sleep(1000);
                driver.findElement(By.id("cart-plus")).click();
                Alert al= driver.switchTo().alert();
                if ( al.getText().equalsIgnoreCase("Currently no item in cart!")) {
                    System.out.println("Empty cart alert test success");
                    Thread.sleep(1000);
                    al.accept();
                } else {
                    System.out.println(" Empty cart alert test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestAbout() throws Exception {
                try {
                    Actions actions = new Actions(driver);
                    WebElement menuOption =  driver.findElement(By.linkText("About"));
                    actions.moveToElement(menuOption).perform();
                   driver.findElement(By.linkText("About")).click();

                   // driver.findElement(By.id("")).click();
                    if (driver.getTitle().contains("Who We Are")) {
                        System.out.println("About page test success");
                    } else {
                        System.out.println("About page test failed");
                    }
                    Thread.sleep(1000);
                    driver.navigate().back();
                } catch (final Exception e) {
                    System.out.println(e.getClass().toString());

                }
            }
    public void TestService() throws Exception {
        try {
            Actions actions = new Actions(driver);
            WebElement menuOption =  driver.findElement(By.linkText("Services"));
            actions.moveToElement(menuOption).perform();
            driver.findElement(By.linkText("Services")).click();
            // driver.findElement(By.id("")).click();
            if (driver.getTitle().contains("Terms of Service | Zomato")) {
                System.out.println("Services page test success");
            } else {
                System.out.println("Services page test failed");
            }
            Thread.sleep(1000);
            driver.navigate().back();
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());

        }
    }
    public void TestContact() throws Exception {
        try {
            Actions actions = new Actions(driver);
            WebElement menuOption =  driver.findElement(By.linkText("Contact"));
            actions.moveToElement(menuOption).perform();
            driver.findElement(By.linkText("Contact")).click();

            // driver.findElement(By.id("")).click();
            if (driver.getTitle().contains("Zomato Office ")) {
                System.out.println("Contact page test success");
            } else {
                System.out.println("Contact page test failed");
            }
            Thread.sleep(1000);
            driver.navigate().back();
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());

        }
    }
    public void TestOffers() throws Exception {
        try {
            Actions actions = new Actions(driver);
            WebElement menuOption =  driver.findElement(By.linkText("Offers"));
//            actions.moveToElement(menuOption).perform();
            actions.clickAndHold(menuOption);
            Thread.sleep(1000);
            actions.build().perform();
            driver.findElement(By.linkText("Offers")).click();

            // driver.findElement(By.id("")).click();
            if (driver.getTitle().contains("Zomato Coupons")) {
                System.out.println("Offers page test success");
            } else {
                System.out.println("Offers page test failed");
            }
            Thread.sleep(1000);
            driver.navigate().back();
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());

        }
    }
    public void TestInstagram() throws Exception {
        try {
            Actions actions = new Actions(driver);
            WebElement menuOption =  driver.findElement(By.linkText("Instagram"));
            Thread.sleep(1000);
            actions.clickAndHold(menuOption);
            Thread.sleep(1000);
            driver.findElement(By.linkText("Instagram")).click();

            // driver.findElement(By.id("")).click();
            if (driver.getTitle().contains("Instagram")) {
                System.out.println("Instagram page test success");
                driver.findElement(By.xpath("//input[contains(@aria-label, 'username')]")).sendKeys("88888");
//                driver.findElement(By.name("password")).sendKeys("*******");
//                driver.findElement(By.xpath("//div[text()='Log In']")).click();

            } else {
                System.out.println("About page test failed");
            }
            Thread.sleep(1000);
            driver.navigate().back();
        } catch (final Exception e) {
            System.out.println(e.getClass().toString());

        }
    }
    public void TestValidAddressField() throws Exception {
            try {
                 driver.findElement(By.id("add-address")).click();
            //    driver.findElement(By.id("")).sendKeys("");
               String ad="22, Baker Street";
                Alert al= driver.switchTo().alert();
                al.sendKeys(ad);
                al.accept();
                Thread.sleep(1000);

                if ( driver.findElement(By.id("add-address")).getText().equals(ad)) {
                    System.out.println("Valid Address test success");
                } else {
                    System.out.println("Valid Address test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestCancelledAddress() throws Exception {
                try {
                //    driver.findElement(By.id("")).sendKeys("");

                    driver.findElement(By.id("add-address")).click();
                    //    driver.findElement(By.id("")).sendKeys("");
                    String ad="22, Baker Street";
                    Alert al= driver.switchTo().alert();
                    al.sendKeys(ad);
                    Thread.sleep(1000);
                    al.dismiss();
                        System.out.println("Cancelled Address test success");
                } catch (final Exception e) {
                    System.out.println(e.getClass().toString());

                }
            }
    public void TestEmptyAddressField() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                driver.findElement(By.id("add-address")).click();
                //    driver.findElement(By.id("")).sendKeys("");
                String ad="";
                Alert al= driver.switchTo().alert();
                al.sendKeys(ad);
                Thread.sleep(2000);
                al.accept();

                    System.out.println("Empty address test success");
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestAddToCart() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                Thread.sleep(1000);
                driver.findElement(By.id("1")).click();
                Thread.sleep(1000);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                WebElement Element = driver.findElement(By.id("11"));
                // Scrolling down the page till the element is found
                jse.executeScript("arguments[0].scrollIntoView();", Element);
                Thread.sleep(1000);
                driver.findElement(By.id("11")).click();
                Thread.sleep(2000);
//                System.out.println(driver.findElement(By.id("cart-plus")).getText());
                if (driver.findElement(By.id("cart-plus")).getText().equals("2 Items")) {
                    System.out.println("Add to cart test success");
                } else {
                    System.out.println("Add to cart test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestCartRedirect() throws Exception {
                try {
                //    driver.findElement(By.id("")).sendKeys("");
                    driver.findElement(By.id("cart-plus")).click();
                    Thread.sleep(1000);
                   // driver.findElement(By.id("")).click();
                        driver.findElement(By.id("cart-title"));
                        System.out.println("Cart page test success");

                } catch (final NoSuchElementException e) {
                    System.out.println("Cart Page test failed");

                }
            }
    public void TestIncreasingCartItem() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/button[2]")).click();
                Thread.sleep(2000);
                if (driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/span")).getText().equals("2")
                && driver.findElement(By.id("total-price")).getText().equals("Total Price : $ 36")) {
                    System.out.println("Increase cart item quantity test success");
                } else {
                    System.out.println("Increase cart item test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestDecreasingCartItemNZ() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/button[1]")).click();
                Thread.sleep(1000);
                if (driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/span")).getText().equals("1")) {
                    System.out.println("Decrease cart item quantity test success");
                } else {
                    System.out.println("Decrease cart item quantity test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestDecreasingCartItemNZ2() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[2]/td[3]/button[1]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[2]/td[2]"));
                System.out.println("Decrement to remove cart item in multi item cart test failed");

            } catch (final NoSuchElementException e) {
                System.out.println("Decrement to remove cart item in multi item cart test passed");

            }
        }
    public void TestDecrementToZ() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");

                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/button[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"table-body\"]/tr[1]/td[3]/button[1]")).click();
                Alert al= driver.switchTo().alert();
                Thread.sleep(2000);
                if (al.getText().equalsIgnoreCase("Currently no item in cart!")) {
                    System.out.println("Emptied Cart on Decrement test success");
                } else {
                    System.out.println("Emptied Cart on Decrement test failed");
                }
            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntSouth() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[7]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[7]/a")).click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntChinese() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[6]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                menuOption.click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntVeg() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[5]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                menuOption.click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntPaneer() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[4]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                menuOption.click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntChicken() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[3]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                menuOption.click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
    public void TestHuntBiryani() throws Exception {
            try {
            //    driver.findElement(By.id("")).sendKeys("");
                Actions actions = new Actions(driver);
                WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"category-list\"]/div[2]/a"));
                actions.moveToElement(menuOption).perform();
                Thread.sleep(2000);
                menuOption.click();
                actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu\"]/div[1]/img"))).perform();
                Thread.sleep(1000);
                    System.out.println(" test success");

            } catch (final Exception e) {
                System.out.println(e.getClass().toString());

            }
        }
}
