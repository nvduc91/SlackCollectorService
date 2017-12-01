/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.slack.collertor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homedirect.slack.collector.service.CollectorService;

/**
 *  Author : Nguyen Viet Duc
 *          Email:duc.nguyenviet@homedirect.com.vn
 * Dec 1, 2017
 */
@Service
public class CollectorServiceImpl extends CollectorServiceAbstract implements CollectorService {

  private Logger LOGGER;
  
  public CollectorServiceImpl() {
    super();
    LOGGER = LoggerFactory.getLogger(CollectorServiceImpl.class);
  }
  
  @Override
  public String postDirectToChannel(String channelUrl, String message) {
    ResponseEntity<String> entity = post(channelUrl, message);
    if (!entity.getStatusCode().is2xxSuccessful()) {
      LOGGER.error("\n ===========> Error when post to channel.\n");
      return null;
    }
    return entity.getBody();
  }

  
}
