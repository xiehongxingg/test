package com.yjhl.test;

import org.junit.Test;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

/***Created by mo
 *On 2017/10/31  ***15:55.
 ******/
public class ArangoDBTest {
     //连接和mongo差不多，本地地址
     ArangoDB arangoDB = new ArangoDB.Builder().host("127.0.0.1", 8529).user("root").password("root").build();
     //数据库
     ArangoDatabase db = arangoDB.db("AQLTest");
     //集合
     ArangoCollection coll =db.collection("test");
    @Test
    public void insertDocument() {
       BaseDocument document = new BaseDocument();
       document.addAttribute("id",01);
       document.addAttribute("name","Damo");
       document.addAttribute("tag","10");
       coll.insertDocument(document);
    }

}

