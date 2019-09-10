package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 *  请求结果封装类
 */
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

    //查询结果
    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
       super(resultCode);
       this.queryResult = queryResult;
    }

}
