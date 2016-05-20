package com.ltkj.utils;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test1() {
        for (int i = 0; i < 10; i++) {
            //获取当前i的值
            int selector = i;
            //打log查看当前i的值（此步多余，实际开发请忽略）
            MyLog.e("for当前的i的值：",i+"");
            //调用方法
//            stepNext(i);
        }
    }
}