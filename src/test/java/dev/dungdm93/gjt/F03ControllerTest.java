package dev.dungdm93.gjt;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/gjt-servlet.xml"})
public class F03ControllerTest {
    @Autowired
    private F03Controller f03Controller;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(f03Controller)
                .build();
    }

    @Test
    public void method() throws Exception {
        mockMvc.perform(get("/F03").param("lhs", "10").param("rhs", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("boundedMultiply(10, 3) = 30"));

        mockMvc.perform(get("/F03").param("lhs", "25").param("rhs", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("boundedMultiply(25, 5) = 100"));

        mockMvc.perform(get("/F03").param("lhs", "5").param("rhs", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("boundedMultiply(5, -3) = 0"));
    }
}
