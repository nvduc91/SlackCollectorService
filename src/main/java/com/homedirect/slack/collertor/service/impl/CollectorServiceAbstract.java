/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.slack.collertor.service.impl;

import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.homedirect.slack.collertor.model.IncomingWebhook;

/**
 *  Author : Nguyen Viet Duc
 *          Email:duc.nguyenviet@homedirect.com.vn
 * Dec 1, 2017
 */

public class CollectorServiceAbstract {
  private Logger LOGGER;
  private final RestTemplate rest;
  
  public CollectorServiceAbstract() {
    LOGGER = LoggerFactory.getLogger(CollectorServiceAbstract.class);
    
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setDefaultMaxPerRoute(5000);
    connectionManager.setMaxTotal(10000);

    HttpClientBuilder clientBuilder = HttpClients.custom().setConnectionManager(connectionManager)
        .setRetryHandler(new DefaultHttpRequestRetryHandler(5, true));

    rest = new RestTemplate(new HttpComponentsClientHttpRequestFactory(clientBuilder.build()));
  }
  
  protected ResponseEntity<String> post(String channelUrl, String message) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type", "application/json");
    
    LOGGER.info("\n ===========> Call url: {}", channelUrl);
    ResponseEntity<String> entity = rest.exchange(channelUrl, HttpMethod.POST, 
        new HttpEntity<IncomingWebhook>(new IncomingWebhook(message), headers), String.class);
    LOGGER.info("\n ===========> Response Http Code: {}, Response Data: {}", entity.getStatusCodeValue(), entity.getBody());
    
    return entity;
  }
}
