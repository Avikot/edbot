package com.diploma.edbot.metadata;

import com.diploma.edbot.IntegrationTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MetadataControllerIT {

        private MockMvc mockMvc;

        @Autowired
        private WebApplicationContext wac;

        @Before
        public void setUp() {
            this.mockMvc = MockMvcBuilders
                    .webAppContextSetup(wac)
                    .build();
        }

        @Test
        @Commit
        public void first_test() throws Exception {
            MockHttpSession session = new MockHttpSession();

            ResultActions resultActions = mockMvc.perform(get("/api/v1/metadata/faculties")
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .session(session))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk());
        }
}
