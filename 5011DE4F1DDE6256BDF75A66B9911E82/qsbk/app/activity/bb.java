package qsbk.app.activity;

import android.widget.Toast;
import com.baidu.kirin.KirinConfig;
import com.baidu.location.LocationClientOption;
import qsbk.app.QsbkApp;
import qsbk.app.R;
import qsbk.app.activity.base.MysBaseActivity;
import qsbk.app.loader.AsyncDataLoader;
import qsbk.app.utils.HttpUtils;

// compiled from: ManageMyContentsActivity.java
class bb implements Runnable {
    final /* synthetic */ ManageMyContentsActivity a;

    bb(ManageMyContentsActivity r1_ManageMyContentsActivity) {
        this.a = r1_ManageMyContentsActivity;
    }

    public void run() {
        if (!this.a.C) {
            this.a.l();
        }
        if (HttpUtils.netIsAvailable()) {
            this.a.y = true;
            this.a.t = 1;
            if (this.a.lastRefreshFirstPageTime == null) {
                new AsyncDataLoader(this.a.getOnAsyncLoadListener(MysBaseActivity.LOAD), "qsbk-AT-BGA-01").execute(new Void[0]);
            } else if (Long.valueOf(System.currentTimeMillis()).longValue() - this.a.lastRefreshFirstPageTime.longValue() > 60000) {
                new AsyncDataLoader(this.a.getOnAsyncLoadListener(MysBaseActivity.LOAD), "qsbk-AT-BGA-02").execute(new Void[0]);
            } else {
                this.a.b((int)KirinConfig.READ_TIME_OUT);
            }
        } else {
            this.a.b((int)LocationClientOption.MIN_SCAN_SPAN);
            Toast.makeText(QsbkApp.mContext, R.string.network_not_connected, 1).show();
        }
    }
}