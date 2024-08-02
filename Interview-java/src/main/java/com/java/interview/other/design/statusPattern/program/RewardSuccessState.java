package com.java.interview.other.design.statusPattern.program;

/**
 * 返奖结束流程
 * @author liaowenhui
 * @date 2023/7/27 15:43
 */
public class RewardSuccessState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //返奖结束流程
        return compensateReward(context, request);
    }

    public boolean compensateReward(RewardStateContext context, Request request) {
        //完成状态 处理
        return true;
    }
}
