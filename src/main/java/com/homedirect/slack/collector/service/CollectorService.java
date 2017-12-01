/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.slack.collector.service;

/**
 *  Author : Nguyen Viet Duc
 *          Email:duc.nguyenviet@homedirect.com.vn
 * Dec 1, 2017
 */
public interface CollectorService {
  String postDirectToChannel(String channelUrl, String message);
}
