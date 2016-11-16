package com.pengcheng.anotation;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pcliu on 16-11-16.
 */
@Table(name = "test_table")
public class TestTable implements Serializable{

    @Column(isPrimaryKey=true, name="id", sequenceName="seq_test_table_id", isMapping = true)
    private Long id;

    private String name;


    private Date createdDate;

    @Column(isMapping = false)
    private String nickName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
