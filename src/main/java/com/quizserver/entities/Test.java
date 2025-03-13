package com.quizserver.entities;

import java.util.List;

import com.quizserver.dto.TestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Long time;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)

    private List<Question> questions;

    public TestDTO getDto() {
        TestDTO testDTO = new TestDTO();
        testDTO.setId(id);
        testDTO.setTitle(title);
        testDTO.setDescription(description);
        testDTO.setTime(time);

        return testDTO;

    }

}
