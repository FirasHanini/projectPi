/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisateur;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Utilisateur 2
 */
public class MailValidation {
    
    // Vérifie si l'adresse e-mail est valide
    public static boolean isValidEmail(String email) {
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }

    
    public static String generateVerificationCode() {
        Date date = new Date();
        
        
        SimpleDateFormat heure = new SimpleDateFormat("HH");
        SimpleDateFormat minu = new SimpleDateFormat("mm");
        
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat day = new SimpleDateFormat("dd");
       
        String heureString = heure.format(date);
        String minuString = minu.format(date);
        String monthString = month.format(date);
        String dayString = day.format(date);
        
        
       
        int heureInt = Integer.parseInt(heureString);
        int minuInt = Integer.parseInt(minuString);
        int monthInt = Integer.parseInt(monthString);
        int dayInt = Integer.parseInt(dayString);
        
        
        
        return Integer.toString(heureInt*minuInt*360+dayInt*monthInt*5);
    }

   
    public static void sendVerificationCode(String recipientEmail, String verificationCode) {
        
        String host = "smtp.gmail.com";
        String username = "ecoartteampi@gmail.com";
        String password = "hoxb htnf agqp blhk"; 

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Créer un message e-mail
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Code de vérification");

            
            message.setText("Votre code de vérification est : " + verificationCode);

            
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
    
}
