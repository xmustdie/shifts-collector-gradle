package com.goodt.shiftscollectorgradle.client.request.param;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2018/2/11. 请求的参数
 * @author zhanghaishan
 * @version V1.0
 */
public class RequestParameter extends HashMap<String,Object> {

    /**
     * 封装构造
     */
    private RequestParameter(){

    }

    /**
     * 添加一个请求参数
     * @param key 参数名
     * @param obj 参数户的值
     * @return this
     */
    public RequestParameter addParameter(String key, Object obj){
        put(key,obj);
        return this;
    }

    /**
     * 添加一个请求参数
     * @param key 参数名
     * @param obj 参数户的值
     * @return RequestParameter
     */
    public RequestParameter addObjectParameter(String key, Object obj){
        if(obj instanceof RequestObjectParameter){
            put(key,obj);
        }else{
            put(key,new RequestObjectParameter(obj));
        }
        return this;
    }


    /**
     * 将Map内的值全部转为请求参数
     * @param map 需要转换的map
     * @return RequestParameter
     */
    public RequestParameter buildByMap(Map map){
        RequestParameter requestParameter = build();
        requestParameter.putAll(map);
        return requestParameter;
    }

    /**
     * build一个RequestParameter
     * @return RequestParameter
     */
    public static RequestParameter build(){
        return new RequestParameter();
    }

    /**
     * 直接转为可用的string
     * @return request string
     */
    @Override
    public String toString() {
        Set<String> keys = keySet();

        if(keys.size()==0){
            return "";
        }

        StringBuilder stringVal = new StringBuilder("(");

        char connect = ',';

        for(String key:keys){
            stringVal.append(key).append(":").append(packVal(get(key))).append(connect);
        }

        char last = stringVal.charAt(stringVal.length()-1);

        if(connect == last){
            stringVal = new StringBuilder(stringVal.substring(0, stringVal.length() - 1));
        }

        stringVal.append(")");

        return stringVal.toString();
    }

    /**
     *
     * @param val
     * @return
     */
    private String packVal(Object val){
        if(val==null){
            return "null";
        }
        if(val instanceof Integer
                || val instanceof Boolean
                || val instanceof Float
                || val instanceof Double){
            return String.valueOf(val);
        }

        if(val instanceof Enum){
            Enum enumVal = (Enum) val;
            return enumVal.name();
        }

        if(val instanceof RequestObjectParameter){
            return val.toString();
        }

        return String.valueOf(val);
    }
}
