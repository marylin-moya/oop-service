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

public class PythonCompiler implements ICompiler
{

    private static final Logger LOGGER = LogManager.getLogger();

    @Override public String buildCommand(String filename, String version)
    {
        LOGGER.info("buildCommand not implemented for Python");
        return null;
    }

    @Override public String compile(String filename, String version)
    {
        LOGGER.info("compile not implemented for Python");
        return null;
    }
}
