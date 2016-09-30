//package application;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ApplicationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    //This is an initial dummy test which can be removed when we get proper integration tests
//    @Test
//    public void showOpportunityLinksTest() throws Exception {
//        mockMvc.perform(get("/opportunitylinks"))
//                .andExpect(content().string(containsString("Opportunity Links")));
//    }
//
//
//
//}
