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

import com.jalasoft.oop.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompilerManager
{
    private static final Logger LOGGER = LogManager.getLogger();

    public ICompiler getCompiler(String language, String version)
    {
        if (language == null)
        {
            return null;
        }
        if (language.toLowerCase().contains(Constants.LANGUAGE.JAVA.toName()))
        {
            LOGGER.info("Return '{}' Compiler object.", Constants.LANGUAGE.JAVA.toName());
            return new JavaCompiler();
        }
        else if (language.toLowerCase().contains(Constants.LANGUAGE.PYTHON.toName()))
        {
            LOGGER.info("Return '{}' Compiler object.", Constants.LANGUAGE.PYTHON.toName());
            return new PythonCompiler();
        }
        return null;
    }
}
