package org.funkntrash.potato.controllers; /**
 * Created by funkntrash on 16.05.16.
 */

import org.funkntrash.potato.services.PhotoServiceImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.springframework.ui.Model;


public class MainControllerTest {

    MainController mainController = new MainController();
    PhotoServiceImpl photoService;
    Model model;


    @BeforeTest
    public void Before(){

        photoService = mock(PhotoServiceImpl.class);
        model = mock(Model.class);

        mainController.setPhotoServiceImpl(photoService);

    }

    @Test
    public  void Test(){
        mainController.index(model);

        verify(photoService).listPhotos();

    }

}


