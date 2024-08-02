package com.java.interview.other.design.statusPattern.program;

/**
 * 预返奖状态
 * @author liaowenhui
 * @date 2023/7/27 15:39
 */
public class BeforeRewardCheckState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //预返奖状态
        return compensateReward(context, request);
    }

    public boolean compensateReward(RewardStateContext context, Request request) {
        //预返奖状态 处理
        return true;
    }
}
