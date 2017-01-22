package com.fatto.android.ui.record;

import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.fatto.android.R;
import com.fatto.android.base.BaseActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * TODO 录制AAC 音频
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/11/1 14:00.
 */
public class AACRecordActivity extends BaseActivity {

    private final int SAMPLE_RATE = 8000;

    @BindView(R.id.btn_mian_startPlay)
    Button btn_start;
    @BindView(R.id.btn_mian_stopPlay)
    Button btn_stop;
    @BindView(R.id.imageButtonDial)
    ImageButton iv_dial;

    private AudioRecord record_instance;
    private boolean is_start_record;
    private FileOutputStream fos;
    private MediaPlayer media_player;
    private String record_file = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplayHomeAsUpEnabled();
    }

    @Override
    protected int getContentViewResource() {
        return R.layout.act_aac_record;
    }

    @Override
    protected String getTitleResource() {
        return getString(R.string.act_title_aac_record);
    }

    @Override
    protected void init() {
        iv_dial.setBackgroundResource(R.drawable.ic_btn_speak_normal);
        iv_dial.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_CANCEL:
                        break;

                    default:
                        break;
                }
                return false;
            }});
    }

    @Override
    protected int getMenuResource() {
        return 0;
    }

    @Override
    protected void onMenuItemSelected(MenuItem item) {

    }

    @Override
    protected void onFinish() {

    }



    @OnClick({R.id.btn_mian_startPlay, R.id.btn_mian_stopPlay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mian_startPlay:

                break;
            case R.id.btn_mian_stopPlay:

                break;
        }
    }

    public void startRecord() {
        if (!Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED)) {
            Toast.makeText(AACRecordActivity.this, "请插入SD卡！", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        try {
            // mRecordFileName = Environment.getExternalStorageDirectory()
            // .toString()
            // + "/testAAC"
            // + System.currentTimeMillis()
            // + ".aac";

            record_file = Environment.getExternalStorageDirectory()
                    .toString() + "/testAAC.aac";

            fos = new FileOutputStream(record_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("fos = " + fos);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                VoAACEncoder vo = new VoAACEncoder();
//                vo.Init(SAMPLE_RATE, 16000, (short) 1, (short) 1);// 采样率:16000,bitRate:32k,声道数:1，编码:0.raw
//                // 1.ADTS
//                int min = AudioRecord.getMinBufferSize(SAMPLE_RATE,
//                        AudioFormat.CHANNEL_IN_MONO,
//                        AudioFormat.ENCODING_PCM_16BIT);
//                if (min < 2048) {
//                    min = 2048;
//                }
//                byte[] tempBuffer = new byte[2048];
//                record_instance = new AudioRecord(MediaRecorder.AudioSource.MIC,
//                        SAMPLE_RATE, AudioFormat.CHANNEL_IN_MONO,
//                        AudioFormat.ENCODING_PCM_16BIT, min);
//                record_instance.startRecording();
//                is_start_record = true;
//                while (is_start_record) {
//                    int bufferRead = record_instance.read(tempBuffer, 0, 2048);
//                    byte[] ret = vo.Enc(tempBuffer);
//                    if (bufferRead > 0) {
//                        System.out.println("ret:" + ret.length);
//                        try {
//                            fos.write(ret);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                record_instance.stop();
//                record_instance.release();
//                record_instance = null;
//                vo.Uninit();
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

    }

    public void stopRecord() {
        is_start_record = false;
    }
}
