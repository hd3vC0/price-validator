package com.trevnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetProductPriceIntegrationTest {

    private final String ENDPOINT_PATH = "/product-price";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        String payload = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"date\": \"2020-06-14 10:00:00\",\n" +
                "    \"brandId\": 1\n" +
                "}";

        perform(payload, 35.50f);

    }

    @Test
    void test2() throws Exception {
        String payload = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"date\": \"2020-06-14 16:00:00\",\n" +
                "    \"brandId\": 1\n" +
                "}";

        perform(payload, 25.45f);

    }

    @Test
    void test3() throws Exception {
        String payload = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"date\": \"2020-06-14 21:00:00\",\n" +
                "    \"brandId\": 1\n" +
                "}";

        perform(payload, 35.50f);

    }

    @Test
    void test4() throws Exception {
        String payload = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"date\": \"2020-06-15 10:00:00\",\n" +
                "    \"brandId\": 1\n" +
                "}";

        perform(payload, 30.50f);

    }

    @Test
    void test5() throws Exception {
        String payload = "{\n" +
                "    \"productId\": 35455,\n" +
                "    \"date\": \"2020-06-16 21:00:00\",\n" +
                "    \"brandId\": 1\n" +
                "}";

        perform(payload, 38.95f);

    }

    private void perform(String payload, float expectedValue) throws Exception {
        mockMvc.perform(
                        post(ENDPOINT_PATH)
                                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                                .content(payload)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(expectedValue));
    }
}
