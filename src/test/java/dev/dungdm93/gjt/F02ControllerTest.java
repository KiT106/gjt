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
public class F02ControllerTest {
    @Autowired
    private F02Controller f02Controller;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(f02Controller)
                .build();
    }

    @Test
    public void method() throws Exception {
        mockMvc.perform(get("/F02").param("lhs", "10").param("rhs", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));
    }
}
