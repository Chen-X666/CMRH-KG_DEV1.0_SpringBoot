package com.canton.service.impl;

import com.canton.dao.util.PrefixUtil;
import com.canton.service.EventReminiscence;
import org.springframework.stereotype.Service;

/**
 * @Auther ChenX
 * @Date 2020.4.15
 **/
@Service
public class EventReminiscenceServiceImpl extends BaseService implements EventReminiscence{
    PrefixUtil prefix = new PrefixUtil();

    @Override
    public String getAllEvent() {
        return null;
    }

    @Override
    public String getEventDetail() {
        return null;
    }
}

