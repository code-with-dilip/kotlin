package com.learnkafka.util

import com.learnkafka.service.CommonService
import spock.lang.Specification

class CommonUtilSpec extends Specification{

    CommonService commonServiceMock = Mock()
    CommonUtil commonUtil = new CommonUtil(commonServiceMock)

    def "getApplicationName"(){

        given:
        String name = "LearnKotlinKafka"

        when:
        String response = commonUtil.getApplicationName()

        then:
        1 * commonServiceMock.getApplicationName() >> name
        response==name


    }
}
