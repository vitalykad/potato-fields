package org.funkntrash.potato.controllers;

import org.funkntrash.potato.services.PhotoService;
import org.funkntrash.potato.models.PhotosEntity;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Контроллер для главной страницы приложения.
 */
@Controller
public class MainController {

    @Autowired
    private PhotoService photoServiceImpl;

    @RequestMapping("/")
    public String index(Model model) {

        List<PhotosEntity> photos = photoServiceImpl.listPhotos();

        model.addAttribute("photos", photos);

        return "WEB-INF/jsp/index.jsp";
    }

    public void setPhotoServiceImpl(PhotoService photoServiceImpl) {
        this.photoServiceImpl = photoServiceImpl;
    }
}