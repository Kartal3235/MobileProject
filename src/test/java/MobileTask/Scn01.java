package MobileTask;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;


public class Scn01 extends BaseApp {

    AndroidDriver<MobileElement>driver=getAndroidDriver();

    public Scn01() throws MalformedURLException {
    }

    @Test
    public void test01() throws MalformedURLException, InterruptedException {

            //Uygulama yüklenir ana sayfa valid edilir
            MobileElement homepage= driver.findElementById("android:id/action_bar");
            Assert.assertTrue(homepage.isDisplayed());
            Thread.sleep(5000);

           //App menusune tıklanır
            MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
            appMenu.click();
            Thread.sleep(5000);

            //Action bar  ve Acti Bar Tabs tıklanır,Action bar tabs de olduğun kontrol edilir
            MobileElement actinBar=driver.findElementByXPath("//android.widget.TextView[@text='Action Bar']");
            actinBar.click();
            Thread.sleep(5000);
            MobileElement actinBarTab=driver.findElementByXPath("(//android.widget.TextView[@text='Action Bar Tabs'])[1]");
            actinBarTab.click();
            Thread.sleep(5000);
            //Toggle Tab mode, Add new Tab ekleme
                MobileElement toggleTab=driver.findElementById("com.hmh.api:id/btn_toggle_tabs");
                toggleTab.click();
                Thread.sleep(5000);
                MobileElement addNewTab=driver.findElementById("com.hmh.api:id/btn_add_tab");
                for (int i = 0; i <3 ; i++) {

                    addNewTab.click();
                    Thread.sleep(1000);
                }
            // Add tabs  remove last tab ile silme
            MobileElement removeLastTab=driver.findElementById("com.hmh.api:id/btn_remove_tab");
            for (int i = 0; i <3 ; i++) {

                removeLastTab.click();
                Thread.sleep(1000);
            }
            Thread.sleep(5000);
            // Başlığın boş olduğunu valid
            MobileElement header=driver.findElementByXPath("(//android.widget.LinearLayout)[1]");//İlk link tıklandı
            String headertext=header.getText();
            Assert.assertTrue(headertext.isEmpty());
            //MobileElement tab0=driver.findElementByXPath("//android.widget.TextView[@text='TAB 0']");
            //String tab0Text=tab0.getText();
            //Assert.assertFalse(tab0.isDisplayed());//silinip silinmediği kontrol ediliyor

    }
         @Test
        public void test02() throws InterruptedException {

             //Uygulama yüklenir ana sayfa valid edilir
             MobileElement homepage= driver.findElementById("android:id/action_bar");
             Assert.assertTrue(homepage.isDisplayed());
             Thread.sleep(5000);

             //App menusune tıklanır
             MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
             appMenu.click();
             Thread.sleep(5000);

            // Activitiy menu tıklarız
             MobileElement activity=driver.findElementByXPath("//android.widget.TextView[@text='Activity']");
             activity.click();
             Thread.sleep(5000);

           // Custom title ilk link tıklandı;
             MobileElement customTitle=driver.findElementByXPath("(//android.widget.TextView[@text='Custom Title'])[1]");
             customTitle.click();
             Thread.sleep(5000);

           //Left ve right textbox yazı yazılarak navigate yapılır.
           MobileElement leftBox=driver.findElementById("com.hmh.api:id/left_text_edit");
           MobileElement rightBox=driver.findElementById("com.hmh.api:id/right_text_edit");
           MobileElement leftButon=driver.findElementById("com.hmh.api:id/left_text_button");
           MobileElement rightButon=driver.findElementById("com.hmh.api:id/right_text_button");

           leftBox.click();
           leftBox.clear();
           Thread.sleep(5000);
           Assert.assertTrue(leftBox.getText().isEmpty());//Left box Boş olup olmadığını valide ediyoruyz
             Thread.sleep(5000);
             leftBox.sendKeys("LEFT");
             Thread.sleep(5000);
             leftButon.click();
             Thread.sleep(5000);
             rightBox.click();
           rightBox.clear();
             Thread.sleep(5000);
           Assert.assertTrue(rightBox.getText().isEmpty());//Right Box Boş olup olmadığını valide ediyoruyz
             Thread.sleep(5000);
          rightBox.sendKeys("RİGHT");
          Thread.sleep(5000);
           rightButon.click();
             Thread.sleep(5000);
           MobileElement leftHeader=driver.findElementById("com.hmh.api:id/left_text");
           MobileElement rightHeader=driver.findElementById("com.hmh.api:id/right_text");
           Assert.assertTrue(leftHeader.isDisplayed());
           Thread.sleep(5000);
           Assert.assertTrue(rightHeader.isDisplayed());
           Thread.sleep(5000);
    }

