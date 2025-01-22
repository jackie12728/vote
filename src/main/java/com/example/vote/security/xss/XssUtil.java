package com.example.vote.security.xss;

import org.apache.commons.text.StringEscapeUtils;

public class XssUtil {

	public static String cleanXSS(String value) {
        if (value == null) {
            return null;
        }
        return StringEscapeUtils.escapeHtml4(value);
    }
}
