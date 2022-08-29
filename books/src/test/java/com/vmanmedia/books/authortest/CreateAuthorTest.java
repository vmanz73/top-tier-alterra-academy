package com.vmanmedia.books.authortest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.vmanmedia.books.dtos.CreateAuthorRequest;
import com.vmanmedia.books.repositories.AuthorRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")

public class CreateAuthorTest {
    private String name = "hayo";
    private String address = "Karawang";
    int author_id = 1;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AuthorRepository authorRepository;


    //Test Create author
    @Test
    @Order(1)
    public void succses_create_author() throws Exception {

        CreateAuthorRequest request = new CreateAuthorRequest();
        request.setName(this.name);
        request.setAddress(this.address);
        Date dob = Date.from(LocalDate.now().atStartOfDay(ZoneId.of("Asia/Jakarta")).toInstant());
        request.setDob(dob);

        mvc.perform(MockMvcRequestBuilders.post("/api/v1/authors")
                .content(new ObjectMapper().writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.author_id").value(this.author_id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(this.name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(this.address))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").exists());


    }

    //Test Get

    @Test
    public void success_get_authors() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void success_get_authors_detail() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/author/" + this.author_id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.author_id").value(this.author_id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").exists());


    }

    //update

    @Test
    public void success_update_author() throws Exception {
        this.name = "ini aku";
        this.address = "Jakarta";
        CreateAuthorRequest request = new CreateAuthorRequest();
        request.setName(this.name);
        request.setAddress(this.address);
        Date dob = Date.from(LocalDate.now().atStartOfDay(ZoneId.of("Asia/Jakarta")).toInstant());
        request.setDob(dob);
        mvc.perform(MockMvcRequestBuilders.patch("/api/v1/author/" + this.author_id)
                        .content(new ObjectMapper().writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.author_id").value(this.author_id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(this.name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value(this.address))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").exists());
    }

    //delete

    @Test
    public void success_delete_author() throws Exception {
        this.name = "other";
        this.address = "Surabaya";
        this.author_id = 2;
        succses_create_author();
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/author/" + this.author_id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
