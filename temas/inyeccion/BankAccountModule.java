
public class BankAccountModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BankAccountComparator.class).to(BankAccountComparatorById.class);
    }
}
