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

package com.jalasoft.oop.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.jalasoft.oop.utils.Constants.OS_NAME_PROPERTY;

public class JavaCompiler implements ICompiler
{

    private static final Logger LOGGER = LogManager.getLogger();
    //String javaLangPattern = "jdk%s.0_251";
    String javaPath = "D:\\OOP\\oop-service\\thirdParty\\java\\win\\jdk1.8.0_251\\bin\\";
    String sourcePath = "D:\\OOP\\oop-service\\src\\main\\resources\\sourcePath\\";

    @Override public String buildCommand(String filename, String version)
    {
        LOGGER.info("Building Java Command for {} file", filename);
        String command = String.format(
        "%sjavac %s%s && %sjava -cp %s %s",
        javaPath,
        sourcePath,
        filename,
        javaPath,
        sourcePath,
        filename.replaceAll("\\.[^.]*$", ""));
        LOGGER.info("Java Command: {}", command);
        return command;
    }

    @Override public String compile(String filename, String version)
    {
        LOGGER.info("Starting Compile process for {} file", filename);
        ProcessManager processManager = new ProcessManager();
        Process process = processManager.getProcess(System.getProperty(OS_NAME_PROPERTY));
        return process.Execute(buildCommand(filename, version));
    }
}
