import com.company.constant.Constants;
import com.company.manager.GitManager;
import com.company.pages.GithubPage;
import com.company.utils.Base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import com.company.dataProvider.*;

import java.util.List;


public class gitHubTest extends Base {
    static final Logger logger = LogManager.getLogger(gitHubTest.class.getName());
    GitManager gitManager = new GitManager();
    GithubPage githubPage = new GithubPage();
    WebDriver driver;

    @Test(dataProvider = "BrowserData", dataProviderClass = Browser.class, description = "Search and Validate git Repo")
    public void searchAndValidateGitRepo(String browser) throws Exception {
        DOMConfigurator.configure("log4j.xml");
        driver = gitManager.getBase().launchBrowser(browser);
        logger.info("searchAndValidateGitRepo started");
        String url = gitManager.getReadEnvDetails().getEnvDetails().getProperty("url");
        driver.get(url);
        githubPage.searchRepository(driver,"selenium","search");
        List<WebElement> repoNames=githubPage.getRepositoryResult(driver,"repoNames");
        ArrayList<String> result = new ArrayList<String>();
        for (WebElement repoName : repoNames) {
            result.add(repoName.getText());
        }
        Assert.assertEquals(true, result.contains(Constants.REPONAME), "Repository does not exist");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
