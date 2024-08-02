package com.java.interview.other.design.statusPattern.program;

/**
 * 返奖失败流程
 *
 * @author liaowenhui
 * @date 2023/7/27 15:40
 */
public class RewardFailedState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //返奖失败流程
        return compensateReward(context, request);
    }

    public boolean compensateReward(RewardStateContext context, Request request) {
        //返奖失败 处理
        return true;
    }
}
