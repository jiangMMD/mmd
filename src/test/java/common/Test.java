package common;

import com.mmt.service.BookService;
import com.mmt.tasks.BookTask;
import com.mmt.tasks.ClearUnUsedIemi;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring.xml", "classpath:springMvc.xml"})
public class Test {
    private MockHttpServletRequest request;
    private MockHttpSession session;
    private MockHttpServletResponse response;

    @Before
    public void before() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
    }

    @Resource
    private BookTask bookTask;

    @Autowired
    private BookService bookService;

    @Autowired
    private ClearUnUsedIemi clearUnUsedIemi;

    @org.junit.Test
    public void testTask() {
        try {
            clearUnUsedIemi.task();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void testThread() throws InterruptedException {
    }
}
