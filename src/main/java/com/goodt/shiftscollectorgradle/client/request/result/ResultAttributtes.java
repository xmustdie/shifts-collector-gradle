package com.goodt.shiftscollectorgradle.client.request.result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2018/3/9. 需要返回的结果 return data names
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class ResultAttributtes {

    private String name;

    //是否包含子属性
    public List<ResultAttributtes> resultAttributtes = new ArrayList<>();

    public ResultAttributtes(String name) {
        this.name = name;
    }

    /**
     * 添加返回内容
     *
     * @param resultAttr result data names
     * @return ResultAttributtes
     */
    public ResultAttributtes addResultAttributes(String... resultAttr) {
        if (resultAttr != null && resultAttr.length > 0) {
            for (String str : resultAttr) {
                ResultAttributtes ra = new ResultAttributtes(str);
                resultAttributtes.add(ra);
            }
        }
        return this;
    }

    /**
     * 添加返回内容
     *
     * @param resultAttr result data names
     * @return ResultAttributtes
     */
    public ResultAttributtes addResultAttributes(ResultAttributtes... resultAttr) {
        if (resultAttr != null && resultAttr.length > 0) {
            Collections.addAll(resultAttributtes, resultAttr);
        }
        return this;
    }

    @Override
    public String toString() {
        if (resultAttributtes.size() == 0) {
            return name;
        }
        StringBuilder str = new StringBuilder(name + "{");
        for (ResultAttributtes ra : resultAttributtes) {
            str.append(" ").append(ra.toString());
        }
        str.append(" }");
        return str.toString();
    }
}
