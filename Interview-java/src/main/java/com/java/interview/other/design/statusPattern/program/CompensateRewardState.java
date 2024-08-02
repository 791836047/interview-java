package com.java.interview.other.design.statusPattern.program;

/**
 * 待补偿状态
 * @author liaowenhui
 * @date 2023/7/27 15:23
 */
public class CompensateRewardState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //返奖失败，需要对用户进行返奖补偿
       return compensateReward(context, request);
    }

    public boolean compensateReward(RewardStateContext context, Request request){
        //待补偿状态 处理
        return true;
    }
}
