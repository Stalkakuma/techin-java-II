package lt.techin.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CinemaTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testEndpoint() throws Exception {
        mockMvc.perform(get("/seats"))
                .andExpect(status().isOk());
    }

    @Test
    public void testEndpointAvailableSeats() throws Exception {
        mockMvc.perform(get("/seats"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                        {
                          "rows": 9,
                          "columns": 9,
                          "seats": [
                            {"row": 1, "column": 1},
                            {"row": 1, "column": 2},
                            {"row": 1, "column": 3},
                            {"row": 1, "column": 4},
                            {"row": 1, "column": 5},
                            {"row": 1, "column": 6},
                            {"row": 1, "column": 7},
                            {"row": 1, "column": 8},
                            {"row": 1, "column": 9},
                            {"row": 2, "column": 1},
                            {"row": 2, "column": 2},
                            {"row": 2, "column": 3},
                            {"row": 2, "column": 4},
                            {"row": 2, "column": 5},
                            {"row": 2, "column": 6},
                            {"row": 2, "column": 7},
                            {"row": 2, "column": 8},
                            {"row": 2, "column": 9},
                            {"row": 3, "column": 1},
                            {"row": 3, "column": 2},
                            {"row": 3, "column": 3},
                            {"row": 3, "column": 4},
                            {"row": 3, "column": 5},
                            {"row": 3, "column": 6},
                            {"row": 3, "column": 7},
                            {"row": 3, "column": 8},
                            {"row": 3, "column": 9},
                            {"row": 4, "column": 1},
                            {"row": 4, "column": 2},
                            {"row": 4, "column": 3},
                            {"row": 4, "column": 4},
                            {"row": 4, "column": 5},
                            {"row": 4, "column": 6},
                            {"row": 4, "column": 7},
                            {"row": 4, "column": 8},
                            {"row": 4, "column": 9},
                            {"row": 5, "column": 1},
                            {"row": 5, "column": 2},
                            {"row": 5, "column": 3},
                            {"row": 5, "column": 4},
                            {"row": 5, "column": 5},
                            {"row": 5, "column": 6},
                            {"row": 5, "column": 7},
                            {"row": 5, "column": 8},
                            {"row": 5, "column": 9},
                            {"row": 6, "column": 1},
                            {"row": 6, "column": 2},
                            {"row": 6, "column": 3},
                            {"row": 6, "column": 4},
                            {"row": 6, "column": 5},
                            {"row": 6, "column": 6},
                            {"row": 6, "column": 7},
                            {"row": 6, "column": 8},
                            {"row": 6, "column": 9},
                            {"row": 7, "column": 1},
                            {"row": 7, "column": 2},
                            {"row": 7, "column": 3},
                            {"row": 7, "column": 4},
                            {"row": 7, "column": 5},
                            {"row": 7, "column": 6},
                            {"row": 7, "column": 7},
                            {"row": 7, "column": 8},
                            {"row": 7, "column": 9},
                            {"row": 8, "column": 1},
                            {"row": 8, "column": 2},
                            {"row": 8, "column": 3},
                            {"row": 8, "column": 4},
                            {"row": 8, "column": 5},
                            {"row": 8, "column": 6},
                            {"row": 8, "column": 7},
                            {"row": 8, "column": 8},
                            {"row": 8, "column": 9},
                            {"row": 9, "column": 1},
                            {"row": 9, "column": 2},
                            {"row": 9, "column": 3},
                            {"row": 9, "column": 4},
                            {"row": 9, "column": 5},
                            {"row": 9, "column": 6},
                            {"row": 9, "column": 7},
                            {"row": 9, "column": 8},
                            {"row": 9, "column": 9}
                          ]
                        }
                        
                        """, true));
    }
}
