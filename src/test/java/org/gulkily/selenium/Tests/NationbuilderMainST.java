package org.gulkily.selenium.Tests;

import com.lazerycode.selenium.ScreenshotListener;
import com.lazerycode.selenium.SeleniumBase;
import org.gulkily.selenium.SeleniumSnapshot;
import org.gulkily.selenium.SeleniumUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

@Listeners(ScreenshotListener.class)
public class NationbuilderMainST extends SeleniumBase {

    @Test
    public void shutterstockHomeTest() {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        List <Dimension> dimList = new LinkedList<Dimension>();

        List <String> urlList = new LinkedList<String>();

        dimList.add(new Dimension(1024, 768));
        dimList.add(new Dimension(1280, 1024));

        urlList.add("http://nationbuilder.com/revolution_in_scotland");

        for (String url : urlList) {
            for (Dimension d : dimList) {
                driver.manage().window().setSize(d);

                driver.get(url);

                SeleniumSnapshot.takePageSnapshot(driver, "NationbuilderMainST", url);

                List<String> brokenLinks = SeleniumUtils.findBrokenLinks(driver);
                List<String> brokenImages = SeleniumUtils.findBrokenImages(driver);

                System.out.println("Broken links: " + brokenLinks.size());
                System.out.println("Broken images: " + brokenImages.size());
            }

        }
    }
}