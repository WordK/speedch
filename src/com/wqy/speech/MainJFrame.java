package com.wqy.speech;

import com.iflytek.cloud.speech.SpeechRecognizer;

import javax.swing.*;

/**
 * @author WordK 王秋叶
 * @create 2018-07-05 9:15
 * @desc MainJFrame
 **/
public class MainJFrame extends JFrame {


    SpeechRecognizer mIat = null;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        BtnStop.setEnabled(false);
        BtnEnd.setEnabled(false);
        TxtVoiceToWord.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtWordToVoice = new javax.swing.JTextArea();
        BtnPlay = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnStart = new javax.swing.JButton();
        BtnStop = new javax.swing.JButton();
        BtnEnd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtVoiceToWord = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("多媒体实验２"); // NOI18N

        jLabel2.setText("文字转语音:");

        TxtWordToVoice.setColumns(20);
        TxtWordToVoice.setLineWrap(true);
        TxtWordToVoice.setRows(5);
        jScrollPane1.setViewportView(TxtWordToVoice);

        BtnPlay.setText("播放");
        BtnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPlayActionPerformed(evt);
            }
        });

        jLabel3.setText("语音转文字:");

        BtnStart.setText("开始录制");
        BtnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStartActionPerformed(evt);
            }
        });

        BtnStop.setText("暂停录制");
        BtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStopActionPerformed(evt);
            }
        });

        BtnEnd.setText("结束录制");
        BtnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEndActionPerformed(evt);
            }
        });

        TxtVoiceToWord.setColumns(20);
        TxtVoiceToWord.setRows(5);
        jScrollPane2.setViewportView(TxtVoiceToWord);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(297, 297, 297)
                                                        .addComponent(BtnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(BtnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                                                .addComponent(BtnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(72, 72, 72)
                                                                .addComponent(BtnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addContainerGap(22, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(BtnPlay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BtnStart)
                                        .addComponent(BtnStop)
                                        .addComponent(BtnEnd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    //文字转语音中的播放按钮的执行事件
    private void BtnPlayActionPerformed(java.awt.event.ActionEvent evt) {
        String strWord = TxtWordToVoice.getText().toString();
        if (!strWord.isEmpty()) {
            BtnPlay.setEnabled(false);
            BtnPlay.setText("正在缓冲...");
            WordVoice.WordToVoice(strWord, BtnPlay);
        }
    }

    //语音转文字的开始录音按钮的事件
    private void BtnStartActionPerformed(java.awt.event.ActionEvent evt) {
        BtnStart.setEnabled(false);
        BtnStart.setText("正在录音...");
        BtnStop.setEnabled(true);
        BtnEnd.setEnabled(true);
        //当为空时，说明是没有录过音或者已经按了结束录音，此时为第二次录音，所以应该先置空
        if(mIat==null){
            TxtVoiceToWord.setText("");
        }
        mIat = WordVoice.VoiceToWord(TxtVoiceToWord);
    }

    //语音转文字的暂停录音按钮的事件
    private void BtnStopActionPerformed(java.awt.event.ActionEvent evt) {
        BtnStart.setEnabled(true);
        BtnStart.setText("继续录音");
        BtnStop.setEnabled(false);
        if (mIat != null) {
            mIat.stopListening();
        }
    }
    //语音转文字的结束录音按钮的事件
    private void BtnEndActionPerformed(java.awt.event.ActionEvent evt) {
        BtnStart.setEnabled(true);
        BtnStart.setText("开始录音");
        BtnStop.setEnabled(false);
        BtnEnd.setEnabled(false);
        if (mIat != null) {
            mIat.stopListening();
            mIat = null;
        }
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting
        // code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
         * html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton BtnEnd;
    private javax.swing.JButton BtnPlay;
    private javax.swing.JButton BtnStart;
    private javax.swing.JButton BtnStop;
    private javax.swing.JTextArea TxtVoiceToWord;
    private javax.swing.JTextArea TxtWordToVoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration

}