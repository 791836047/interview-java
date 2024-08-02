package com.java.interview.other.design.statusPattern.program;

import lombok.Data;

/**
 *
 * @author liaowenhui
 * @date 2023/7/27 15:22
 */
@Data
public class Request {
    public Long userId;
    public Long orderId;

    public Request(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }
}
