package com.latihan.example.hitapi;

/**
 * Created by Alvin on 28/06/2015.
 */
public class ResObject {
    private String current_user_url;
    private String current_user_authorizations_html_url;
    private String authorizations_url;
    private String code_search_url;
    private String emails_url;
    private String emojis_url;

    public String getCurrent_user_url() {
        return current_user_url;
    }

    public void setCurrent_user_url(String current_user_url) {
        this.current_user_url = current_user_url;
    }

    public String getCurrent_user_authorizations_html_url() {
        return current_user_authorizations_html_url;
    }

    public void setCurrent_user_authorizations_html_url(String current_user_authorizations_html_url) {
        this.current_user_authorizations_html_url = current_user_authorizations_html_url;
    }

    public String getAuthorizations_url() {
        return authorizations_url;
    }

    public void setAuthorizations_url(String authorizations_url) {
        this.authorizations_url = authorizations_url;
    }

    public String getCode_search_url() {
        return code_search_url;
    }

    public void setCode_search_url(String code_search_url) {
        this.code_search_url = code_search_url;
    }

    public String getEmails_url() {
        return emails_url;
    }

    public void setEmails_url(String emails_url) {
        this.emails_url = emails_url;
    }

    public String getEmojis_url() {
        return emojis_url;
    }

    public void setEmojis_url(String emojis_url) {
        this.emojis_url = emojis_url;
    }
}
