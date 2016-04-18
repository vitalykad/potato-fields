package org.funkntrash.potato.controllers;

import org.funkntrash.potato.services.PhotoServiceImpl;
import org.funkntrash.potato.models.PhotosEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Контроллер для главной страницы приложения.
 */
@Controller
public class MainController {

    private int visitorCount = 0;

    @RequestMapping("/index.html")
    public String index(Model model) {

        List<PhotosEntity> photos = new PhotoServiceImpl().listPhotos();

        model.addAttribute("photos", photos);

        return "WEB-INF/jsp/index.jsp";
    }

}