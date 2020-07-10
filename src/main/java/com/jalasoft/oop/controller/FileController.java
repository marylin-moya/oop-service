/*
 *
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jalasoft.
 *
 */

package com.jalasoft.oop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController @RequestMapping("/api")
public class FileController
{

    private static final Logger LOGGER = LogManager.getLogger();

    @PostMapping @RequestMapping("/file") public String uploadFile(
    @RequestParam("file") MultipartFile file,
    @RequestParam(value = "filename") String filename,
    @RequestParam(value = "extension") String extension)
    {
        LOGGER.info("UploadFile Method...");
        return "The file is: " + filename + " - " + extension + " - " + file.getOriginalFilename();
    }
}
