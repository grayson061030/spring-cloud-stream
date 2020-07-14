package com.kongr.consumer;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class CouponOrder implements Serializable {
  private String code;
  private String type;
  private double price;
}
