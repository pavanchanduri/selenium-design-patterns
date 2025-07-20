package com.selenium.designpatterns.factory;

import org.openqa.selenium.WebDriver;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Factory to create GooglePage objects based on language code.
 */
public class GoogleFactory {

    // Map language codes to their corresponding GooglePage constructors
    private static final Map<String, Function<WebDriver, GooglePage>> LANGUAGE_TO_PAGE = new HashMap<>();

    static {
        LANGUAGE_TO_PAGE.put("ENG",(d) -> new GoogleEnglish(d));
        LANGUAGE_TO_PAGE.put("FR", (d) -> new GoogleFrench(d));
        LANGUAGE_TO_PAGE.put("SA", (d) -> new GoogleArabic(d));
        LANGUAGE_TO_PAGE.put("ES", (d) -> new GoogleES(d));
    }

    /**
     * Returns a GooglePage for the given language code.
     * @param language Language code ("ENG", "FR", "SA", "ES")
     * @param driver Selenium WebDriver
     * @return GooglePage for the specified language
     * @throws IllegalArgumentException if the language code is not supported
     */
    public static GooglePage get(@NonNull final String language, @NonNull final WebDriver driver) {
        Function<WebDriver, GooglePage> pageCreator = LANGUAGE_TO_PAGE.get(language);
        if (pageCreator == null) {
            throw new IllegalArgumentException("Unsupported language code: " + language);
        }
        return pageCreator.apply(driver); // Create and return the GooglePage instance
    }
}