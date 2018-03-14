package es.upm.miw.resources;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class VoucherResourceFunctionalTesting {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
    private RestService restService;
	
	@Test
    public void testReadVoucher() {
        String json=restService.loginAdmin().restBuilder(new RestBuilder<String>()).clazz(String.class).path(VoucherResource.VOUCHERS).path(VoucherResource.REFERENCE).expand("1").get().build();
        System.out.println("------------>"+json);
    }
    
    @Test
    public void testReadVoucherAll() {
        String json=restService.loginAdmin().restBuilder(new RestBuilder<String>()).clazz(String.class).path(VoucherResource.VOUCHERS).get().build();
        System.out.println("------------>"+json);
    }

}