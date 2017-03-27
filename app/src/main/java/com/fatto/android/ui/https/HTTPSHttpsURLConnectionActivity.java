package com.fatto.android.ui.https;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;
import com.fatto.android.utils.HttpsUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TODO HttpsUrlConnection实现HTTPS
 *
 * @author fattoliu
 * @version V 1.0
 * @date 17/1/22 09:43.
 */
public class HTTPSHttpsURLConnectionActivity extends BaseActivity {


    @BindView(R.id.btn_call_https)
    Button btn_call_https;
    @BindView(R.id.tv_result)
    TextView tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();


    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_https_httpsurlconnection;
    }

    @Override
    protected String getTitleName() {
        return getString(R.string.title_https_httpsurlconnection);
    }

    @Override
    protected void initViewsAndDatas() {

    }

    @Override
    protected int getMenu() {
        return 0;
    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {

    }

    @Override
    protected void onBackKeyPressed() {

    }

    public void getSafeFromServer(final InputStream certStream) {
        String httpsUrl = "https://kyfw.12306.cn/otn";
        String hcboxHttpsUrl = "https://10.80.19.15:8443/service";
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... params) {
                String httpsUrl = params[0];
                try {
//                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//                    Certificate cert = certificateFactory.generateCertificate(certStream);
//                    LogUtil.LOGD("cert key ====== " + cert.getPublicKey().toString());
//                    // 生成一个包含服务器端证书的 keystore
//                    String keyStoreType = KeyStore.getDefaultType();
//                    LogUtil.LOGD("keystore type ====== " + keyStoreType);
//                    KeyStore keyStore = KeyStore.getInstance(keyStoreType);
//                    keyStore.load(null,null);
//                    keyStore.setCertificateEntry("cert", cert);
//
//                    // 用包含服务端正式的 keystore 生成一个TrustManager
//                    String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//                    LogUtil.LOGD("tmfAlgorithm ====== " + tmfAlgorithm);
//                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(tmfAlgorithm);
//                    trustManagerFactory.initViewsAndDatas(keyStore);
//
//                    // 生成一个使用我们的TrustManager的SSLContext
//                    SSLContext sslContext = SSLContext.getInstance("TLS");
//                    sslContext.initViewsAndDatas(null, trustManagerFactory.getTrustManagers(), null);

                    URL url = new URL(httpsUrl);
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setSSLSocketFactory(/*sslContext.getSocketFactory()*/HttpsUtil.getSSLSocketFactory(certStream));
                    httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            if ("10.80.19.15".equals(hostname) || "kyfw.12306.cn".equals(hostname)) {
                                return true;
                            }
                            return  false;
                        }
                    });
                    InputStream inputStream = httpsURLConnection.getInputStream();

                    StringBuffer out = new StringBuffer();
                    byte[] bytes = new byte[4096];
                    int n;
                    while((n = inputStream.read(bytes)) != -1) {
                        out.append(new String(bytes, 0, n));
                    }
                    inputStream.close();
                    return out.toString();

                } /*catch (CertificateException e) {
                    e.printStackTrace();
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                }*/ catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "";
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                tv_result.setText(result);
            }
        }.execute(httpsUrl);
    }

    @OnClick(R.id.btn_call_https)
    public void onClick() {
        String certName = "tomcat.crt";
        String hcboxcertName = "tomcat.cer";
        try {
            getSafeFromServer(new BufferedInputStream(getAssets().open(certName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
