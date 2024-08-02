package com.java.interview.other.design.statusPattern.program;

/**
 * 返奖状态执行的上下文
 * @author liaowenhui
 * @date 2023/7/27 15:21
 */
public class RewardStateContext {
    private RewardState rewardState;
    private boolean isSuccess;

    public void setRewardState(RewardState currentState) {
        this.rewardState = currentState;
    }

    public void echo(RewardStateContext context, Request request) {
        isSuccess = rewardState.doReward(context, request);
    }

    public boolean isResultFlag() {
        return isSuccess;
    }


}
