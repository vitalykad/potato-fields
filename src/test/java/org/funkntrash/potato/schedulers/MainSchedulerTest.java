package org.funkntrash.potato.schedulers;

import org.funkntrash.potato.controllers.MainController;
import org.funkntrash.potato.services.PhotoServiceImplMock;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.springframework.ui.Model;

import static org.testng.Assert.assertEquals;


/**
 * Created by funkntrash on 22.05.16.
 */


public class MainSchedulerTest {

    public MainScheduler mainScheduler;

    @BeforeTest
    public void Before(){

        mainScheduler.setPhotoServiceImpl(new PhotoServiceImplMock());

    }

    @Test
    public void Test(){
        mainScheduler.updateDbFromNasaApi();

    }
}


