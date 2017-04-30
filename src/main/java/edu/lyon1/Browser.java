package edu.lyon1;

public class Browser {

  private final String userAgent;

  public Browser(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public String getNom() {
    if (userAgent.contains("Firefox")) {
      return "Firefox";
    } else if (userAgent.contains("Chrome")) {
      return "Chrome";
    } else if (userAgent.contains("AppleWebKit")) {
      return "Safari";
    } else if (userAgent.contains("MSIE")) {
      return "Internet Explorer";
    } else {
      return "inconnu";
    }
  }
}
