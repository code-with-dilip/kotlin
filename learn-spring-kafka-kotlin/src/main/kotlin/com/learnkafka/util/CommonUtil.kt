package com.learnkafka.util

import com.learnkafka.service.CommonService

class CommonUtil(val commonService: CommonService) {

    fun getApplicationName(): String {

        return commonService.getApplicationName()
    }
}