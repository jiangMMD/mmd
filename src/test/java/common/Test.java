package common;

import com.mmd.mail.MailUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

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
    private MailUtil mailUtil;

    @org.junit.Test
    public void testTask() {

    }

    @org.junit.Test
    public void testThread() throws InterruptedException {
    }
}
