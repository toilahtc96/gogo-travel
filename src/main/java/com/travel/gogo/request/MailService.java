package com.travel.gogo.request;

import com.travel.gogo.constans.MyConstants;
import com.travel.gogo.entity.Registrations;
import com.travel.gogo.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.vault.annotation.VaultPropertySource;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@VaultPropertySource("secret/gogo")
public class MailService {
    public final JavaMailSender emailSender;
    public final RegistrationService registrationService;
    @Autowired
    Environment env;

    private void sendSimpleEmail(List<Registrations> listSendMail) {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(env.getProperty(MyConstants.CUSTOMER_EMAIL));
        message.setSubject("Khách Hàng Mới Đăng Ký Trên Website");
        StringBuilder content = new StringBuilder();
        listSendMail.forEach( customer -> {
            content
                    .append("Tên: ")
                    .append(customer.getName())
                    .append("\n")
                    .append("Tour quan tâm: ")
                    .append(customer.getTourName())
                    .append("\n")
                    .append("Số điện thoại liên hệ: ")
                    .append(customer.getPhone())
                    .append("\n\n");
        });
        content.append("Đây là thông báo tự động, Không cần trả lời tin nhắn này");

        message.setText(content.toString());
        // Send Message!
        this.emailSender.send(message);
        registrationService.updateSendMail(listSendMail);
    }

    @Scheduled(cron = "0 0 8 * * ?") // Every day at 8:00 AM
    public void morningMail() {
        // Your morning task logic here
        System.out.println("Morning task executed!");
        List<Registrations> listNotSendMail = registrationService.getRegistrationWithOutSendMail();
        if (listNotSendMail.isEmpty()) {
            log.info("Don't Have new Registration in 8:00 AM {}", LocalDate.now());
            return;
        }
        sendSimpleEmail(listNotSendMail);
    }

    @Scheduled(cron = "0 0 20 * * ?") // Every day at 8:00 PM
    public void eveningMail() {
        // Your evening task logic here
        System.out.println("Evening task executed!");
        List<Registrations> listNotSendMail = registrationService.getRegistrationWithOutSendMail();
        if (listNotSendMail.isEmpty()) {
            log.info("Don't Have new Registration in 8:00 PM {}", LocalDate.now());
            return;
        }
        sendSimpleEmail(listNotSendMail);
    }
}
