package com.company.pages;

import com.company.manager.GitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


public class GithubPage {
    GitManager gitManager = new GitManager();

    /**
     * Search repositiory in github
     *
     * @param
     * @throws IOException
     */
    public void searchRepository(WebDriver driver,String searchRepository,String propertyName) throws IOException {
        driver.findElement(By.xpath(gitManager.getReadIdentifier().getXPathRepository().getProperty(propertyName)))
                .sendKeys(searchRepository);
        driver.findElement(By.xpath(gitManager.getReadIdentifier().getXPathRepository().getProperty(propertyName)))
                .sendKeys(Keys.RETURN);
    }

    /**
     * Get repository results
     *
     * @return
     * @throws IOException
     */
    public List<WebElement> getRepositoryResult(WebDriver driver,String repoName) throws IOException {
        List<WebElement> repoNames = driver.findElements(By.xpath(gitManager.getReadIdentifier()
                .getXPathRepository().getProperty(repoName)));
        return repoNames;
    }
}
