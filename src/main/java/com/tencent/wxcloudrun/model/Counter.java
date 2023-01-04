package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("Counters")
public class Counter implements Serializable {

  private Integer id;

  private Integer count;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
