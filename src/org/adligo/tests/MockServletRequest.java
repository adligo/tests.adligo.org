package org.adligo.tests;

import javax.servlet.http.Cookie;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import javax.servlet.ServletInputStream;
import java.util.Locale;
import java.util.Hashtable;
import java.io.BufferedReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */
import java.util.Map;

public class MockServletRequest implements HttpServletRequest {
  private Hashtable htParameters = new Hashtable();

  public MockServletRequest() {
  }
  public String getAuthType() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getAuthType() not yet implemented.");
  }
  public Cookie[] getCookies() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getCookies() not yet implemented.");
  }
  public long getDateHeader(String name) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getDateHeader() not yet implemented.");
  }
  public String getHeader(String name) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getHeader() not yet implemented.");
  }
  public Enumeration getHeaders(String name) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getHeaders() not yet implemented.");
  }
  public Enumeration getHeaderNames() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getHeaderNames() not yet implemented.");
  }
  public int getIntHeader(String name) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getIntHeader() not yet implemented.");
  }
  public String getMethod() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getMethod() not yet implemented.");
  }
  public String getPathInfo() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getPathInfo() not yet implemented.");
  }
  public String getPathTranslated() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getPathTranslated() not yet implemented.");
  }
  public String getContextPath() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getContextPath() not yet implemented.");
  }
  public String getQueryString() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getQueryString() not yet implemented.");
  }
  public String getRemoteUser() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRemoteUser() not yet implemented.");
  }
  public boolean isUserInRole(String role) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method isUserInRole() not yet implemented.");
  }
  public Principal getUserPrincipal() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getUserPrincipal() not yet implemented.");
  }
  public String getRequestedSessionId() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRequestedSessionId() not yet implemented.");
  }
  public String getRequestURI() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRequestURI() not yet implemented.");
  }
  public String getServletPath() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getServletPath() not yet implemented.");
  }
  public HttpSession getSession(boolean create) {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getSession() not yet implemented.");
  }
  public HttpSession getSession() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getSession() not yet implemented.");
  }
  public boolean isRequestedSessionIdValid() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method isRequestedSessionIdValid() not yet implemented.");
  }
  public boolean isRequestedSessionIdFromCookie() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method isRequestedSessionIdFromCookie() not yet implemented.");
  }
  public boolean isRequestedSessionIdFromURL() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method isRequestedSessionIdFromURL() not yet implemented.");
  }
  public boolean isRequestedSessionIdFromUrl() {
    /**@todo: Implement this javax.servlet.http.HttpServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method isRequestedSessionIdFromUrl() not yet implemented.");
  }
  public Object getAttribute(String name) {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getAttribute() not yet implemented.");
  }
  public Enumeration getAttributeNames() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getAttributeNames() not yet implemented.");
  }
  public String getCharacterEncoding() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getCharacterEncoding() not yet implemented.");
  }
  public int getContentLength() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getContentLength() not yet implemented.");
  }
  public String getContentType() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getContentType() not yet implemented.");
  }
  public ServletInputStream getInputStream() throws IOException {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getInputStream() not yet implemented.");
  }
  public String getParameter(String name) {
    return (String) htParameters.get(name);
  }
  public Enumeration getParameterNames() {
    return htParameters.keys();
  }
  public String[] getParameterValues(String name) {
    return (String [] ) htParameters.get(name);
  }
  public String getProtocol() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getProtocol() not yet implemented.");
  }
  public String getScheme() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getScheme() not yet implemented.");
  }
  public String getServerName() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getServerName() not yet implemented.");
  }
  public int getServerPort() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getServerPort() not yet implemented.");
  }
  public BufferedReader getReader() throws IOException {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getReader() not yet implemented.");
  }
  public String getRemoteAddr() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRemoteAddr() not yet implemented.");
  }
  public String getRemoteHost() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRemoteHost() not yet implemented.");
  }
  public void setAttribute(String name, Object o) {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method setAttribute() not yet implemented.");
  }
  public void removeAttribute(String name) {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method removeAttribute() not yet implemented.");
  }
  public Locale getLocale() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getLocale() not yet implemented.");
  }
  public Enumeration getLocales() {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getLocales() not yet implemented.");
  }
  public boolean isSecure() { return false; }
  public RequestDispatcher getRequestDispatcher(String path) {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRequestDispatcher() not yet implemented.");
  }
  public String getRealPath(String path) {
    /**@todo: Implement this javax.servlet.ServletRequest method*/
    throw new java.lang.UnsupportedOperationException("Method getRealPath() not yet implemented.");
  }

  public void setParameter(String s, String s1) {
    htParameters.put(s, s1);
  }

  public void setParameterValues(String s, String [] sa) {
    htParameters.put(s, sa);
  }
  public StringBuffer getRequestURL() { return null; }
  public Map getParameterMap() { return null; }
  public void setCharacterEncoding(String s) {}
}