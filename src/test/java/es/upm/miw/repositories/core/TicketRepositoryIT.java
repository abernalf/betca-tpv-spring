package es.upm.miw.repositories.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.upm.miw.documents.core.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class TicketRepositoryIT {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void testFindByReference() {
        assertEquals("666666004", ticketRepository.findByReference("t2j_u9M9CisFmYGRFs1Uulgn7hI").getUser().getMobile());
        assertEquals(151, ticketRepository.findByReference("t2j_u9M9CisFmYGRFs1Uulgn7hI").getTicketTotal().doubleValue(), 10E-5);
    }

    @Test
    public void testFindByCreationDateGreaterThan() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2018-01-06");
        List<Ticket> ticketList = ticketRepository.findByCreationDateGreaterThan(date);
        assertTrue(ticketList.contains(ticketRepository.findByReference("t2j_u9M9CisFmYGRFs1Uulgn7hI")));
        assertTrue(ticketList.contains(ticketRepository.findByReference("6P0ISee_twnGEzf8qd1Bd5sGQqE")));
    }

    @Test
    public void testFindFirstByOrderByCreationDateDescIdDesc() {
    }

    @Test
    public void findByCreationDateBetween() throws ParseException {
        Date initialDate = new SimpleDateFormat("yyyy-mm-dd").parse("2017-01-11");
        List<Ticket> ticketListByRangeDates = this.ticketRepository.findByCreationDateBetween(initialDate, new Date());
        List<Ticket> ticketAllList = this.ticketRepository.findAll();
        assertTrue(ticketListByRangeDates.size() >= ticketAllList.size());
    }
    
    @Test
    public void testFindByIdAndDateBetween() throws ParseException {
    	Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-01-01 00:00:00");
    	List<Ticket> ticketListByIdAndRangeDates = ticketRepository.findByIdAndDatesBetween("article1", startDate, new Date());
    	assertNotNull(ticketListByIdAndRangeDates);
    	assertTrue(ticketListByIdAndRangeDates.size() >= 0);
    }

}
