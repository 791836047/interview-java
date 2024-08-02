package com.java.interview.other.design.statusPattern.program;

/**
 * 待校验状态
 * @author liaowenhui
 * @date 2023/7/27 15:22
 */
public class OrderCheckState extends RewardState {
    @Override
    public boolean doReward(RewardStateContext context, Request request) {
        //对进来的订单进行校验，判断是否用券，是否满足优惠条件等等
        return orderCheck(context, request);
    }

    public boolean orderCheck(RewardStateContext context, Request request){
        //待校验状态 处理
        return true;
    }
}
