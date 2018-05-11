package com.itmei.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by qiaodan on 2018/5/11.
 */
@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String []to,String subject,String content) throws Exception{
        logger.error("发送简单邮件");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try{
            sender.send(message);
            logger.info("发送简单邮件");
        }catch (Exception e){
            logger.error("发邮件异常");
            throw new Exception("发邮件错误");
        }
    }

    /**
     * 异步发送邮件，
     * @param to 收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @throws Exception
     */
    public void sendSimpleMailAsync(String []to,String subject,String content) throws Exception{
        logger.info("异步发送简单邮件");
        try {
            new Thread() {
                public void run() {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setFrom(from);
                    message.setTo(to);
                    message.setSubject(subject);
                    message.setText(content);
                    sender.send(message);
                    logger.info("已异步发送简单邮件");
                }
            }.start();
        }catch (Exception e) {
            logger.error("异步发邮件异常");
            throw new Exception("异步发邮件错误");
        }
    }
    /**
     * 发送html格式的邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String to, String subject, String content) throws Exception{
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            sender.send(message);
            logger.info("html邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
            throw new Exception("发送html邮件时发生异常！");
        }
    }
    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws Exception{
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            sender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
            throw new Exception("发送html邮件时发生异常！");
        }
    }
}
