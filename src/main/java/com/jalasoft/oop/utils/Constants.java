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

package com.jalasoft.oop.utils;

public class Constants
{

    public static enum OS
    {
        WINDOWS("windows"), LINUX("linux");

        public String name;

        OS(String name)
        {
            this.name = name;
        }

        public String toName()
        {
            return name;
        }
    }

    public static enum LANGUAGE
    {
        JAVA("java"), PYTHON("python");

        public String name;

        LANGUAGE(String name)
        {
            this.name = name;
        }

        public String toName()
        {
            return name;
        }
    }

    public static final String OS_NAME_PROPERTY = "os.name";


    public static enum LANGUAGES {
        ENGLISH("english", "eng"),
        FRENCH("french", "fra"),
        URDU("urdu", "urd"),
        SPANISH("spanish", "spa");

        private String name;
        private String suffix;

        LANGUAGES(String name, String suffix) {
            this.name = name;
            this.suffix = suffix;
        }

        public String toName() {
            return name;
        }

        public String toSuffix() {
            return suffix;
        }

        /**
         * Method to get the LANGUAGES object given the Language name
         *
         * @param name of Language
         * @return LANGUAGE instance
         */
        public static LANGUAGES toLanguages(String name) {
            for (LANGUAGES language : values()) {
                if (language.name.equals(name.toLowerCase())) {
                    return language;
                }
            }
            return null;
        }
    }
}
