import com.maggies.Store;
import com.maggies.domain.Order;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class StoreTest {

    @Test
    public void testWhenStoreStartsItShouldHaveMenu() {
        Store store = new Store();
        assert(store.getProducts().size() == 5);
        assert(store.getExtras().size() == 3);
    }

    @Ignore // implementation when client name is given in order
    @Test
    public void testWhenStoreStartsItShouldHaveBonusProgramForClient() {

    }

    @Test
    public void testWhenStoreStartsItShouldAskForOrder() {
        // Given
        Store store = new Store();

        // When
        store.processOrder("large coffee with cold milk, small coffee with special roast, bacon roll");

        // Then
        Order afterProcessingOrder = store.getOrder();
        Assert.assertEquals(3, afterProcessingOrder.getProducts().size());
        Assert.assertEquals(2, afterProcessingOrder.getExtras().size());
        Assert.assertEquals(new Double(9.45), afterProcessingOrder.getTotal());

    }


}
