package com.selenium.designpatterns.factory;

import lombok.NonNull;

public abstract class GooglePage {

    /**
     * Launch the Google homepage
     * Search for a keyword
     * Get the count of search results
     */
    public abstract void launchSite();
    public abstract void search(@NonNull final String keyword);
    public abstract int getResultsCount();

}
