package App.Entities.Accounts.OperationsLogs;

import App.Entities.Accounts.TypeOperations;
import App.Support.Utilities;

import java.text.NumberFormat;
import java.util.Locale;

import static App.Entities.Accounts.TypeOperations.*;

public class Log {

    private int idLog;
    private String numAccount;
    private String nameClient;
    private double value;
    private TypeOperations typeOp;
    private String date;
    private String hours;
    private String sender_receiver;

    // para o db
    public Log(String numAccount, String nameClient, double value, TypeOperations typeOp, String date, String hours, String sender_receiver) {
        this.numAccount = numAccount;
        this.nameClient = nameClient;
        this.value = value;
        this.typeOp = typeOp;
        this.date = date;
        this.hours = hours;
        this.sender_receiver = sender_receiver;
    }

    // de volta do db
    public Log(int idLog, String numAccount, String nameClient, double value, TypeOperations typeOp, String date, String hours, String sender_receiver) {
        this.idLog = idLog;
        this.numAccount = numAccount;
        this.nameClient = nameClient;
        this.value = value;
        this.typeOp = typeOp;
        this.date = date;
        this.hours = hours;
        this.sender_receiver = sender_receiver;
    }

    public String toString(){

        Locale ptBr = new Locale("pt", "BR");

        StringBuilder log = new StringBuilder(
                "\n"+ idLog + "\t" + numAccount + "\t" + nameClient + "\t" + date + "\t" + hours + "\tOp: "
        );

        switch (this.typeOp){
            case DEPOSIT -> log
                    .append(DEPOSIT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value));

            case WITHDRAW -> log
                    .append(WITHDRAW.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value));

            case TRANSFER_SENT -> log
                    .append(TRANSFER_SENT.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value))
                    .append("\tDest: ")
                    .append(this.sender_receiver);

            case TRANSFER_RECEIVED -> log
                    .append(TRANSFER_RECEIVED.getOperation())
                    .append("\t")
                    .append(NumberFormat.getCurrencyInstance(ptBr).format(this.value))
                    .append("\tRem: ").append(this.sender_receiver);

            default -> log.append("Unknown");
        }
        return log.toString();
    }



    public int getIdLog() {
        return idLog;
    }
    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }
    public String getNumAccount() {
        return numAccount;
    }
    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }
    public String getNameClient() {
        return nameClient;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public TypeOperations getTypeOp() {
        return typeOp;
    }
    public void setTypeOp(TypeOperations typeOp) {
        this.typeOp = typeOp;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHours() {
        return hours;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
    public String getSender_receiver() {
        return sender_receiver;
    }
    public void setSender_receiver(String sender_receiver) {
        this.sender_receiver = sender_receiver;
    }
}
