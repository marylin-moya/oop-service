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

import com.jalasoft.oop.utils.FileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController @RequestMapping("/api")
public class FileController
{
    @Value("${file.target-dir}")
    private String filePath;

    private static final Logger LOGGER = LogManager.getLogger();

    @PostMapping @RequestMapping("/file") public String uploadFile(
    @RequestParam("file") MultipartFile file,
    @RequestParam(value = "filename") String filename,
    @RequestParam(value = "extension") String extension)
    {
        LOGGER.info("UploadFile Method...");
        try
        {
            FileHelper.saveUploadFile(filePath, file);
        }
        catch (IOException e)
        {
            return "Error saving the file";
        }

        return "The file is: " + filename + " - " + extension + " - " + file.getOriginalFilename();
    }
}
