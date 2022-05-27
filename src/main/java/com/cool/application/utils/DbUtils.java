package com.cool.application.utils;

import com.cool.application.exception.db.ResourceClosingFailureException;
import com.cool.application.notifications.warnings.DbWarnings;

public class DbUtils {

    public static void close(AutoCloseable ac)  {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                throw new ResourceClosingFailureException(String.format(DbWarnings.FAILED_TO_CLOSE_RESOURCE, ac.getClass()));
            }
        }
    }

    public static String escapeForPstmt(String input) {
        if (input != null) {
            return input
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
        }
        return null;
    }

}