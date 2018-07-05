package com.wqy.speech;

import com.alibaba.fastjson.JSON;
import com.iflytek.cloud.speech.*;

import javax.swing.*;
import java.util.Iterator;

/**
 * @author WordK 王秋叶
 * @create 2018-07-05 9:17
 * @desc
 **/
public class WordVoice {
    public static void WordToVoice(String strContent, JButton button) {
        // 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn
        SpeechUtility.createUtility(SpeechConstant.APPID + "=58493c56");
        // 1.创建SpeechSynthesizer对象
        SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer();
        // 2.合成参数设置，详见《iFlytek MSC Reference Manual》SpeechSynthesizer 类
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// 设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");// 设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");// 设置音量，范围0~100
        // 设置合成音频保存位置（可自定义保存位置），保存在“./iflytek.pcm”
        // 如果不需要保存合成音频，注释该行代码
        // mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./iflytek.pcm");
        // 合成监听器
        SynthesizerListener mSynListener = new SynthesizerListener() {
            // 会话结束回调接口，没有错误时，error为null
            public void onCompleted(SpeechError error) {
                button.setText("播放");
                button.setEnabled(true);
            }

            @Override
            public void onEvent(int i, int i1, int i2, int i3, Object o, Object o1) {

            }

            // 缓冲进度回调
            // percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
            public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
            }

            // 开始播放
            public void onSpeakBegin() {
                button.setText("正在播放");
            }

            // 暂停播放
            public void onSpeakPaused() {
            }

            // 播放进度回调
            // percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
            public void onSpeakProgress(int percent, int beginPos, int endPos) {
            }

            // 恢复播放回调接口
            public void onSpeakResumed() {
            }
        };
        // 3.开始合成
        mTts.startSpeaking(strContent, mSynListener);
    }

    public static SpeechRecognizer VoiceToWord(JTextArea text) {
        // 将“12345678”替换成您申请的APPID，申请地址：http://open.voicecloud.cn
        SpeechUtility.createUtility(SpeechConstant.APPID + "=5b3d6b8c");
        // 1.创建SpeechRecognizer对象
        SpeechRecognizer mIat = SpeechRecognizer.createRecognizer();
        // 2.设置听写参数，详见《iFlytek MSC Reference Manual》SpeechConstant类
        mIat.setParameter(SpeechConstant.DOMAIN, "iat");
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin ");
        // 听写监听器
        RecognizerListener mRecoListener = new RecognizerListener() {
            public void onResult(RecognizerResult results, boolean isLast) {
                //使用了阿里巴巴fastjson的架包来解析返回的json字符串。
                //对于这部分可能大家要看看fastjson的使用方法才看得懂哦

                Root root= JSON.parseObject(results.getResultString(), Root.class);
                Iterator<Ws> list=root.getWs().iterator();
                while(list.hasNext()){
                    Iterator<Cw> listCw=list.next().getCw().iterator();
                    while(listCw.hasNext()){
                        text.append(listCw.next().getW());
                    }
                }
            }
            // 会话发生错误回调接口
            public void onError(SpeechError error) {
                System.out.println("错误" + error.getErrorCode() + "  " + error.getErrorDesc());
            }
            // 开始录音
            public void onBeginOfSpeech() {
            }
            // 音量值0~30
            public void onVolumeChanged(int volume) {
            }
            // 结束录音
            public void onEndOfSpeech() {
            }
            // 扩展用接口
            public void onEvent(int eventType, int arg1, int arg2, String msg) {
            }
        };
        // 3.开始听写
        mIat.startListening(mRecoListener);
        return mIat;

    }
}
