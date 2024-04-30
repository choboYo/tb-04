package com.ll.domain;

import com.ll.standard.until.Ut;

import java.util.HashMap;
import java.util.Map;

public class Rq {
private String cmd;
private String action;
private String queryString;
private Map<String, String> paramsMap;

public Rq(String cmd) {
        paramsMap = new HashMap<>();

        this.cmd = cmd;

        String[] cmdBits = cmd.split("\\?", 2);
        //     ↑ split : 특정 문자를 기준으로 나누어 배열에 저장 리턴합니다.
        action = cmdBits[0].trim();
        if(cmdBits.length == 1) {
            return;
        }
        queryString = cmdBits[1].trim();
            // ex) 삭제?id=2&achive=true\\
            // trim() 메서드는 앞과 뒤의 공백을 제거한 후 문자열의 복사본을 반환합니다.

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            // 결국 배열을 통해서 paramName = id, achive;
            // paramValue = (String)번호, true가 들어가게 되었다.
            paramsMap.put(paramName, paramValue);
        }
    }

protected String getAction() {
        return action;
    }

    public int getParamAsInt(String paramName, int defaultValue) {
        return Ut.str.parseInt(paramsMap.get(paramName), defaultValue);
    }
}