/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author Elyes
 */
public class Chat {
    private int idChat;
    private String UserName,Message,TimeChat;

    public Chat(int idChat, String UserName, String Message, String TimeChat) {
        this.idChat = idChat;
        this.UserName = UserName;
        this.Message = Message;
        this.TimeChat = TimeChat;
    }

    public Chat(String UserName, String Message, String TimeChat) {
        this.UserName = UserName;
        this.Message = Message;
        this.TimeChat = TimeChat;
    }

    public Chat() {
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getTimeChat() {
        return TimeChat;
    }

    public void setTimeChat(String TimeChat) {
        this.TimeChat = TimeChat;
    }

    @Override
    public String toString() {
        return "Chat{" + "idChat=" + idChat + ", UserName=" + UserName + ", Message=" + Message + ", TimeChat=" + TimeChat + '}';
    }
    
    

    
    
}
