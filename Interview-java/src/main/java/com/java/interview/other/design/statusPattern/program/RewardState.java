package com.java.interview.other.design.statusPattern.program;

/**
 * @author liaowenhui
 * @date 2023/7/27 15:21
 */
public abstract class RewardState {
    abstract boolean doReward(RewardStateContext context, Request request);
}
