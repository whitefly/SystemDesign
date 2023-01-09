package com.whitefly.sd.common.web;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用Controller
 */
public class SdAbstractController {

    @Autowired
    protected HttpServletRequest httpServletRequest;

    @Autowired
    protected HttpServletResponse httpServletResponse;
}