    @Test
    public void test03() throws InterruptedException {

        //Uygulama yüklenir ana sayfa valid edilir
        MobileElement homepage= driver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);

        //App menusune tıklanır
        MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
        appMenu.click();
        Thread.sleep(5000);
        //Alert menu tıklanır
        MobileElement alertMenu=driver.findElementByXPath("(//android.widget.TextView[@text='Alert Dialogs'])[1]");//ilk menu tıklanır
        alertMenu.click();
        Thread.sleep(5000);
        MobileElement listDialog=driver.findElementById("com.hmh.api:id/select_button");
        listDialog.click();
        Thread.sleep(5000);
        //Alert Title'da olduğumuzu valid edilir
        MobileElement alertTitle= driver.findElementById("android:id/alertTitle");
        Assert.assertTrue(alertTitle.isDisplayed());
        Thread.sleep(5000);
        //Alert de seçim yaptıktan sonra,expected ile actual result karşılaştırılır
        MobileElement commandOne=driver.findElementByXPath("//android.widget.TextView[@text='Command one']");
        MobileElement commandTwo=driver.findElementByXPath("//android.widget.TextView[@text='Command two']");
        MobileElement commandThree=driver.findElementByXPath("//android.widget.TextView[@text='Command three']");
        //Command One select is made alert message karşılaştır
        commandOne.click();
        Thread.sleep(5000);
        MobileElement commandOneAlert=driver.findElementById("android:id/message");
        Assert.assertTrue(commandOneAlert.getText().contains("Command one"));
        Thread.sleep(5000);
    }

    @Test
    public void test04() throws InterruptedException {

        //Uygulama yüklenir ana sayfa valid edilir
        MobileElement homepage= driver.findElementById("android:id/action_bar");
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(5000);

        //App menusune tıklanır
        MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
        appMenu.click();
        Thread.sleep(5000);
        //Device Admin menusu tıklanır
        MobileElement deviceAdmin=driver.findElementByXPath("(//android.widget.TextView[@text='Device Admin'])[1]");
        deviceAdmin.click();
        Thread.sleep(5000);
        //General Menu ve valid ederiz
        MobileElement generalMenu=driver.findElementByXPath("(//android.widget.LinearLayout)[4]");
        MobileElement generalTitle=driver.findElementById("android:id/action_bar");
        generalMenu.click();
        Thread.sleep(5000);
        Assert.assertTrue(generalTitle.isDisplayed());
        Thread.sleep(5000);
        //Enable Admin etkinleştirilir
        MobileElement enableAdmın=driver.findElementByXPath("(//android.widget.TextView[@text='Enable admin'])[2]");
        enableAdmın.click();
        Thread.sleep(8000);
        MobileElement deviceAdminTitle=driver.findElementById("com.android.settings:id/collapsing_toolbar");
        Assert.assertTrue(deviceAdminTitle.isDisplayed());
        Thread.sleep(5000);
        //Bu şekilde yaptık, çünkü tıklayacağımız element tarayıcının göremeyeceği bir yerde dimenson ve TouchAction kullanarak ekranı aşağı kaydıracağız
        List<MobileElement>mobileList;

        do {
            mobileList=driver.findElementsByXPath("//android.widget.TextView");
            Dimension dimension=driver.manage().window().getSize();

            int start_x= (int) (dimension.width*0.5);
            int start_y= (int) (dimension.height*0.8);

            int end_x= (int) (dimension.width*0.5);
            int end_y= (int) (dimension.height*0.2);

            TouchAction touchAction=new TouchAction(driver);
            touchAction.press(PointOption.point(start_x,start_y)).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(end_x,end_y)).
                    release().perform();

        }while(mobileList.size()==0);
        Thread.sleep(2000);
        MobileElement activateDeviceAdmin=driver.findElementById("com.android.settings:id/action_button");
        activateDeviceAdmin.click();
        Thread.sleep(5000);
        MobileElement enableAdminChecked=driver.findElementByXPath("(//android.widget.CheckBox)[1]");
        //enableAdminChecked.getAttribute("checked");
        Assert.assertEquals(enableAdminChecked.getAttribute("checked"),true);
       Thread.sleep(5000);
    }
        @Test
    public void test05() throws InterruptedException, MalformedURLException {

            //Uygulama yüklenir ana sayfa valid edilir
            MobileElement homepage= driver.findElementById("android:id/action_bar");
            Assert.assertTrue(homepage.isDisplayed());
            Thread.sleep(5000);

            //App menusune tıklanır
            MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
            appMenu.click();
            Thread.sleep(5000);
            //Fragment tıklarız
            MobileElement fragmentMenu=driver.findElementByXPath("//android.widget.TextView[@text='Fragment']");
            fragmentMenu.click();
            Thread.sleep(5000);
            //Context Menu 1 seçilir
            MobileElement contextMenu1=driver.findElementByXPath("(//android.widget.TextView[@text='Context Menu'])[2]");
            contextMenu1.click();
            Thread.sleep(5000);
            //Context Menu olduğu valid edilir
           // MobileElement title=driver.findElementByXPath("//android.widget.TextView[@text='App/Fragment/Context Menu']");
           // String titleText=title.getText();
           // Assert.assertTrue(titleText.contains("Context Menu"));
           // Thread.sleep(5000);

            //LongPress buton uzun basılıp--->TouchAction classını kullanırız,web elementde action classını kullandığımız gibi
            MobileElement longPress1=driver.findElementById("com.touchboarder.android.api.demos:id/long_press");
            TouchAction touchAction=new TouchAction(driver);
            touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longPress1))).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();
            //Menu A and  Menu B tıklanıp seçildiği valid edilir.
            /*
            Burda Menu A ve Menu B tıkladıktan sonra çıkan Toast messages,UIAutomation2 toast mesajları bulamıyor.
            */
            MobileElement menuA=driver.findElementByXPath("//android.widget.TextView[@text='Menu A']");
            menuA.click();
            Thread.sleep(8000);

            WebDriverWait waitForToast = new WebDriverWait(driver,3);
            waitForToast.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
            String toastMessageA=driver.findElementByClassName("android.widget.Toast").getText();
            Assert.assertTrue(toastMessageA.contains("Item 1a was chosen"));
            Thread.sleep(5000);

            touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(longPress1))).
                    waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform();
            MobileElement menuB=driver.findElementByXPath("//android.widget.TextView[@text='Menu B']");
            menuB.click();
            Thread.sleep(5000);
            String toastMessageB=driver.findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
            Assert.assertTrue(toastMessageB.contains("Item 1a was chosen"));
            Thread.sleep(5000);
        }

        @Test
    public void test06() throws InterruptedException {
            //Uygulama yüklenir ana sayfa valid edilir
            MobileElement homepage= driver.findElementById("android:id/action_bar");
            Assert.assertTrue(homepage.isDisplayed());
            Thread.sleep(5000);

            //App menusune tıklanır
            MobileElement appMenu=driver.findElementByXPath("//android.widget.TextView[@text='App']");
            appMenu.click();
            Thread.sleep(5000);
            //Fragment tıklarız
            MobileElement fragmentMenu=driver.findElementByXPath("//android.widget.TextView[@text='Fragment']");
            fragmentMenu.click();
            Thread.sleep(5000);
            //Hide and Show 1.link tıklanır
            MobileElement hideShowMenu=driver.findElementByXPath("(//android.widget.TextView[@text='Hide and Show'])[1]");
            hideShowMenu.click();
            Thread.sleep(5000);
            //Hide and Show sayfasında olduğu valid edilir
            MobileElement hideshowTitle=driver.findElementByXPath("//android.widget.TextView[@text='App/Fragment/Hide and Show']");
            String hideshowText=hideshowTitle.getText();
            Assert.assertTrue(hideshowText.contains("Hide and Show"));
            Thread.sleep(5000);
            //two Hide buton and two textbox valid
            List<MobileElement>mobileListButon=driver.findElementsByXPath("//android.widget.Button");
            Assert.assertEquals(2,mobileListButon.size());
            Thread.sleep(5000);

            List<MobileElement>mobileListTextBox=driver.findElementsByXPath("//android.widget.EditText");
            Assert.assertEquals(2,mobileListTextBox.size());
            Thread.sleep(5000);
            //Textboxlar  hide olduğunu ,hide butonun show olduğu kontrol edilir
            MobileElement textBox1=driver.findElementByXPath("(//android.widget.EditText[@text='Initial text.'])[1]");
            MobileElement hideBtn1=driver.findElementById("com.hmh.api:id/frag1hide");
            hideBtn1.click();
            Thread.sleep(10000);
            MobileElement textBox2=driver.findElementByXPath("(//android.widget.EditText[@text='Initial text.'])[2]");
            Thread.sleep(5000);
            MobileElement hideBtn2=driver.findElementById("com.hmh.api:id/frag2hide");
            hideBtn2.click();
            Thread.sleep(5000);

            List<MobileElement>mblistText=driver.findElementsByXPath("//android.widget.LinearLayout");
            Assert.assertTrue(mblistText.contains(""));
            Thread.sleep(5000);
            Assert.assertTrue(mblistText.contains("appium2"));
            Thread.sleep(5000);

            //Show butonuna basılarak textin geri geldiği kontrol edilir.
            MobileElement showBtn1=driver.findElementById("com.hmh.api:id/frag1hide");
            showBtn1.click();
            Thread.sleep(5000);
        }

}
