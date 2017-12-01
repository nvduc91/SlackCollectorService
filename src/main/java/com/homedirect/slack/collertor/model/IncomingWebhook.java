/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.slack.collertor.model;

/**
 *  Author : Nguyen Viet Duc
 *          Email:duc.nguyenviet@homedirect.com.vn
 * Dec 1, 2017
 */
public class IncomingWebhook {

  public IncomingWebhook(String text) {
    this.text = text;
  }
  
  private String text;

  public String getText() { return text; }
  public void setText(String text) { this.text = text; }
  
}
