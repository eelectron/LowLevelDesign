package scaler.design.atm;

public interface BankService {
    public boolean isUserValid(CardInfo cardInfo, String pin);
    public Customer getCustomerDetail(CardInfo cardInfo);
    public TransactionDetail processTransaction(Transaction transaction, Customer customer);
}
