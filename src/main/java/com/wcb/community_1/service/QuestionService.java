package com.wcb.community_1.service;

import com.wcb.community_1.dto.QuestionDTO;
import com.wcb.community_1.mapper.QuestionMapper;
import com.wcb.community_1.mapper.UserMapper;
import com.wcb.community_1.model.Question;
import com.wcb.community_1.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>() ;
        for (Question question : questions) {
           User user = userMapper.findById(question.getCreator());
           QuestionDTO questionDTO = new QuestionDTO();
           BeanUtils.copyProperties(question,questionDTO);
           questionDTO.setUser(user);
           questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
