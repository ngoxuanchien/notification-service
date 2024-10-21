package com.hdbank.common.log.template;

import com.hdbank.common.annotation.Application;
import com.hdbank.common.log.utils.JsonUtil;
import lombok.RequiredArgsConstructor;

@Application
@RequiredArgsConstructor
public class LoggerTemplate {

    private final JsonUtil jsonUtil;

}
