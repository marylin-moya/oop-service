/*
 *
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 *
 */

package com.jalasoft.oop.controller;

import com.jalasoft.oop.model.CompilerManager;
import com.jalasoft.oop.model.ICompiler;
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

@RestController @RequestMapping("/api/v1") public class CompilerController
{

    @Value("${file.sourcePath}") private String sourcePath;

    private static final Logger LOGGER = LogManager.getLogger();

    @PostMapping("/compile") public String execute(
    @RequestParam(value = "lang") String lang,
    @RequestParam(value = "version") String version,
    @RequestParam("file") MultipartFile file)
    {
        LOGGER.info("/compile rest method starting...");
        LOGGER.info("File: {}", file.getOriginalFilename());
        LOGGER.info("Language: {}", lang);
        LOGGER.info("version: {}", version);
        try
        {
            FileHelper.saveUploadFile(sourcePath, file);
        }
        catch (IOException e)
        {
            return "Error saving the file";
        }

        CompilerManager compilerManager = new CompilerManager();
        ICompiler compiler = compilerManager.getCompiler(lang, version);
        return compiler.compile(file.getOriginalFilename(), version);
    }
}
