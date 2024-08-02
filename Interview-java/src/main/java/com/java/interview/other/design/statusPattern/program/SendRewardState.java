package com.java.interview.other.design.statusPattern.program;

/**
 * 待返奖
 * @author liaowenhui
 * @date 2023/7/27 15:41
 */
public class SendRewardState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //待返奖流程
        return compensateReward(context, request);
    }

    public boolean compensateReward(RewardStateContext context, Request request) {
        //待返奖 处理
        return false;
    }
}
