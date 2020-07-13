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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Process
{

    private static final Logger LOGGER = LogManager.getLogger();

    public abstract ProcessBuilder getProcessBuilder(String command);

    public String Execute(String command)
    {
        try
        {
            LOGGER.info("Starting the command execution...");
            ProcessBuilder builder = getProcessBuilder(command);
            builder.redirectErrorStream(true);

            LOGGER.info("Execute command: {}", command);
            java.lang.Process process = builder.start();
            process.waitFor();

            LOGGER.info("Reading output...");
            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder result = new StringBuilder();
            while (reader.ready())
            {
                LOGGER.info("-----");
                result.append((char) reader.read());
            }
            LOGGER.info(result.toString());
            return result.toString();
        }
        catch (IOException | InterruptedException ex)
        {
            return ex.getMessage();
        }
    }
}
