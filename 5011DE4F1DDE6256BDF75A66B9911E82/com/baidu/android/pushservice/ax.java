package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.PushManager;

// compiled from: SourceFile
class ax implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;

    ax(Context r1_Context, String r2_String) {
        this.a = r1_Context;
        this.b = r2_String;
    }

    public void run() {
        PushManager.setBduss(this.a, this.b);
    }
}