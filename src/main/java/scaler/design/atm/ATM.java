package scaler.design.atm;

import scaler.design.amazon.Address;

public class ATM {
    int id;
    Address address;
    CardReader cardReader;
    Screen screen;
    KeyPad keyPad;
    CashDispenser cashDispenser;
    CashDeposit cashDeposit;
    ChequeDeposit chequeDeposit;
    BankService bankService;
}
