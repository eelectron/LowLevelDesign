package atm;

public class BankA implements BankService{

    @Override
    public boolean isUserValid(CardInfo cardInfo, String pin) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Customer getCustomerDetail(CardInfo cardInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TransactionDetail processTransaction(Transaction transaction, Customer customer) {
        // TODO Auto-generated method stub
        return null;
    }

}
