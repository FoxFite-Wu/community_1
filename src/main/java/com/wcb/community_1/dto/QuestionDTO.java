package com.wcb.community_1.dto;

import com.wcb.community_1.model.User;
import lombok.Data;

@Data
public class QuestionDTO {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer Creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;

}
